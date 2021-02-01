package com.beakjoon.p1991;

import java.util.Scanner;

//7
//A B C
//B D .
//C E F
//E . .
//F . G
//D . .
//G . .

class Node {

	private Node left; // 왼쪽 서브 트리
	private Node right; // 오른쪽 서브 트리
	private char data;
	
	public Node(char data) {
		left = null;
		right = null;
		this.data = data;
	}
	
	public void makeLeft(Node sub) { // 왼쪽 서브 트리 연결
		if(sub.getData() == '0') // 노드의 데이터가 0인 경우는 null 반환
		{
			return;
		}
		
		if(this.left != null) {
			this.left = null;
		}
		this.left = sub;
	}
	
	public void makeRight(Node sub) { // 오른쪽 서브 트리 연결
		if(sub.getData() == '0') // 노드의 데이터가 0인 경우는 null 반환
		{
			return;
		}
		
		if(this.right != null) {
			this.right = null;
		}
		this.right = sub;
	}
	
	public char getData() {
		return this.data;
	}
	
	public Node getLeft() {
		return this.left;
	}
	
	public Node getRight() {
		return this.right;
	}
}

public class Main {
	public static void main(String[] args) {
		
		char[] abc = new char[26]; // 1 <= N <= 26
		for(int i = 0 ; i < 26; i++)
		{
			abc[i] = (char)( 65 + i); // 미리 배열에 알파벳 입력
		}
		
		
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt(); // N 입력
		Node[] node = new Node[testCase];
		
		for(int j = 0; j < testCase; j++ )
		{
			node[j] = new Node(abc[j]); // N의 갯수만큼 노드 생성
		}
		
		for(int k = 0; k < testCase; k++ )
		{
			char data = sc.next().charAt(0);
			for(int l = 0; l < testCase; l++) {
				if(node[l].getData() == data) { // 첫문자와 동일한 노드에 왼쪽 오른쪽 노드 연결
					node[l].makeLeft(getNode(node,sc.next().charAt(0)));
					node[l].makeRight(getNode(node,sc.next().charAt(0)));
				}
			}
		}
		
		Node start = node[0];
		preNode(start);
		System.out.println();
		inNode(start);
		System.out.println();
		postNode(start);
		System.out.println();
		
		sc.close();
	}
	
	public static Node getNode(Node[] arr,char a) // 노드 배열중에 데이터가 a인 노드 찾아서 반환
	{
		Node empty = new Node('0');
		if(a == '.')
		{
			return empty; // .이 입력되면 0인 노드 반환
		}
		for(int i = 0; i < arr.length;i++)
		{
			if(arr[i].getData() == a)
			{
				return arr[i];
			}
		}
		return empty;
	}
	
	public static void preNode(Node node) // 재귀를 이용한 전위 순회
	{
		System.out.print(node.getData());
		if(node.getLeft() != null) preNode(node.getLeft());
		if(node.getRight() != null) preNode(node.getRight());
	}
	
	public static void inNode(Node node) // 재귀를 이용한 중위 순회
	{
		if(node.getLeft() != null) inNode(node.getLeft());
		System.out.print(node.getData());
		if(node.getRight() != null) inNode(node.getRight());
	}
	
	public static void postNode(Node node) // 재귀를 이용한 후위 순회
	{
		if(node.getLeft() != null) postNode(node.getLeft());		
		if(node.getRight() != null) postNode(node.getRight());
		System.out.print(node.getData());
	}
	
}
