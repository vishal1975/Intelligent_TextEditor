package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		head=new LLNode<E>(null);
		tail=new LLNode<E>(null);
		head.next=tail;
		tail.prev=head;
				
		size=0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		
//		if ( element.toString().equals("null") || element.equals(null) || element.equals("")) {
//			throw new NullPointerException();
//		}
//		if(element==null|| element.equals("")) {
//			throw new NullPointerException();
//
//		}
//		
//		else {
//			LLNode<E> toadd=new LLNode<E>(element);
//
//			toadd.prev=tail.prev;
//			toadd.next=toadd.prev.next;
//			toadd.next.prev=toadd;
//			toadd.prev.next=toadd;
//			size++;
//			return true;
//			
//		}
		
		
		if (element==null) {
			throw new NullPointerException();
			}
			else {
			LLNode<E> newNode = new LLNode<E>(element);
			newNode.next = tail;
			newNode.prev = tail.prev;
			tail.prev.next = newNode;
			tail.prev = newNode;

			size++;
			return true;
			}
		
		

		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if(index>=size)
			throw new IndexOutOfBoundsException();
		else if(index<0||index>=size)
			throw new IndexOutOfBoundsException();
		else {
			int j=0;

			LLNode<E> temp=head.next;
			while(j<index) {
				temp=temp.next;
				j++;
			}
			return temp.data;
		}
//		return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
//		if(element==null) {
//			throw new NullPointerException();
//		}
		if ( element.toString().equals("null") || element.equals(null) || element.equals("")) {
			throw new NullPointerException();
		}
		else if(index<0 || index>size)
			throw new IndexOutOfBoundsException();
		else if(index==size)
			add(element );

		else {
			LLNode<E> toadd=new LLNode<E>(element);
			int j=0;
			//LLNode<E> temp=head;
			LLNode<E> temp=head.next;
			while(j<index) {
				temp=temp.next;
				j++;
			}
			toadd.next=temp;
			toadd.prev=temp.prev;
			
			temp.prev=toadd;
			toadd.prev.next=toadd;
			
			size++;
			
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if(index>=size)
			throw new IndexOutOfBoundsException();
		else if(index<0||index>=size)
			throw new IndexOutOfBoundsException();
		else {
			if(size==1) {
				//LLNode<E> temp=tail;
				LLNode<E> temp=head.next;
				head.next=tail;
				tail.prev=head;
				temp.next=null;
				temp.prev=null;
				
				size--;
				return temp.data;
			}
			else if(index==size-1) {
				LLNode<E> temp=tail.prev;
//				tail=tail.prev;
//				tail.next=null;
//				temp.prev=null;
				tail.prev=temp.prev;
				temp.prev.next=tail;
				temp.next=null;
				temp.prev=null;
				size--;
				return temp.data;
			}
			else if(index==0) {
				//LLNode<E> temp=head;
				LLNode<E> temp=head.next;
				head.next=temp.next;
				temp.next.prev=head;
				temp.next=null;
				temp.prev=null;
				size--;
				return temp.data;
			}
			else {
				int j=0;
			     
				LLNode<E> temp=head.next;
				while(j<index) {
					temp=temp.next;
					j++;
				}
				temp.prev.next=temp.next;
				temp.next.prev=temp.prev;
				temp.next=null;
				temp.prev=null;
				size--;
				return temp.data;
						
				
			}
		}
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if ( element.toString().equals("null") || element.equals(null) || element.equals("")) {
			throw new NullPointerException();
		}
		
		else if(index>=size)
			throw new IndexOutOfBoundsException();
		else if(index<0)
			throw new IndexOutOfBoundsException();
		else {
			int j=0;
			//LLNode<E> temp=head;
			LLNode<E> temp=head.next;
			while(j<index) {
				temp=temp.next;
				j++;
			}
			E z=temp.data;
			temp.data=element;
			return z;
		}
		
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
