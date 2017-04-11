package com.agx.Bag;

import java.util.Iterator;

/*
 * 该接口声明了Bag集合的面向用户的接口
 * 
 * */
public interface BagADT{
	
	//向集合中添加一个对象
	public void add(Object element);
	
	//将一个袋中的所有元素添加到另一个袋
	public void addAll(BagADT bag);
	
	//随机的从袋中删除一个元素
	public Object removeRandom();
	
	//从集合中删除一个元素
	public Object remove(Object element);
	
	//合并两个袋中的元素，并创建一个新的袋
	public BagADT union(BagADT set);
	
	//确认袋中是否存在某个特定的元素
	public boolean contains(Object target);
	
	//确认两个带是否包含相同的元素
	public boolean equals(BagADT bag);
	
	//确认袋是否为空
	public boolean isEmpty();
	
	//确认待中元素的个数
	public int size();
	
	//为袋提供一个迭代器
	public Iterator iterator();
	
	//为袋提供一个tostring方法
	public String toString();
}