//-----------------------------------------------------
// Title: CMPE223 HW1
// Author: Meltem AKKOCA
// ID: 
// Section: 1
// Assignment: 1
// Description: This class defines a linked list and a queue.
//-----------------------------------------------------

public class Queue<Item> {
		//--------------------------------------------------------------
		// Summary: Creates a queue to use in QueueList class.
		//--------------------------------------------------------------

	private Node head, tail;
	private int size;
	
	public class Node{
		//--------------------------------------------------------------
    	// Summary: Creates LinkedList node.
    	//--------------------------------------------------------------
		private Item data;
		private Node next;
		
		public Node(Item data) {
			this.data=data;
			this.next=null;
		}
	}
	public boolean isEmpty() {
		//--------------------------------------------------------------
    	// Summary: Control if the queue is empty or not.
    	// Postcondition: Checked if the queue is empty or not and returned a boolean value which is our result.
    	//--------------------------------------------------------------
		return head==null;
	}
	public void enqueue(Item item) {
		//--------------------------------------------------------------
    	// Summary: Adds a item object to the back of the queue.
    	// Precondition: item is an item object.
    	// Postcondition: item has been added to the back of the queue.
    	//--------------------------------------------------------------
		Node oldtail=tail;
		tail= new Node(item);
		tail.data=item;
		tail.next=null;
		if (isEmpty()) head = tail;
		else oldtail.next = tail;
		size++;
	}
	public Item dequeue()
		{
		//--------------------------------------------------------------
    	// Summary: Removes the first item in the queue.
    	// Precondition: item is an item object. 
    	// Postcondition: first item has been removed from the queue.
    	//--------------------------------------------------------------
		Item item = head.data;
		head = head.next;
		if (isEmpty()) tail = null;
		size--;
		return item;
		
		}
	
	public int size() {
		//--------------------------------------------------------------
    	// Summary: Gives the size of queue.
    	// Precondition: size is an integer value.
    	// Postcondition: Returns the size value of the queue which is an integer value.
    	//--------------------------------------------------------------
		
		return size;
	}

	
	
}
