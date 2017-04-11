package com.agx.Bag;

import java.util.EmptyStackException;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import org.omg.CosNaming.NamingContextPackage.NotFound;

public class ArrayBag implements BagADT{

	private int count;
	private final int NOT_FOUND=-1;
	private final int DEFAULT_CAPACITY=100;
	private Object[] contents;
	private static Random rand = new Random();
	//具体方法介绍见接口
	public ArrayBag(){
		contents = new Object[DEFAULT_CAPACITY];
		count = 0;
	}
	
	public ArrayBag(int capacity){
		contents = new Object[capacity];
		count = 0;
	}
	
	public void add(Object element) {

		if(size()==contents.length){
			expandCapacity();
		}
		contents[count] = element;
		count++;
	}

	private void expandCapacity() {

		Object[] capac = new Object[size()*2];
		for(int i = 0;i<size();i++){
			capac[i]=contents[i];
		}
		contents = capac;
	}

	public void addAll(BagADT bag) {
		Iterator iter = bag.iterator();
		while(iter.hasNext()){
			add(iter.next());
		}
	}

	public Object removeRandom() {
		
		int obj = rand.nextInt(count);
		Object con = contents[obj];
		contents[obj] = contents[count-1];
		contents[count-1] = null;
		count--;
		return con;
	}

	public Object remove(Object element) {

		if(isEmpty()){
			throw new EmptyStackException();
		}
		
		int search=NOT_FOUND;
		for(int i = 0;i<size();i++){
			if(contents[i].equals(element)&&search==NOT_FOUND){
				search=i;
			}	
		}
		if(search==NOT_FOUND){
			throw new NoSuchElementException();
		}
		Object obj = contents[search];
		contents[search]=contents[count-1];
		contents[count-1]=null;
		count--;
		return obj;
	}

	public BagADT union(BagADT set) {

		ArrayBag bag = new ArrayBag();
		for(int i=0;i<size();i++){
			bag.add(contents[i]);
		}
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			bag.add(iter.next());
		}
		return bag;
	}

	public boolean contains(Object target) {

		for(int i=0;i<size();i++){
			if(target.equals(contents[i])){
				return true;
			}
		}
		return false;
	}

	public boolean equals(BagADT bag) {

		if(size()!=bag.size()){
			return false;
		}
		ArrayBag temp1 = new ArrayBag();
		ArrayBag temp2 = new ArrayBag();
		temp1.addAll(bag);
		temp2.addAll(this);
		Iterator iter = temp1.iterator();
		while(iter.hasNext()){
			Object obj = iter.next();
			if(temp2.contains(obj)){
				temp2.remove(obj);
				temp1.remove(obj);
			}
		}
		
		return temp1.isEmpty()&&temp2.isEmpty();
	}

	public boolean isEmpty() {
		
		return size()==0;
	}

	public int size() {
		return count;
	}

	public Iterator iterator() {
		return new ArrayIteritor(contents, count);
	}
	
	@Override
	public String toString(){
		String result = "";
		Iterator iter = iterator();
		while(iter.hasNext()){
			result = result+"   "+iter.next();
		}
		return result;
	}

}
