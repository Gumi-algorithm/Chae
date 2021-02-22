package com.baekjoon.p2448;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static char[][] map;
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		int N = Integer.parseInt(br.readLine()); // 줄의 수
		map = new char[N][(N * 2) - 1]; // 배열 생성
		// 3 일 때 5
		// 6 일 때 11
		// 12 일 때 23
		
		
		// 맨위 중앙에 기본 형태를 만들고 
		// n/2를 더하면서 밑으로 내려가서 별 찍기 
		// 중앙점에서 n/2를 더한곳과 뺀곳에 기본 형태 만들기
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < (N * 2) - 1; j++)
			{
				map[i][j] = ' '; // 배열 초기화
			}
		}
		
		
		
		solve(0, N-1, N); // 맨위의 별이 중앙에 오도록 0, N-1 부터 시작
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < (N * 2) - 1; j++)
			{
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void solve(int r, int c, int n)
	{
		if(n == 3)
		{
			map[r][c] = '*';
			map[r + 1][c + 1] = '*';
			map[r + 1][c - 1] = '*';
			for(int i = -2; i < 3; i++)
			{
				map[r + 2][c + i] = '*';
			}
		}
		else
		{
			int m = n / 2;
			solve(r, c, m); 
			solve(r + m, c + m, m); 
			solve(r + m, c - m, m);
		}
	}

}
