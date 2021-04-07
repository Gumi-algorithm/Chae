package com.baekjoon.p2212;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// 6
// 2
// 1 6 9 3 6 7
// 1 3 6 6 7 9
// 간격이 크면 끊는다?
//  2 3 0 1 2
//  0 1 2 2 3

public class Main {
	
	static int N, K;
	static int[] arr;
	static int[] dist;
	static int rst;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        arr = new int[N];
        dist = new int[N-1];
        rst = 0;
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
        {
        	arr[i] = Integer.parseInt(st.nextToken());
        }    
        Arrays.sort(arr);
        
        for(int i = 0; i < N-1; i++)
        {
        	dist[i] = arr[i+1] - arr[i];
        }
        Arrays.sort(dist);
        
        for(int i = 0; i < N - K; i++)
        {
        	rst += dist[i];
        }
        sb.append(rst);
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
	}

}
