package com.agx.Bag;

public class Test {

	public static void main(String[] args) {
		
		for(int i = 0;i<10 ;i++){
			
		
		
		BagADT bag = new LinkBag();
		bag.add(new String("1"));
		bag.add(new String("2"));
		
		BagADT bag1 = new LinkBag();
		bag1.add(new String("3"));
		bag1.add(new String("4"));
			
		System.out.println("bag:"+bag);
		System.out.println("bag1"+bag1);
		
		bag.addAll(bag1);
		System.out.println("把bag1全部添加到bag里后bag::"+bag);
		System.out.println("删除一个数据"+bag.remove(new String("1")));
		System.out.println(bag);
		System.out.println("随机删除一个数据"+bag.removeRandom());
		System.out.println(bag);
		System.out.println("随机删除一个数据"+bag.removeRandom());
		System.out.println(bag);
		
		System.out.println("把bag和bag1合并成一个新对象"+bag.union(bag1));
		
		System.out.println("检查袋中是否拥有特定的元素：2"+bag.contains(new String("2")));
		System.out.println("是否为空"+bag.isEmpty());
		System.out.println("bag"+bag);
		System.out.println("内数量："+bag.size());
		
		System.out.println("检查两个包是否相同");
		BagADT bag3 = new LinkBag();
		bag3.add(new String("3"));
		System.out.println(bag3);
		System.out.println(bag);
		System.out.println(bag.equals(bag3));
		}
		
		
	}
}
