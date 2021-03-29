package com.baekjoon.p2110;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


// 1, 4, 8
//  3  4
// 1, 4, 9
//  3  5

// 3이상으로 하면 3대를 설치 못한다.


public class Main {
	static int N, C;
	static int[] arr;
	static int rst;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 집의 갯수
		C = Integer.parseInt(st.nextToken()); // 공유기 갯수
		arr = new int[N]; // 집을 담는 배열
		rst = 0; // 결과값
		
		for(int i = 0; i < N; i++)
		{
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); // 정렬
		
		int min = 1; // 최소값
		int max = arr[N-1] - arr[0]; // 최댓값(첫번째 원소와 마지막 원소의 차이)
		
		while(max >= min)
		{
			int mid = (max + min)/2; // 중간값
			int cnt = 1; // 공유기 설치 갯수
			int temp = arr[0]; // 첫위치에 설치
			
			for(int i = 0; i < N; i++)
			{
				int dist = arr[i] - temp;
				if(dist >= mid) { // 거리의 차이가 중간값보다 크면 설치
					temp = arr[i]; 
					cnt++; // 공유기 설치
				}
			}
			if(cnt < C) { // 간격 줄임
				max = mid -1;
			}
			else {	//간격 늘림
				min = mid +1;
				rst = mid;
			}
		}
		sb.append(rst);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
