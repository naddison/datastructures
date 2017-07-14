package com.gluoncasting.linkedlist;

import static org.junit.Assert.*;

import org.junit.Test;

import com.gluoncasting.linkedlist.LinkedList.Node;

public class MergeLinkedListTest {

	/**
     * Given two heads of two sorted linked lists of different sizes, merge them using iteration.
     *
      * The algorithm here starts with two head nodes. The idea is to pick a master list of the two.
     * The one that will be the new head node. Then we treat the second list as a bag of nodes we
      * need to insert into the new one.
      *
      * We can keep the assumption that the lists are sorted as we iterate.
     *
      *
      */
     @SuppressWarnings("unchecked")
	public static Node mergeListsIteratively(Node list1, Node list2){
    
            //if one of the nodes to merge is null, simply return the other list
            //this will also catch if both are null and simply return null
            if (list1 == null) return list2;
            if (list2 == null) return list1;
           
            LinkedList<Integer> tmp1 = new LinkedList<Integer>();
            LinkedList<Integer> tmp2 = new LinkedList<Integer>();
            tmp1.head = list1;
            tmp2.head = list2;
            System.out.println("We are inserting list2 " + tmp2.toString() + " into list1 " + tmp1.toString());
           
           Node head; //the head of our new sorted merged list
           
            //we need to pick which list will be the master list to sort into.
            //we need the head that is the smallest of either one. Because they
            //are sorted, we know these heads represent the smallest values in both lists.
            if (list1.data.compareTo(list2.data) <=0 ){
                   head = list1; //if list1 is the smallest, lets take it as the master list
            }
            else {
                   head = list2; //if list2 is the smaller list we take list 2 as the master list
                   list2 = list1; //basically 'rename' list1 to list2 for comprehension sakes. We could also rename these to something like 'master' and 'grab bag'
                   list1 = head;
            }
           
           
           
            //lets iterate over the master list, which we will insert into
            while(list1.next != null){
                   System.out.println();
                   System.out.println("ITERATION");
                   System.out.println();
                   LinkedList<Integer> tmpx = new LinkedList<Integer>();
                   tmpx.head = head;
                   System.out.println("current merged list " + tmpx.toString());
                  
                   LinkedList<Integer> tmp1c = new LinkedList<Integer>();
                   LinkedList<Integer> tmp2v = new LinkedList<Integer>();
                   tmp1c.head = list1;
                   tmp2v.head = list2;
                   System.out.println("list to insert into merged list " + tmp2v.toString());
                  
                   System.out.println("current node " + list1.data + " find a home for " + list2.data);
                   if (list1.next.data.compareTo(list2.data) > 0){ //find out where to insert the next list2 node.                 
                         System.out.println(list2.data + " is smaller than " + list1.next.data + " and gaurenteed smaller than " + list1.data + " because they are sorted");
                         Node bin = list1.next;
                         System.out.println("put " + tmp1c.toString() + " into a bin");
                         System.out.println("append " + tmp2v.toString() + " to " + list1.data);
                         list1.next = list2;
                         list2 = bin;
                         tmp2v.head = list2;
                         System.out.println (tmp2v.toString() + " will insert next iteration");
                   }
                   else{
                         System.out.println(list1.next.data + " is not greater than " + list2.data);
                   }
                   list1 = list1.next; //advance on the master list
                  
                   tmp1c.head = list1;
                   tmp2v.head = list2;
                   LinkedList<Integer> tmpx2 = new LinkedList<Integer>();
                   tmpx2.head = head;
                   System.out.println("current merged list " + tmpx2.toString());
                   System.out.println("list1 " + tmp1c.toString());
                   System.out.println("list2 " + tmp2v.toString());
            }
           
           
           
            if (list1.next == null){
                   list1.next = list2;
            }
           
            return head;
     }
    
    
     /**
     * Given two heads of two sorted linked lists of different sizes, merge them using recursion.
     * @return
      */
     @SuppressWarnings("unchecked")
	public static Node mergeLists (Node list1, Node list2) {
            if (list1 == null) { return list2; }
            if (list2 == null) { return list1; }
           
            if (list1.getData().compareTo(list2.getData()) < 0){
                   list1.setNext(mergeLists(list1.next, list2));
                   return list1;
            }
            else {
                   list2.setNext(mergeLists(list2.next, list1));
                   return list2;
            }            
     }
	
	@Test
	public void test() {
		LinkedList<Integer> list1 = new LinkedList<Integer>();
		list1.insertAtTail(1);
		list1.insertAtTail(3);
		list1.insertAtTail(5);
		list1.insertAtTail(7);
		list1.insertAtTail(9);
		
		LinkedList<Integer> list2 = new LinkedList<Integer>();
		list2.insertAtTail(2);
		list2.insertAtTail(4);
		list2.insertAtTail(6);
		list2.insertAtTail(8);
		list2.insertAtTail(10);
		
		//mergeListsIteratively(list1.head, list2.head);
		
		LinkedList t = new LinkedList<Integer>();
		t.head = mergeLists(list1.head, list2.head);
		System.out.println(t.toString());
		
	}

}
