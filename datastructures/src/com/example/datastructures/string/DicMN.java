package com.example.datastructures.string;

import java.util.HashMap;
import java.util.Map;

public class DicMN {

    Map<String, Words> st = new HashMap();

    public class Words {
        int min;
        int max;
        public Words(int index) {
            min = index;
            max = index;
        }
    }

    public int findMinInterval(String[] sw) {

        int begin = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int i = 0; i < sw.length; i++) {
            if (st.containsKey(sw[i])) {
                Words w = st.get(sw[i]);
                begin = Math.min(begin, w.min);
                end = Math.max(end, w.max);
            }
        }

        if (begin != Integer.MAX_VALUE) {
            return (end - begin) + 1;
        }
        return 0;
    }

    public void put(String[] dw) {

        for (int i = 0; i < dw.length; i++) {
            if (!st.containsKey(dw[i])) {
                st.put(dw[i], new Words(i));
            }
            else {
                Words w = st.get(dw[i]);
                w.min = Math.min(w.min, i);
                w.max = Math.max(w.max, i);
            }
        }
    }

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        DicMN dic = new DicMN();
        String[] arr1 = { "one", "two", "three", "four", "five", "six", "seven", "eight" };
        dic.put(arr1);
        String[] arr2 = { "two", "five" };
        System.out.print("Interval:" + dic.findMinInterval(arr2));
    }
}