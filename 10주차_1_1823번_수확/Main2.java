package com.baekjoon.p1823;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// 5
// 1
// 3
// 1
// 5
// 2
public class Main2 {
	static int N;
	static int[] v;
	static int[][] dp;
	static int rst;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		v = new int[N+1];
		dp = new int[N+1][N+1];
		rst = 0;
		
		for(int i = 1; i <= N; i++)
		{
			v[i] = Integer.parseInt(br.readLine());
			dp[i][i] = v[i] * N;
			
			for(int j = i -1; j > 0; j--)
			{
				dp[j][i] = Math.max(dp[j+1][i] + v[j] * (N - i + j), dp[j][i-1] + v[i] * (N - i + j));
			}
		}
		
		rst = dp[1][N];
		sb.append(rst);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}

}
