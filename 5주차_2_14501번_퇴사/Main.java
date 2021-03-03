package com.baekjoon.p14501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main { 
	
	static int N;
	static int rst;
	static int[][] TP; 
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st; 
		
		N = Integer.parseInt(br.readLine()); // 남은 일수
		rst = 0; // 최대 이익
		TP = new int[N][2];
		for (int i = 0; i < N; i++) 
		{
			st = new StringTokenizer(br.readLine()); 
			TP[i][0] = Integer.parseInt(st.nextToken()); // 상담에 걸리는 일수
			TP[i][1] = Integer.parseInt(st.nextToken()); // 상담 후 금액
		} 
		
		dfs(0, 0);
		
		sb.append(rst);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	} 
	private static void dfs(int index, int value) { 
		if (index >= N) { 
			if(value > rst) rst = value;
			return; 
		} 

		if (index + TP[index][0] <= N) dfs(index + TP[index][0], value + TP[index][1]);
		else dfs(index + TP[index][0], value);
		dfs(index + 1, value);
	}
}
