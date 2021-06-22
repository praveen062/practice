package com.example.datastructures.linkedlist.singlelinkedlist;

public class ReverseLinkedList {
	LinkedListNode<Integer> linkedListNode = null;
	
	public static void main(String[] args) {
		ReverseLinkedList r = new ReverseLinkedList();
		
		Node<Integer> head = r.createLinkedList();
		r.linkedListNode.print(head);
		head = r.reverse(head);
		r.linkedListNode.print(head);
	}
	
	public Node<Integer> createLinkedList() {
		linkedListNode = new LinkedListNode<Integer>();
		linkedListNode.add(1);
		linkedListNode.add(2);
		linkedListNode.add(3);
		linkedListNode.add(4);
		return linkedListNode.getHead();
		
	}
	
	public Node<Integer> reverse(Node<Integer> head) {
		if(head == null || head.next == null) {
			return head;
		}else {
			Node<Integer> reverse = reverse(head.next);
			//reverse.next = head;
			head.next.next = head;
			head.next = null;
			return reverse;
		}
	}
	
	

}
