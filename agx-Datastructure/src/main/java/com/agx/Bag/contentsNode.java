package com.agx.Bag;

public class contentsNode {

	private Object element;
	private contentsNode next;
	public contentsNode(Object element) {
		super();
		this.element = element;
		this.next = null;
	}
	public Object getElement() {
		return element;
	}
	public void setElement(Object element) {
		this.element = element;
	}
	public contentsNode getNext() {
		return next;
	}
	public void setNext(contentsNode next) {
		this.next = next;
	}
	
	
	
}
