package com.learn.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

class StockSpanner {

    private List<Integer> stockValue = new ArrayList<Integer>();
    public StockSpanner() {

    }
    
    public int next(int price) {
        int n = 1;
        stockValue.add(new Integer(price));
        for(int i = stockValue.size()-2 ; i >=0; i--)
        {
            if(stockValue.get(i).intValue() >= price)
               n++;
        }
        return n;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
