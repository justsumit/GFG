package com.programming.recursion;

public class RecursivePrint {

	public static void main(String[] args) {
		//printNum(10);
		System.out.println(fun1(5, 2));

	}
	
	public static void printNum(int n){
		if(n<1){
			return;
		}else{
			System.out.println(n);
			printNum(n-1);
			System.out.println(n);
		}
	}
	
	public static int fun1(int x, int y) 
	{ 
	if(x == 0) 
		return y; 
	else
		return fun1(x - 1, x + y); 
	} 


}
