package solutions.leetcode.solution732;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MyCalendarThree {
    private final List<Part> list;
    private int max;
    public MyCalendarThree() {
        list = new ArrayList<>();
        max = 0;
    }

    public int book(int start, int end) {
        int first = Collections.binarySearch(list, new Part(start, 0));
        int second = Collections.binarySearch(list, new Part(end, 0));

        if (second < 0) {
            second = - second - 1;
            if (second == 0)
                list.add(second, new Part(end, 0));
            else
                list.add(second, new Part(end, list.get(second - 1).getNumber()));
        }

        if (first < 0) {
            first = - first - 1;
            second++;
            if (first == 0)
                list.add(first, new Part(start, 0));
            else
                list.add(first, new Part(start, list.get(first - 1).getNumber()));
        }

        for (int i = first; i < second; i++) {
            list.get(i).increaseNumber();
            max = Math.max(list.get(i).getNumber(), max);
        }

        return max;
    }

    private class Part implements Comparable<Part> {
        int start;
        int number;

        public Part(int start, int number) {
            this.start = start;
            this.number = number;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public void increaseNumber() {
            number++;
        }

        @Override
        public int compareTo(Part part) {
            return this.getStart() - part.getStart();
        }
    }

    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();
        System.out.println(myCalendarThree.book(47,50));
        System.out.println(myCalendarThree.book(1, 10));
        System.out.println(myCalendarThree.book(27, 36));
        System.out.println(myCalendarThree.book(40, 47));
    }
}
