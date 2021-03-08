package com.baekjoon.p14888;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] arr;
	static int[] oper;
	static int max;
	static int min;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());	
		arr = new int[N];
		oper = new int[4]; // +, -, *, /
		max = Integer.MIN_VALUE; // 최대값
 		min = Integer.MAX_VALUE; // 최소값
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int j = 0; j < 4; j++)
		{
			oper[j] = Integer.parseInt(st.nextToken());
		}
		
		cal(1, arr[0], oper[0], oper[1], oper[2], oper[3]);
		sb.append(max).append("\n").append(min);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void cal(int num, int sum, int plus, int minus, int multi, int div)
	{
		if(N == num)
		{
			if(max < sum) max = sum;
			if(min > sum) min = sum;
			return;
		}
		
		if(plus > 0) cal(num+1, sum+arr[num], plus-1, minus, multi, div); // 플러스 연산
		if(minus > 0) cal(num+1, sum-arr[num], plus, minus-1, multi, div); // 마이너스 연산
		if(multi > 0) cal(num+1, sum*arr[num], plus, minus, multi-1, div); // 곱하기 연산
		if(div > 0) cal(num+1, sum/arr[num], plus, minus, multi, div-1); // 나누기 연산
	}

}
