package com.example.datastructures.string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Time {

    public static void main(String []args){
    	Minute m1 = new Minute("16", "00");
    	Minute m2 = new Minute("10", "30");
    	Minute m3 = new Minute("20", "45");
    	Minute m4 = new Minute("10", "00");
    	Minute m5 = new Minute("9", "00");
    	List<Minute> l = new ArrayList<Minute>();
    	l.add(m1);
    	l.add(m2);
    	l.add(m3);
    	l.add(m4);
    	l.add(m5);
    	Collections.sort(l,new MinuteCompa());
    	System.out.println(l);
    	
    	Queue<Minute> a = new LinkedList<Minute>();
    	
       
    }
    
}
