package com.example.datastructures.linkedlist.doublelinkedlist;

import java.util.HashMap;

public class DoubleLinkedListService {
	HashMap<Integer, Node<Integer>> map = new HashMap<Integer, Node<Integer>>();
	DoubleLinkedListNode<Integer> d;
	public static void main(String[] args) {
		DoubleLinkedListService doubleLinkedListService = new DoubleLinkedListService();
		doubleLinkedListService.d = new DoubleLinkedListNode<Integer>();
		doubleLinkedListService.create(1);
		doubleLinkedListService.create(2);
		doubleLinkedListService.create(3);
		doubleLinkedListService.create(4);
		doubleLinkedListService.d.printFromhead();
		doubleLinkedListService.d.printFromTail();
		doubleLinkedListService.delete(3);
		doubleLinkedListService.d.printFromhead();
		doubleLinkedListService.d.printFromTail();
	}
	
	public void create(Integer key) {
		if(!map.containsKey(key)) {
			map.put(key, d.add(key) );
		}
	}
	
	public void delete(Integer key ) {
		if( map.containsKey(key)) {
			d.delete(map.get(key));
		}
	}
}
