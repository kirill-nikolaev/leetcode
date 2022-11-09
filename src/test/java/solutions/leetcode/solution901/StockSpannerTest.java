package solutions.leetcode.solution901;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StockSpannerTest {

    @Test
    void Test1() {
        List<Integer> list = new ArrayList<>();
        StockSpanner stockSpanner = new StockSpanner();
        list.add(stockSpanner.next(100));
        list.add(stockSpanner.next(80));
        list.add(stockSpanner.next(60));
        list.add(stockSpanner.next(70));
        list.add(stockSpanner.next(60));
        list.add(stockSpanner.next(75));
        list.add(stockSpanner.next(85));

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(1);
        expectedList.add(4);
        expectedList.add(6);

        assertEquals(expectedList, list);
    }

    @Test
    void Test2() {
        List<Integer> list = new ArrayList<>();
        StockSpanner stockSpanner = new StockSpanner();
        list.add(stockSpanner.next(1));
        list.add(stockSpanner.next(79));
        list.add(stockSpanner.next(34));
        list.add(stockSpanner.next(21));
        list.add(stockSpanner.next(34));
        list.add(stockSpanner.next(16));
        list.add(stockSpanner.next(59));
        list.add(stockSpanner.next(63));
        list.add(stockSpanner.next(72));
        list.add(stockSpanner.next(51));

        List<Integer> expectedList = new ArrayList<>();
        expectedList.add(1);
        expectedList.add(2);
        expectedList.add(1);
        expectedList.add(1);
        expectedList.add(3);
        expectedList.add(1);
        expectedList.add(5);
        expectedList.add(6);
        expectedList.add(7);
        expectedList.add(1);

        assertEquals(expectedList, list);
    }
}