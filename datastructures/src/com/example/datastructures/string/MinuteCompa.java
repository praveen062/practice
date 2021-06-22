package com.example.datastructures.string;

import java.util.Comparator;

public class MinuteCompa implements Comparator<Minute>{
	@Override
	public int compare(Minute arg0, Minute arg1) {
		// 
		if( arg0.hour == arg1.hour) {
			return arg0.minute - arg1.minute;
		}else {
			return arg0.hour - arg1.hour;
		}
	}
}
