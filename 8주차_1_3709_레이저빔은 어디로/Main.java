package com.baekjoon.p3709;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;




//2 testCase
//2 3 보드 크기, 우양우 거울
//1 1
//1 2
//2 2
//3 1 레이저 좌표

//3 6 보드 크기, 우양우 거울
//1 1
//1 3
//2 2
//2 3
//3 1
//3 2
//2 0 레이저 좌표

public class Main {
    static int[][] map;
    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static StringBuilder sb;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;
        int testCase = Integer.parseInt(br.readLine());

        for(int t=0; t< testCase; t++) {
        	st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            
            map = new int[N+2][N+2]; // 1 ~ N+1, (레이저 좌표 추가)

            for(int i=0 ;i<M; i++) {
            	st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            // 레이저 좌표는 0 or N+1이 포함된다
            if(x==0) dfs(x+1, y, 2); // 아래쪽으로 쏨
            else if(y==0)dfs(x, y+1, 1); // 오른쪽으로 쏨
            else if(x==N+1) dfs(x-1, y, 0); // 위쪽으로 쏨
            else if(y==N+1) dfs(x, y-1, 3); // 왼쪽의로 쏨
            
        }
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();   
    }

    public static void dfs(int x, int y, int d) {
        if(x==0 || x==N+1 || y==0 || y==N+1) {
            sb.append(x).append(" ").append(y).append("\n");
            return;
        }
        // 0 -> 1
        // 1 -> 2
        // 2 -> 3
        // 3 -> 4
        // 4 -> 0

        if(map[x][y]==1) { // 우양우 거울이 있다면
            int nd = d+1;
            if(nd == 4) nd = 0;
            dfs(x+dx[nd], y +dy[nd], nd);
        }
        else dfs(x+dx[d], y +dy[d], d); // 없으면
    }
}