package com.example.datastructures.string;

public class IndexPair {
	int begin;
	int end;

	public IndexPair(int index, int maxValue) {
		super();
		this.begin = index;
		this.end = maxValue;
	}

	public int interval() {
		// TODO Auto-generated method stub
		return end - begin;
	}

	
}
