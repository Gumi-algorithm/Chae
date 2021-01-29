package com.beakjoon.p4949;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> result = new ArrayList<>(); // 결과 출력을 위한 ArrayList 생성
		
		while(true) { 
			String line = sc.nextLine(); // 한줄씩 입력
			if(line.equals(".")) break; // .하나 들어오면 종료
			String[] arr = line.split(""); // 한글자씩 분리
			myStack st = new myStack(arr.length); // 스택 생성

			for(int i = 0; i < arr.length; i++)
			{
				if(arr[i].charAt(0) == '[' ) st.push(arr[i]);
				else if( arr[i].charAt(0) == '{') st.push(arr[i]);
				else if( arr[i].charAt(0) == '(') st.push(arr[i]);
				else if( arr[i].charAt(0) == ']') {
					if(st.peek() != null && st.peek().charAt(0) == '[') st.pop(); // 스택의 맨위가 열리는 괄호일때 pop
				}
				else if( arr[i].charAt(0) == '}') { 
					if(st.peek() != null && st.peek().charAt(0) == '{') st.pop();
				}
				else if( arr[i].charAt(0) == ')') {
					if(st.peek() != null && st.peek().charAt(0) == '(') st.pop();
				}
			}
			
			if(st.top == -1) // 열리는 괄호가 다 빠려나가면 top은 -1
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
	int size;

	public myStack(int size) { // 스택 생성자
		this.size = size;
		stack = new String[size];
		top = -1; // top 의 값 초기화
	}

	public void push(String item) { // 스택 푸시
		stack[++top] = item;
	}


	public void pop() { // 스택 팝
		if( top > -1) stack[top--] = null;
	}
	
	public String peek() { // 스택 피크
		if( top > -1) {
			return stack[top];
		}
		return null;
    }
}