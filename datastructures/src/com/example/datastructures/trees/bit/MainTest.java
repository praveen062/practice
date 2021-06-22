package com.example.datastructures.trees.bit;

import java.util.Arrays;

public class MainTest {
	public static void main(String[] args) {
		System.out.println((7 + (7 & -7)));
		int[] givenArray = {1,2,3,4,5,6,7};
		//[0, 1, 3, 3, 10, 5, 11, 7]
		int[] binaryIndexTree = findSum(givenArray);
		int res = getSum(binaryIndexTree, 6);
		System.out.println("array "+Arrays.toString(binaryIndexTree));
		System.out.println("the sym is "+res);
		
	}
	
	public static int[] findSum(int[] givenArray) {
		int[] binaryIndexTree = new int[givenArray.length +1];
		for(int i=1;i < binaryIndexTree.length;i++) {
			updateSum(binaryIndexTree, givenArray[i -1], i);
		}
		return binaryIndexTree;
	}
	
	public static int getNext(int index) {
		return (index + (index & -index));
	}
	
	public static int getParent(int index) {
		return (index - (index & -index));
	}
	
	public static void updateSum(int[] binaryTree,int val, int index) {
		while(index < binaryTree.length) {
			System.out.println("index : "+index+" binaryTree[index]"+ binaryTree[index] + "val "+val);
			binaryTree[index]+= val;
			index = getNext(index);
		}
	}
	
	public static int getSum(int[] binaryTree,int index) {
		 index = index + 1;
		int sum = 0;
		while (index > 0) {
			sum += binaryTree[index];
			index = getParent(index);
		}
		return sum;
	}
}
