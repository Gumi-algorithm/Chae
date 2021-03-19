package com.baekjoon.p2573;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[][] melt;
	static int rst;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		melt = new int[N][M];
		rst = 0;

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;


		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] != 0) {
					if(max < map[i][j]) max = map[i][j];
					if(min > map[i][j]) min = map[i][j];
				}
			}
		}

		while(true) {
			
			cnt = 0; // 빙산 덩어리 갯수
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(!visited[i][j] && map[i][j] != 0) { // 모두 0이면 다 녹은 상태라서 cnt = 0
						dfs(i, j);                         // 덩어리가 2개 이상이면 dfs로 1번에 모두 방문 불가
						cnt++;
					}
				}
			}

			if(cnt >= 2)  { // 덩어리가 2개 이상이면 종료
				sb.append(rst);
				break;
			}
			if(cnt == 0) { // 덩어리가 나누어 지지 않고 다 녹으면
				sb.append(0);
				break;
			}

			melting(); // 0의 갯수 만큼 녹이기
			rst++; // 1년 추가
		}


		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	static void dfs(int x, int y) {
		visited[x][y] = true;	 
		for(int i=0; i<4; i++) 
		{
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(0 <= nx && nx < N && 0 <= ny && ny < M) 
			{
				if(map[nx][ny] == 0) melt[x][y]++; // 0의 갯수
				if(!visited[nx][ny] && map[nx][ny] != 0) dfs(nx, ny);                    
			}
		}
	}

	static void melting() {	
		for(int i = 0; i < N; i++) 
		{
			for(int j = 0; j < M; j++) 
			{
				map[i][j] -= melt[i][j]; // 주변의 0의 갯수만큼 녹이기
				if(map[i][j] < 0) map[i][j] = 0;  // 0보다 작아지면 0으로 바꿔주기
				visited[i][j] = false; // 방문 초기화
				melt[i][j] = 0; // 0의 갯수 초기화
			}
		}
	}

}
