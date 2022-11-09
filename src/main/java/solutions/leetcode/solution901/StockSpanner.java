package solutions.leetcode.solution901;


import java.util.*;


public class StockSpanner {
    Stack<PriceInfo> stock;
    int count;

    public StockSpanner() {
        stock = new Stack<>();
    }

    public int next(int price) {
        count++;
        PriceInfo lastStock;

        while (stock.size() != 0) {
            if (stock.peek().price < price)
                stock.pop();
            else
                break;
        }

        int result;

        if (stock.size() == 0) {
            result = count;
            stock.push(new PriceInfo(price, count));
        } else if (stock.peek().price == price) {
            lastStock = stock.pop();
            if (stock.size() == 0) {
                result = count;
            } else {
                result = count - stock.peek().lastDay;
            }
            lastStock.lastDay = count;
            stock.push(lastStock);

        } else {
            result = count - stock.peek().lastDay;
            stock.push(new PriceInfo(price, count));
        }

        return result;
    }

    private class PriceInfo {
        int price;
        int firstDay;
        int lastDay;

        public PriceInfo(int price, int firstDay) {
            this.price = price;
            this.firstDay = firstDay;
            this.lastDay = firstDay;
        }
    }
}
