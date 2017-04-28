package com.gluoncasting.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testInsertAtHead() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtHead(10);
		list.insertAtHead(9);
		list.insertAtHead(16);
		list.insertAtHead(23);
		list.insertAtHead(65);
		
		String expected = "65 23 16 9 10 ";
		assertEquals(list.toString(), expected);
	}
	
	@Test
	public void testInsertAtTail(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtTail(10);
		list.insertAtTail(9);
		list.insertAtTail(16);
		list.insertAtTail(23);
		list.insertAtTail(65);
		
		String expected = "10 9 16 23 65 ";
		assertEquals(list.toString(), expected);
	}
	
	@Test 
	public void testContains(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtTail(10);
		list.insertAtTail(9);
		list.insertAtTail(16);
		list.insertAtTail(23);
		list.insertAtTail(65);
		
		assertTrue(list.contains(10));
		assertTrue(list.contains(9));
		assertTrue(list.contains(16));
		assertTrue(list.contains(23));
		assertTrue(list.contains(65));
		
		assertFalse(list.contains(1));
		assertFalse(list.contains(0));
		assertFalse(list.contains(99));
		assertFalse(list.contains(66));
	}
	
	@Test
	public void testReverse(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtHead(10);
		list.insertAtHead(9);
		list.insertAtHead(16);
		list.insertAtHead(23);
		list.insertAtHead(65);
		
		list.reverse();
		
		String expected = "10 9 16 23 65 ";
		assertEquals(expected, list.toString());
	}
	
	@Test 
	public void testDeleteNoed(){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertAtHead(10);
		list.insertAtHead(9);
		list.insertAtHead(16);
		list.insertAtHead(23);
		list.insertAtHead(65);
		
		list.delete(10);
		
		assertTrue(list.contains(9));
		assertFalse(list.contains(10));
		
		String expected = "65 23 16 9 ";
		assertEquals(list.toString(), expected);
		
		list.delete(65); //try deleting at head without specifying it
		
		assertTrue(list.contains(23));
		assertFalse(list.contains(65));
		
		String expected2 = "23 16 9 ";
		assertEquals(list.toString(), expected2);
	}

}
