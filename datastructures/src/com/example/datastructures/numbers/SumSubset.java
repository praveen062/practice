package com.example.datastructures.numbers;

public class SumSubset {
	public static void main(String[] args) {
		int a[] = {2,3,7,8,10};
		int total = 11;
		boolean T[][] = new boolean[a.length+1][total+1];
		for(int i=0;i<a.length;i++)
			T[i][0] = true;
		
		for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - a[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - a[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }
		
		for(int i = 0 ; i<=a.length;i++) {
			for(int j=0;j<=total;j++) {
				System.out.print(T[i][j]+" ");
			}
			System.out.println();
		}
		
		int i = a.length;
		int j = total;
		while(j > 0 && i > 0) {
			System.out.println("j "+j+" i "+i);
			if(T[i][j] == true && T[i-1][j] == T[i][j]) {
				i=i-1;
			}else {
				if(T[i][j] == true)
					System.out.println(a[i-1]);
				j = j-a[i-1];
				i=i-1;
				 
			}
		}
		
		}
	
	
	
		
		
		
		
		
	}

