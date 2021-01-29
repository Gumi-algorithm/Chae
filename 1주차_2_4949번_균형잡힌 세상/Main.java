package com.beakjoon.p4949;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> result = new ArrayList<>();
		
		while(true) {
			String line = sc.nextLine();
			if(line.equals(".")) break;
			String[] arr = line.split("");
			myStack st = new myStack(arr.length);
//			myStack str = new myStack(arr.length);
//			int[] rst = new int[6];	
//			boolean check = true;
			for(int i = 0; i < arr.length; i++)
			{
				if(arr[i].charAt(0) == '[' ) {
					st.push(arr[i]);
				}
				else if( arr[i].charAt(0) == '{') {
					st.push(arr[i]);
//					rst[1]++;
				}
				else if( arr[i].charAt(0) == '(') {
					st.push(arr[i]);
//					rst[2]++;
				}			
				else if( arr[i].charAt(0) == ']') {
					if(st.peek() != null && st.peek().charAt(0) == '[')
					{
						st.pop();
					}
//					st.push(arr[i]);
//					 rst[3]++;
//					if(rst[0] == 0) check = false;
//					else continue;
				}
				else if( arr[i].charAt(0) == '}') { 
					if(st.peek() != null && st.peek().charAt(0) == '{')
					{
						st.pop();
					}
					
					//st.push(arr[i]);
//					rst[4]++;
//					if(rst[1] - 1 == rst[4]) 
//					else continue;
				}
				else if( arr[i].charAt(0) == ')') {
					
					if(st.peek() != null && st.peek().charAt(0) == '(')
					{
						st.pop();
					}
					//st.push(arr[i]);
//					rst[5]++;
//					if(rst[2] - 1 == rst[5]) 
//					else continue;
				}
			}
			if(st.top == -1)
			{
				result.add("yes");
			}
			else result.add("no");			
		}
		for(int j = 0; j < result.size() ;j++)
		{
			System.out.println(result.get(j));
		}
	}
}

class myStack{
	int top;
	String [] stack;
	public int size;

	public myStack(int size) {
		this.size = size; //
		stack = new String[size];
		top = -1; // top 의 값 초기화
	}

	public void push(String item) {
		stack[++top] = item;
	}


	public void pop() {
		if( top > -1) stack[top--] = null;
	}
	
	public String peek() {
		if( top > -1) {
			return stack[top];
		}
		return null;
    }

	private boolean empty() {
		return size == 0;
	}

}





//System.out.println((int)'[');
	//		System.out.println((char)92);
	//		System.out.println((int)']');
	//		System.out.println((int)'(');
	//		System.out.println((int)')');
	//		System.out.println((int)'{');
	//		System.out.println((char)124);
	//		System.out.println((int)'}');

	//Stack<String> stack = new Stack<>();
	//ArrayList<String> list = new ArrayList<>();