package com.agx.Bag;

import java.util.Iterator;

public class LinkIterator implements Iterator {

	private contentsNode content;
	private int count;
	
	public LinkIterator(contentsNode arg0, int arg1){
		content = arg0;
		count = arg1;
	}
	
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return content!=null;
	}

	public Object next() {
		if(!hasNext()){
			System.out.println("出现一个异常：没有下一个了");
		}
		Object result = content.getElement();
		content = content.getNext();
		
		return result;
	}

}
