//-----------------------------------------------------
// Title: CMPE223 HW1
// Author: Meltem AKKOCA
// ID: 
// Section: 1
// Assignment: 1
// Description: This class defines a linked list and a stack.
//-----------------------------------------------------
public class Stack<Item> {
		//--------------------------------------------------------------
		// Summary: Creates a stack to use in StackList class.
		//--------------------------------------------------------------
	
	private Node top;
	private int size;
	
	private class Node{
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
	public void push(Item data) {
		 //--------------------------------------------------------
		 // Summary: It added new value to the stack.
		 // Precondition: Data is an Item object.
		 // Postcondition: The new value of the stack is described and size of the list is increased.
		 //--------------------------------------------------------
		Node temp= new Node(data);
		temp.next=top;
		top=temp;
		size++;
	}
	
	public Item pop() {
		//--------------------------------------------------------
		 // Summary: It removes the value from the stack.
		 // Postcondition: item has been removed from the stack and size of the list is decreased.
		 //--------------------------------------------------------
		Item result=top.data;
		top=top.next;
		size--;
		return result;
	}
	
	public boolean isEmpty() {
		//--------------------------------------------------------------
    	// Summary: Control if the stack is empty or not.
    	// Postcondition: Checked if the stack is empty or not and returned a boolean value which is the result.
    	//--------------------------------------------------------------
		return size==0;
	}
	
}




