package com.example.datastructures.string;

import java.util.Arrays;

public class FindShortestSubString {
	public static void main(String[] args) {
		String input1 = "this is a test string";
		String input2 = "tist";
		int min = Integer.MAX_VALUE;
		int start = -1;
		int end = -1;
		
		for(int i =0; i< input1.length(); i++) {
			int[] indexes = new int[input2.length()];
			Arrays.fill(indexes, -1);
				for(int j=0; j<= i;j++) {
					
					for(int k =0 ;k< input2.length() ; k++) {
						int start1 = j; 
						int end1 = i;
//					System.out.println("j "+j+" k "+ k + "indexes[k]  "+indexes[k] );
						while(start1 <= end1) {
							if(input1.charAt(start1) == input2.charAt(k)) {
								indexes[k] = start1;
							}
							start1++;
						}
					
					}
				System.out.println(Arrays.toString(indexes));
				
			}
		
			
		}
		System.out.println("start = "+start+" end = "+end +"  min "+min );
		
	}

}
