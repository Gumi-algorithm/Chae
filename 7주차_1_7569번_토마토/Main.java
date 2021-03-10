package com.baekjoon.p7569;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = { -1, 0, 1, 0, 0, 0};
	static int[] dy = { 0, 1, 0, -1, 0, 0};
	static int[] dz = { 0, 0, 0, 0, -1, 1};
	static int M;
	static int N;
	static int H;
	static int[][][] map;
	static int[][][] dist;
	static Queue<Node> queue = new LinkedList<>();
	static int rst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N][M];
		dist = new int[H][N][M];
		rst = 0;
		for(int k = 0; k < H; k++) 
		{
			for(int i = 0; i < N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++)
				{
					map[k][i][j] = Integer.parseInt(st.nextToken());
					if(map[k][i][j] == 1) queue.add(new Node(k,i,j)); // 익은 토마토 큐에 입력

				}
			}
		}
		bfs();
		check(); // 걸리는 일수 체크 
		sb.append(rst);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();

	}
	static void bfs()
	{
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			int x = n.x;
			int y = n.y;
			int z = n.z;
			for (int i = 0; i < 6; i++) 
			{
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if (0 <= nx && nx < H && 0 <= ny && ny < N && 0 <= nz && nz < M && map[nx][ny][nz] == 0 && dist[nx][ny][nz] == 0) 
				{
					queue.add(new Node(nx, ny, nz));
					dist[nx][ny][nz] = dist[x][y][z] + 1;
				}
			}
		}
	}
	
	static void check()
	{
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (rst < dist[k][i][j])
						rst = dist[k][i][j];
				}
			}
		}

		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[k][i][j] == 0 && dist[k][i][j] == 0) {
						rst = -1;
					}
				}
			}
		}
	}

}
class Node{
	int x;
	int y;
	int z;

	public Node(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
}