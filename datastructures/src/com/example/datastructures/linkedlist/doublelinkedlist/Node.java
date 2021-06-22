package com.example.datastructures.linkedlist.doublelinkedlist;

public class Node<T> {
	public Node previous;
	public T data;
	public Node next;
	
	public Node(T data) {
		this.data = data;
	}
}
