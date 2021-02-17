package com.baekjoon.p10026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N; // 크기
	static char[][] map; // 그리드
	static boolean[][] visited; // 방문체크
	static int[] dy = {0, 1, 0, -1}; // 상하좌우
	static int[] dx = {-1, 0, 1, 0}; // 상하좌우
	
	static Queue<Node> queue = new LinkedList<>();



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine()); // 그리드 크기 입력
		map = new char[N][N]; // N * N 크기의 배열 생성
		visited = new boolean[N][N]; // N * N 크기의 방문체크 배열 생성
		
		int rst1 = 0; // 정상인의 구역의 개수
		int rst2 = 0; // 적록색약인의 구역의 개수

		for(int i = 0; i < N; i++)
		{
			String s = br.readLine();
			for(int j = 0; j < N; j++)
			{
				map[i][j] = s.charAt(j); // 그림 입력
			}
		}
		
		

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) { // 방문하지 않았다면
					bfs(new Node(i,j)); // 현재 그림의 색 bfs
					rst1++;
				}
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				visited[i][j] = false; // 방문 배열 초기화
			}
		}
		
		for(int i = 0; i < N; i++) {
            		for(int j = 0; j < N; j++) {
                		if(map[i][j] == 'G') { // 녹색을 빨간색으로 변경
                    			map[i][j] = 'R';
                		}
            		}
        	}
        
        	for(int i = 0; i < N; i++) {
            		for(int j = 0; j < N; j++) {
                		if(!visited[i][j]) {
                    			bfs(new Node(i,j)); // bfs
                    			rst2++;
                		}
            		}
        	}
        
        	sb.append(rst1).append(" ").append(rst2);
        	bw.write(sb.toString());
        	bw.flush();
        	br.close();
        	bw.close();
	}
	
	static void bfs(Node node) {
		char color = map[node.y][node.x]; // 현재 그림의 색
		visited[node.y][node.x] = true; // 방문
		queue.offer(node); // 현재 그림을 큐에 넣기

		while(!queue.isEmpty()){ // 큐가 비었을때 까지
			Node n = queue.poll(); // 큐에서 뽑기
			int ny = n.y; // 뽑은 노드의 y값
			int nx = n.x; // 뽑은 노드의 x값
			for(int i = 0; i < 4; i++) // 상하좌우
			{		
				int ty = ny + dy[i];
				int tx = nx + dx[i];
				
				if(ty >= 0 && ty < N && tx >= 0 && tx < N && map[ty][tx] == color && !visited[ty][tx]) // 배열의 범위를 넘어서지 않고 방문 하지 않았고 같은 그림의 색일때
				{
					queue.offer(new Node(ty, tx)); // 같은 그림의 색깔 큐에 넣기
					visited[ty][tx] = true; // 방문
				}
			}
		}

	}

}

class Node{
	int y;
	int x;

	public Node(int y, int x)
	{
		this.y = y;
		this.x = x;
	}
}
