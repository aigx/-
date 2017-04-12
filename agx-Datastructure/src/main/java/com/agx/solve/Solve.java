package com.agx.solve;

public class Solve {

	private int totlenum;
	
	public Solve(int totlenum){
		this.totlenum = totlenum;
	}
	
	public void Solve(){
		moveS(totlenum, 1,3, 2);
	}
	
	//应该是移动原盘堆的方法
	public void moveS(int totle, int start, int end, int temp){
		
		if(totle == 1){
			printS(start,end);
		}else{
			moveS(totle-1,start,temp,end);
			printS(start,end);
			moveS(totle-1,temp,end,start);
		}
		
	}
	//移动最终的原盘的方法
	public void printS(int start,int end){
		System.out.println("把一个圆盘从"+start+"移动到"+end);
	}
}