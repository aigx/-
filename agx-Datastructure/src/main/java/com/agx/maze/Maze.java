package com.agx.maze;

import java.util.Random;

public class Maze {

	private final int TRIED = 3;
	private final int PATH = 7;
	
//	private int[][] grid = {
//		{1,1,1,0,1,1,0,0,0,1,1,1,1},
//		{1,0,1,1,1,0,1,1,1,1,0,0,1},
//		{0,0,0,0,1,0,1,0,1,0,1,0,0},
//		{1,1,1,0,1,1,1,0,1,0,1,1,1},
//		{1,0,1,0,0,0,0,1,1,1,0,0,1},
//		{1,0,1,1,1,1,1,1,0,1,1,1,1},
//		{1,0,0,0,0,0,0,0,0,0,0,0,0},	
//		{1,1,1,1,1,1,1,1,1,1,1,1,1},	
//	};
	
	private int[][] grid = new int[20][20];
	private static Random rand = new Random();
	
	public Maze(){
		for(int i = 0;i<20;i++){
			for(int a = 0 ;a<20;a++){
				grid[i][a] = rand.nextInt(2);
			}
		}
//		System.out.println("生成迷宫：");
//		System.out.println(this);
	}
	
	public boolean trygo(int col,int column){
		boolean down = false;
		if(cango(col,column)){
			grid[col][column] = TRIED;
			if(col==grid.length-1&&column==grid[col].length-1){
				down = true;
			}
			if(!down){
				down = trygo(col-1,column); //上
			}
			if(!down){
				down = trygo(col+1,column); //下
			}
			if(!down){
				down = trygo(col,column-1); //左
			}
			if(!down){
				down = trygo(col,column+1); //右
			}
		}
		if(down){
			grid[col][column] = PATH;
		}
		
		return down;
	}
	
	public boolean cango(int col,int column){
		boolean go = false;
		if(col>=0&&col<=grid.length-1&&column>=0&&column<=grid[col].length-1){
			if(grid[col][column]==1){
				go = true;
			}
		}
		
		return go;
	}
	
	@Override
	public String toString(){
		String result="";
		for(int i = 0;i<20;i++){
			for(int a = 0;a<20;a++){
				result = result + " " + grid[i][a];
			}
			result += "\n";
		}
		return result;
		
	}
	
}
