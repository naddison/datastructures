package com.gluoncasting.linkedlist;

/**
 * Simple implementation of a singly linked list in java.
 * @author Nikolas
 *
 * @param <T>
 */
public class LinkedList<T extends Comparable<T>> {

	private Node<T> head;
	
	/**
	 * Insert data at head of linked list.
	 * @param data
	 */
	public void insertAtHead(T data){
		if (head == null){ //check for empty list by checking if the head is null
			this.head = new Node<T>(data);
		}
		else{
			Node<T> node = new Node(data);
			node.setNext(this.head);
			this.head = node;
		}
	}
	
	public void delete(T data){
		Node<T> current = this.head;
		while (current != null){
			if (current.getData().equals(data)){
				
			}
			current = current.getNext();
			
		}
	}
	
	
	/**
	 * Find the specific data in the list and return true if found.
	 * @param data
	 */
	public boolean contains(T data){
		Node<T> current = this.head;
		while (current != null){
			if (current.getData().equals(data)){
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	
	
	
	/**
	 * Inner Node Class for use in singly linked list.
	 * @author Nikolas
	 *
	 * @param <T>
	 */
	private class Node<T extends Comparable<T>> {
		
		private T data;
		private Node<T> next;	
		
		public Node (T data){
			this.data = data;
		}
		
		public void setNext(Node<T> node){
			this.next = node;
		}
		
		public Node<T> getNext(){
			return this.next;
		}
		
		public T getData(){
			return this.data;
		}
		
		@Override
		public String toString(){
			return this.data.toString();
		}
		
	}
	
	
	
	
}
