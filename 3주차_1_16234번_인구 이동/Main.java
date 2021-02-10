package com.beakjoon.p16234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N; // 땅의 크기 N*N
	static int L; // 인구 차이가 L명 이상
	static int R; // 인구 차이가  R명 이하
	static int[][] A; // 나라별 인구수
	static int[][] copyA;
	static boolean[][] visited;
	static int rst; // 인구 이동 횟수
	static int c;
	static int[] dy = { 0, 0, -1, 1}; // 상하좌우 위한 y값
	static int[] dx = { -1, 1, 0, 0}; // 상하좌우 위한 x값
	static int sum; // 국경을 연 국가의 인구수 합 
	static int cnt; // 국경을 연 국가의 수
	static ArrayList<int[]> arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 땅의 크기 입력
		L = Integer.parseInt(st.nextToken()); // 최소 인구차이 입력
		R = Integer.parseInt(st.nextToken()); // 최대 인구차이 입력
		A = new int[N][N]; // 땅의 크기만큼 배열 선언
		rst = 0; // 결과값 초기화
		
		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
			{
				A[i][j] = Integer.parseInt(st.nextToken()); // 나라별 인구수 입력
			}
		}
		
		while(true) {
			copyA = new int[N][N];
			visited = new boolean[N][N];		
			c = 1;
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < N; j++)
				{
					if(copyA[i][j] == 0)
					{
						arr = new ArrayList<>();
						sum = A[i][j];
						arr.add(new int[] {i, j});
						cnt = 1;
						
						dfs(i, j);
						c++;
						
						if(cnt > 1)
						{
							for(int t = 0; t < arr.size(); t++) 
							{
								A[arr.get(t)[0]][arr.get(t)[1]] = sum / cnt; //인구수 통일
							}
						}
					}
				}
			}
			if(c-1 == N * N) { // 종료조건
				break;
			}
			rst++;	
		}
		sb.append(rst);	
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();	
	}
	
	public static void dfs(int y, int x)
	{
		copyA[y][x] = c;
		visited[y][x] = true;
		
		for(int i = 0; i < 4; i++) // 상하좌우 탐색
		{
			int ny = y + dy[i];
			int nx = x + dx[i];
			if( ny >= 0 && nx >= 0 && ny < N && nx < N)
			{
				int k = Math.abs(A[y][x] - A[ny][nx]); // 인구수의 차이(절대값)
				if( k >= L && k <= R && !visited[ny][nx]) // 인구수 차이가 L보다 크거나 같고 R보다 작거나 같다
				{
					cnt++;
					sum += A[ny][nx];
					arr.add(new int[] {ny, nx});
					dfs(ny, nx);
				}
	
			}
		}
	}

}
