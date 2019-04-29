package com.ds.graph;

public class TestRecursion {

	public static void main(String[] args) {
		int total= 0;
		printNum(10,total);
		System.out.println("Total=" + total);

	}
	
	public static int printNum(int num,int total){
		if(num==0){
			System.out.println("Recursion ends Here");
			
		}else{
			total+= printNum(num-1, total);
		}
		return num;
	}

}
