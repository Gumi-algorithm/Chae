package com.baekjoon.p11562;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 9999999;
	static int N, M, K;
	static int[][] adjMatrix;
	static int rst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 건물의 수
        M = Integer.parseInt(st.nextToken()); // 길의 수
        
        adjMatrix = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) 
        {
            for (int j = 1; j <= N; j++) 
            {
                if (i != j) adjMatrix[i][j] = INF; // 초기화
            }
        }
        
        for (int i = 0; i < M; i++) 
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken()); // 1 : 양방향, 0 : 일반통행
 
            adjMatrix[u][v] = 0; // u != v;
            if(b==0) adjMatrix[v][u] = 1;
            else adjMatrix[v][u] = 0;
        }
        
        for (int k = 1; k <= N; k++) // 플로이드 와샬
        {
            for (int i = 1; i <= N; i++) 
            {
                for (int j = 1; j <= N; j++) 
                {
                    if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
                }
            }
        }
        
        K = Integer.parseInt(br.readLine()); // 학생의 질문의 수
        for(int i = 0; i < K; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(adjMatrix[s][e] + "\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();    
	}

}
