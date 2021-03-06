package com.example.datastructures.linkedlist.doublelinkedlist;

public class DoubleLinkedListNode<T> {
	Node<T> head;
	Node<T> tail;
	
	public Node add(T data) {
		Node node = new Node<T>(data);
		if(head == null && tail == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			node.previous = tail;
			tail = node;
		}
		return node;
	}
	
	public void delete(Node<T> node) {
		if(head == node && tail == null) {
			head = null;
			tail = null;
		}else if(head == node && tail != node) {
			head = head.next;
			head.previous.next = null;
			head.previous = null;
		} else if ( head !=node && tail == node) {
			tail = tail.previous;
			tail.next.previous = null;
			tail.next = null;
		} else {
			node.previous.next = node.next;
			node.next.previous = node.previous;
			node.previous = null;
			node.next = null;
		}
	}
	
	public void printFromhead() {
		Node node = head;
		if(node == null) {
			return;
		}else {
			while(node != null) {
				System.out.print(node.data+" ->");
				node = node.next;
			}
			System.out.println();
			
		}
	}
	
	public void printFromTail() {
		Node node = tail;
		if(node == null) {
			return;
		}else {
			while(node != null) {
				System.out.print(node.data+" ->");
				node = node.previous;
			}
			System.out.println();
			
		}
	}
}
