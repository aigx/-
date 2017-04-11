package com.agx.Bag;

import java.util.Iterator;

public class ArrayIteritor implements Iterator{

	private Object[] con;
	private int count;
	private int num;
	
	public ArrayIteritor(Object[] obj,int count){
		this.con = obj;
		this.count = count;
		this.num = 0;
	}
	
	public boolean hasNext() {
		if(num<count){
			return true;
		}
		return false;
	}

	public Object next() {
		num++;
		return con[num-1];
	}

}