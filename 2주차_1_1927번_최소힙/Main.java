package com.beakjoon.p1927;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int testCase = sc.nextInt();
		for(int i =0; i < testCase; i++)
		{
			int num = sc.nextInt();
			if( num == 0)
			{
				if( q.isEmpty()) System.out.println(0);
				else System.out.println(q.poll());
			}
			else q.add(num);
		}
	}
}
