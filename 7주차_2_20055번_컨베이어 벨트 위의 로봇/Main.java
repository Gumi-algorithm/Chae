package com.baekjoon.p20055;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	static int N, K;
	static int[] arr;
	static int[] robot;
	static int rst;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[2 * N];
		robot = new int[N];
		rst = 0;
		check = false;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 2 * N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}

		while (!check) 
		{
			rst++;

			int temp = arr[(2 * N) - 1]; // 맨 마지막 원소 저장 후 하나씩 이동		
			for (int i = (2 * N) - 1; i >= 1; i--) arr[i] = arr[i - 1];
			arr[0] = temp; // 맨 마지막 원소 첫 원소로 저장

			for (int i = N - 1; i >= 1; i--) robot[i] = robot[i - 1]; // 벨트가 이동 하면서 로봇도 한칸씩 이동
			robot[0]=0;

			for (int i = N - 1; i >= 0; i--) 			// 로봇 한칸 이동
			{
				if(i==N-1) //내려가는 위치에서 땅으로 내려옴
				{
					robot[i]=0;
					continue;
				}

				if (robot[i] == 1 && robot[i + 1] == 0 && arr[i + 1] > 0) // 앞에 로봇이 없고 내구도가 0 이상일때
				{
					robot[i] = 0;
					robot[i + 1] = 1;
					arr[i+1]--;
				}
			}

			if(arr[0]>0 && robot[0]==0) // 올라가는 위치에서 로봇 올림
			{
				arr[0]--;
				robot[0]=1;
			}

			int cnt=0;
			for(int i=0; i<2*N; i++) //내구도 판단
			{
				if(arr[i]==0) 
				{
					cnt++;
				}
				if(cnt>=K) 
				{
					check = true;
					break;
				}
			}
		}

		sb.append(rst);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
