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
	 * While iterating bubble the largest node to the tail.
	 * Keep iterating until we iterate a full time without swapping.
	 * @return
	 */
	public LinkedList<T> bubbleSort(){
		
		if (this.head == null){
			return null;
		}
		
		boolean swapped = true;
		
		while (swapped == true){
			
			swapped = false;
			Node<T> current = this.head;
			Node<T> previous = null;
			
			while (current.getNext() != null) {
				if (current.getData().compareTo(current.getNext().getData()) > 0){ //if the current data is larger swap!
					if (previous == null){ //swapping the head with the next node
						this.head = current.getNext();
						current.setNext(this.head.getNext());
						this.head.setNext(current);
						previous = this.head;
					}
					else { //swapping in the middle of the list
						previous.setNext(current.getNext());
						current.setNext(previous.getNext().getNext());
						previous.getNext().setNext(current);
						previous = previous.getNext();
					}
					swapped = true;
				}
				else{
					//dealing with the possibility of not swapping with the head of the linked list
					previous = (previous == null) ? this.head : previous.getNext();
		            current = current.getNext();
				}
			}
		}
		return this;
	}
	
	
	/**
	 * Return the length of the linked list
	 */
	public int length(){
		Node<T> current = this.head;
		int count = 0;
		while (current != null){
			current = current.getNext();
			count++;
		}
		return count;
	}
	
	/**
	 * Iterate over the list and insert the current node between its next smallest and next biggest
	 * @return
	 */
	public LinkedList<T> insertionSort(){
		// catch an empty list
		if (this.head == null){
			return null;
		}
		
		Node<T> current = this.head;
		Node<T> previous = null;
		
		//loop through each node in the list
		while (current != null){
			
			Node<T> toInsert = current.getNext();
		
			if (previous == null ||  previous.getData().compareTo(toInsert.getData()) >= 0){ //no insertion required, just advance the sorted pointer
				previous = current;
				current = current.getNext();
			}
			else{
				Node<T> innerPrevious = null;
				Node<T> insertAfter = this.head;
				if (innerPrevious == null && toInsert.getData().compareTo(insertAfter.getData()) < 0){ //we found the new head as the to be inserted is smaller than the current head
					current.setNext(toInsert.getNext());
					this.head = toInsert;
					this.head.setNext(insertAfter);
				}
				else if (toInsert.getData().compareTo(insertAfter.getData()) > 0 //we found where to insert the unsorted node
						&& 
						 toInsert.getData().compareTo(insertAfter.getNext().getData()) < 0) {
					current.setNext(toInsert.getNext());
					insertAfter.setNext(toInsert);
					toInsert.setNext(current);
				}
				else{ //advance pointers to find where we insert the unsorted node
					innerPrevious = insertAfter;
					insertAfter = insertAfter.getNext();
				}
			}
			current = current.getNext();
		}
		return this;
	}
		
	/**
	 * Iterate over the list and move the smallest element to the front of the list.
	 * @return
	 */
	private LinkedList<T> selectionSort(){
		return this;
	}
	
	
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
			Node<T> node = new Node<T>(data);
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
