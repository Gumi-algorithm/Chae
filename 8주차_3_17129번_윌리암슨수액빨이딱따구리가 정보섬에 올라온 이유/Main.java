package com.baekjoon.p17129;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static Queue<Node> q;
	static int rst;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		dist = new int[n][m];
		visited = new boolean[n][m];
		q = new LinkedList<>();
		rst = Integer.MAX_VALUE;
		boolean check = false;
		
		for(int i = 0; i < n; i++)
		{
			String[] s = br.readLine().split("");
			for(int j = 0; j < m; j++)
			{
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] == 2) q.add(new Node(i,j));
			}
		}
		
		
		while(!q.isEmpty())
		{
			Node node = q.remove();
			int x = node.x;
			int y = node.y;
			
			
			for(int i = 0; i < 4; i++)
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				if( nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
				if(map[nx][ny] == 1) continue;
				if(!visited[nx][ny])
				{
					visited[nx][ny] = true;
					dist[nx][ny] = dist[x][y] + 1;
					if(map[nx][ny] > 2 && map[nx][ny]< 6)
					{
						check = true;
						if(rst > dist[nx][ny]) rst = dist[nx][ny];
					}
					q.add(new Node(nx,ny));
				}	
			}
		}
		
		if(check) sb.append("TAK").append("\n").append(rst);
		else sb.append("NIE").append("\n");
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
class Node{
	int x;
	int y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
