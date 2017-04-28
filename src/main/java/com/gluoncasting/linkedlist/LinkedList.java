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
			return;
		}
		else{
			Node<T> node = new Node(data);
			node.setNext(this.head);
			this.head = node;
		}
	}
	
	/**
	 * Insert at tail of linked list
	 */
	public void insertAtTail(T data){
		if (this.head == null ){
			this.head = new Node<T>(data);
			return;
		}
		
		Node<T> current = this.head;
		while ( current != null){
			if ( current.getNext() == null ) { //found tail
				current.setNext(new Node<T>(data));
				return;
			}
			current = current.getNext();
		}
	}
	
	/**
	 * Delete node from linked list
	 * @param data
	 */
	public void delete(T data){
		if (this.head == null){
			return;
		}
		
		Node<T> current = this.head;
		Node<T> previous = null;
		Node<T> next = null;
		
		while (current != null){
			if (current.getData().equals(data)){
				next = current.getNext();
				if (current == this.head){
					this.head = current.getNext(); //if the node to delete is the head, simply delete at the head!
					return;
				}
				else{
					//link around the node to delete
					previous.setNext(next);
				}
			}
			previous = current;
			current = current.getNext();
		}
	}
	
	/**
	 * Delete node at tail of linked list
	 */
	public void deleteAtTail(){
		if (this.head == null ){
			return;
		}
		
		Node<T> current = this.head;
		Node<T> previous = null;
		while ( current != null){
			if ( current.getNext() == null ) { //found tail
				previous.setNext(null);
				return;
			}
			previous = current;
			current = current.getNext();
		}
		
	}
	
	/**
	 * Reverse linked list with iteration
	 */
	public void reverse(){
		if (this.head == null){ //catch empty list
			return;
		}
		
		Node<T> next = null;
		Node<T> current = this.head;
		Node<T> previous = null;
		while (current != null){
			next = current.getNext();
			current.setNext(previous);
			previous = current;
			current = next;
		}
		this.head = previous;
	}
	
	/**
	 * Find the specific data in the list and return true if found.
	 * @param data
	 */
	public boolean contains(T data){
		if ( this.head == null){
			return false;
		}
		
		Node<T> current = this.head;
		while (current != null){
			if (current.getData().equals(data)){
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder();
		Node<T> current = this.head;
		while (current != null){
			str.append(current.getData().toString() + " ");
			current = current.getNext();
		}
		return str.toString();
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
