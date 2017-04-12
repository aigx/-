package com.agx.Bag;

import java.util.Iterator;
import java.util.Random;

/*
 * 使用链表的方式实现袋集合
 * */
public class LinkBag implements BagADT{
	
	//链表中的内容数
	private int count;
	//产生一个随机数
	private static Random rand = new Random();
	//制造一个链表节点，指向第一个链表
	private contentsNode firstNode;

	public LinkBag() {

		count=0;
		firstNode = null;
	}
	
	
	public void add(Object element) {
		//将新的元素添加到顶部，由于没有排序，所以添加到顶部就可以
		//如果理解不了建议画个图就解释了
		contentsNode node = new contentsNode(element);
		node.setNext(firstNode);
		firstNode = node;
		count++;
	}

	public void addAll(BagADT bag) {

		//直接遍历取出bag所有的元素，使用添加方法
 		Iterator iter = bag.iterator();
		while(iter.hasNext()){
			add(iter.next());
		}
		
	}

	public Object removeRandom() {

		if(isEmpty()){
			System.out.println("集合为null");
		}
		int num = rand.nextInt(count);
		Object obj = null;
		contentsNode before ,remove;
		if(num == 0){
			obj = firstNode.getElement();
			firstNode = firstNode.getNext();
			
		}else{
			
			before = firstNode;
			remove = before.getNext();
			for(int i = 0;i<num-1;i++){
				before = remove;
				remove = remove.getNext();
			}
			obj = remove.getElement();
			before.setNext(remove.getNext());
			
		}
		count--;
		return obj;
	}

	public Object remove(Object element) {

		int notfound = -1;

		if(isEmpty()){
			System.out.println("集合为null");
		}
		Object obj = null;
		contentsNode before ,remove;
		
		before = null;
		remove = firstNode;
		
		for(int i = 0;i<count;i++){
			if(remove.getElement().equals(element)&&notfound == -1){
				notfound = 1;
				obj = remove.getElement();
				before.setNext(remove.getNext());
				
			}else{
				before = remove;
				remove = remove.getNext();	
			}
				
		}
			
		count--;
		
		return obj;
	}

	public BagADT union(BagADT set) {

		LinkBag lbag = new LinkBag();
		Iterator thisiter = iterator();
		Iterator setiter = set.iterator();
		while(thisiter.hasNext()){
			lbag.add(thisiter.next());
		}
		while(setiter.hasNext()){
			lbag.add(setiter.next());
		}
		return lbag;
	}

	public boolean contains(Object target) {

		Iterator thisiter = iterator();
		while(thisiter.hasNext()){
			if(thisiter.next().equals(target)){
				return true;
			}
		}
		return false;
	}

	public boolean equals(BagADT bag) {

		int num = 0;
		
		if(size()!=bag.size()){
			return false;
		}else{
			Iterator thisiter = iterator();
			Iterator bagiter = bag.iterator();
			while(thisiter.hasNext()&&bagiter.hasNext()){
				Object thisobj = thisiter.next();
				Object bagobj = bagiter.next();
				if(thisobj.equals(bagobj)){
					num++;
				}
				
			}
			
		}
		
		return num==size();
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count==0;
	}

	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	public Iterator iterator() {

		return new LinkIterator(firstNode,count);
	}
	@Override
	public String toString(){
		String result = "";
		Iterator thisiter = iterator();
		while(thisiter.hasNext()){
			result = result +"    "+ thisiter.next();
		}
		
		return result;
	}

}
