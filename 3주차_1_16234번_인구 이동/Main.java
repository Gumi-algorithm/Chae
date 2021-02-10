package com.beakjoon.p16926;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int[][] arr;
	static int[] dy = { 0, 1 ,0, -1};
	static int[] dx = { -1, 0,	1, 0};
	
	static void solve(int y, int x, int r, int value)
	{
		int cnt = 0;
		int round = 0;
		int ky = y;
		int kx = x;
		while(true) {
			if(round == r) {
				arr[ky][kx] = value;
				break;
			}
			if(cnt >= M/2+1 || cnt >= N/2+1) {
				break;
			}
			
			if(kx == 0 + cnt && ky < N-1 -cnt ) {
				ky += dy[1];
				kx += dx[1];
			}
			else if( ky == N - 1 - cnt && kx < M - 1 - cnt) {
				ky += dy[2];
				kx += dx[2];
				
			}
			else if( kx == M - 1 - cnt && 0 + cnt < ky) {
				ky += dy[3];
				kx += dx[3];
			}
			else if(ky == 0 + cnt && 0 + cnt < kx ) {
				ky += dy[0];
				kx += dx[0];
			}
			else {
				cnt++;
				continue;
			}
			round++;
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		//2 1 1 1 1
		//2 2 1 1 4
		//2 2 0 4 4
		//2 3 3 4 4
		//3 3 3 3 4
		
		
		//2 1 1
		//2 0 4
		//2 0 4
		//3 3 4
		
		//2 1 1 1
		//2 2 1 4
		//2 2 4 4
		//2 3 4 4
		//3 3 3 4
		
		
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
			{
				solve(i, j, R, Integer.parseInt(st.nextToken()));
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < M; j++)
			{
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
