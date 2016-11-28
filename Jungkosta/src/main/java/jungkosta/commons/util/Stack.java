package jungkosta.commons.util;

import javax.inject.Inject;

public class Stack {
	
	private Node head;
	
	private Node tail;
	
	private int size;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public Node getTail() {
		return tail;
	}

	public void setTail(Node tail) {
		this.tail = tail;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	public void push(Node pNew){
		if(is_Empty())
			head = tail = pNew;
		else
		{
			tail.setStackNext(pNew);
			pNew.setStackPrev(tail);
			
			tail = pNew;
		}
		size++;
	}
	
	public Node pop(){
		
		if(is_Empty()){
			return null;
		}else
		{
			size--;
			
			if(head == tail){
				
				return tail;
			}
			
			Node pPre = tail.getStackPrev();
			Node pDel = tail;
			
			tail.setStackPrev(null);
			pPre.setStackNext(null);
			
			tail = pPre;
			
			return pDel;
		}
	}
	
	public boolean is_Empty(){
		
		return (size == 0) ? true : false;
		
	}
}
