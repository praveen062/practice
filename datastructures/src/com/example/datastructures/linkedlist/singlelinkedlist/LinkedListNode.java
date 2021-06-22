package com.example.datastructures.linkedlist.singlelinkedlist;

public class LinkedListNode<T> {
	Node<T> head;
	
	public void add(T data) {
		Node<T> node = new Node(data);
		if(head == null) {
			head = node;
		} else {
			node.next = head;
			head = node;
		}
	}
	
	public Node<T> getHead(){
		return head;
	}

	public void print(Node<T> head) {
		while(head!= null) {
			System.out.print(head.data+" -> ");
			head= head.next;
		}
		System.out.println();
	}
	
}
