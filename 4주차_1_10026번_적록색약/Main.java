package com.baekjoon.p10026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N;
	static char[][] map;
	static boolean[][] visited;
	static int[] dy = {0, 1, 0, -1};
	static int[] dx = {-1, 0, 1, 0};
	
	static Queue<Node> queue = new LinkedList<>();



	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		
		int rst1 = 0;
		int rst2 = 0;

		for(int i = 0; i < N; i++)
		{
			String s = br.readLine();
			for(int j = 0; j < N; j++)
			{
				map[i][j] = s.charAt(j);
			}
		}
		
		

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j]) {
					bfs(new Node(i,j));
					rst1++;
				}
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			for(int j = 0; j < N; j++)
			{
				visited[i][j] = false;
			}
		}
		
		for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 'G') {
                    map[i][j] = 'R';
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    bfs(new Node(i,j));
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
		char color = map[node.y][node.x];
		visited[node.y][node.x] = true;
		queue.offer(node);

		while(!queue.isEmpty()){
			Node n = queue.poll();
			int ny = n.y;
			int nx = n.x;
			for(int i = 0; i < 4; i++)
			{		
				int ty = ny + dy[i];
				int tx = nx + dx[i];
				if(ty >= 0 && ty < N && tx >= 0 && tx < N && map[ty][tx] == color && !visited[ty][tx])
				{
					queue.offer(new Node(ty, tx));
					visited[ty][tx] = true;
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
