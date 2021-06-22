package com.example.datastructures.trees.bit;

import java.util.Arrays;

public class FindLowestCountFromRight {
	public static int getSum(int BITree[], int index)
	{
	     
	    // Initialize result
	    int sum = 0;
	 
	    // Traverse ancestors of BITree[index]
	    while (index > 0)
	    {
	    //	System.out.println("BITree[index]" +BITree[index]+" index:"+index+ " sum :"+sum);
	         
	        // Add current element of BITree to sum
	        sum += BITree[index];
	 
	        // Move index to parent node in getSum View
	        index -= index & (-index);
	    }
	  //  System.out.println("BITree "+Arrays.toString(BITree));
	    return sum;
	}
	 
	// Updates a node in Binary Index Tree
	// (BITree) at given index in BITree.
	// The given value 'val' is added to BITree[i]
	// and all of its ancestors in tree.
	public static void updateBIT(int BITree[], int n,
	                             int index, int val)
	{
	     
	    // Traverse all ancestors and add 'val'
	    while (index <= n)
	    {
	         
	        // Add 'val' to current node of BI Tree
	        BITree[index] += val;
	 
	        // Update index to that of parent
	        // in update View
	        index += index & (-index);
	    }
	  //  System.out.println(Arrays.toString(BITree));
	}
	 
	// Converts an array to an array with values
	// from 1 to n and relative order of smaller
	// and greater elements remains same.
	// For example, {7, -90, 100, 1} is converted to
	// {3, 1, 4, 2 }
	public static void convert(int arr[], int n)
	{
	     
	    // Create a copy of arrp[] in temp
	    // and sort the temp array in
	    // increasing order
	    int[] temp = new int[n];
	    for(int i = 0; i < n; i++)
	        temp[i] = arr[i];
	     
	    Arrays.sort(temp);
	   // System.out.println(Arrays.toString(temp));
	    // Traverse all array elements
	    for(int i = 0; i < n; i++)
	    {
	         
	        // Arrays.binarySearch() returns index
	        // to the first element greater than
	        // or equal to arr[i]
	    //	System.out.println("Arrays.binarySearch(temp, arr[i])" +Arrays.binarySearch(temp, arr[i]));
	    	
	    	//System.out.println("Arrays.binarySearch(temp, arr[i])"+ i + " "  +Arrays.binarySearch(temp, arr[i]));
	        arr[i] = Arrays.binarySearch(temp, arr[i]) + 1;
	      //  System.out.println(arr[i]);
	    }
	}
	 
	// Function to find smaller_right array
	public static void findElements(int arr[], int n)
	{
	     
	    // Convert arr[] to an array with values
	    // from 1 to n and relative order of smaller
	    // and greater elements remains same. For
	    // example, {7, -90, 100, 1} is converted to
	    // {3, 1, 4, 2 }
	    convert(arr, n);
	 
	    // Create a BIT with size equal to
	    // maxElement+1 (Extra one is used
	    // so that elements can be directly be
	    // used as index)
	    int[] BIT = new int[n + 1];
	    for(int i = 1; i <= n; i++)
	        BIT[i] = 0;
	 
	    // To store smaller elements in right side
	    // and greater elements on left side
	    int[] smaller_right = new int[n];
	    int[] greater_left = new int[n];
	 
	    
	    System.out.println("After convert "+Arrays.toString(arr));
	    // Traverse all elements from right.
	    for(int i = n - 1; i >= 0; i--)
	    {
	         
	        // Get count of elements smaller than arr[i]
	    	//System.out.println("arr[i"+ arr[i]);
	        smaller_right[i] = getSum(BIT, arr[i] - 1);
	 
	        // Add current element to BIT
	        updateBIT(BIT, n, arr[i], 1);
	       // System.out.println(Arrays.toString(BIT));
	    }
	     System.out.println(Arrays.toString(BIT));
	    System.out.print("Smaller right: ");
	 
	    // Print smaller_right array
	    for(int i = 0; i < n; i++)
	        System.out.print(smaller_right[i] + " ");
	     
	    System.out.println();
	 
	    for(int i = 1; i <= n; i++)
	        BIT[i] = 0;
	 
	    // Find all left side greater elements
	    for(int i = 0; i < n; i++)
	    {
	         
	        // Get count of elements greater than arr[i]
	        greater_left[i] = i - getSum(BIT, arr[i]);
	 
	        // Add current element to BIT
	        updateBIT(BIT, n, arr[i], 1);
	    }
	 
	    System.out.print("Greater left: ");
	 
	    // Print greater_left array
	    for(int i = 0; i < n; i++)
	        System.out.print(greater_left[i] + " ");
	}
	 
	// Driver code
	public static void main(String[] args)
	{
	    int arr[] = { 12, 1, 2, 3, 0, 11, 4 };
	 
	    int n = arr.length;
	 
	    // Function call
	    findElements(arr, n);
	}
}
