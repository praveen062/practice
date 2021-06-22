package com.example.datastructures.numbers;

import java.util.Arrays;

//longest increasing subsequence
public class LIS {
	
	public static void main(String[] args) {
		int a1[] = {-3,3,4,-1,0,6,2,3};
		new LIS().lis(a1);
	}
	
	public void lis(int[] a) {
		 int temp[] = getLongestIncreasingSubsequence(a);
		 int max = Integer.MIN_VALUE;
		 int maxIndex = -1;
		 for(int i=0;i<a.length;i++) {
			 if(temp[i] > max) {
				 max = temp[i];
				 maxIndex = i;
			 }
		 }
		 if(maxIndex != -1 ) {
			 int tempMax = max;
			 for(int i=maxIndex; i>=0 && tempMax > 0;i--) {
				 if(temp[i] == tempMax) {
					 System.out.print(a[i]+" ");
					 tempMax--;
				 }
			 }
			 System.out.println();
		 }
		
	}
	
	int[] getLongestIncreasingSubsequence(int[] a) {
		int temp[] = new int[a.length];
		Arrays.fill(temp, 1);
		if(a.length > 2) {
			for(int j=1;j<a.length;j++) {
				for(int i=0; i<j; i ++) {
					if(a[i]< a[j]) {
						temp[j] = Math.max(temp[j], temp[i]+1);
					}
				}
			}
		}
		for(int i=0;i<temp.length;i++) {
			System.out.print(temp[i]+"->");
			
		}
		System.out.println();
		return temp;
	}

}
