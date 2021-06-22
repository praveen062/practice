package com.example.datastructures.linkedlist.singlelinkedlist;

import java.util.Stack;

public class KTListReversal {
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		Node<Integer> head = r.createLinkedList();
		r.linkedListNode.print(head);
		head = divide(head,2);
		//head = r.reverse(head);
		r.linkedListNode.print(head);
	}
	
	public static Node<Integer> divide(Node<Integer> head, int k){
		Stack<Node<Integer>> nodes = new Stack<Node<Integer>>();
		int count = 0;
		Node<Integer> current = head;
		Node<Integer> prev = null;
		while(current !=null) {
			count =0;
			while (current != null && count < k) {
	        	nodes.push(current);
	            current = current.next;
	            count++;
	        }
			while(nodes.size() > 0) {
				if(prev == null) {
					prev = nodes.pop();
					head= prev;
				}else {
					prev.next = nodes.pop();
					prev= prev.next;
				}
			}
		}
        
        prev.next = null;
		return head;
	}
}
