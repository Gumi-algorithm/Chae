package com.baekjoon.p1697;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class solve {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
 
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
 
        if(N >= K) sb.append(N-K); // 동생 보다 멀리 있다면 순간이동 불가
        else sb.append(bfs(N, K));
        
        
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
 
    static int bfs(int n, int k) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int[] arr = new int[100001];
 
        queue.offer(n);
        arr[n] = 1;
 
        
        while(!queue.isEmpty()) {
            int now = queue.poll();
 
            for(int i=0; i<3; i++) 
            {
                int next;
                
                if(i == 0) next = now - 1; // X-1
                else if(i == 1) next = now + 1; // X+1
                else next = now * 2; // 2*X
 
                if(next == k) return arr[now]; // 동생의 위치와 같으면 종료           
 
                if(0 <= next && next <= 100000) 
                {
                    if(arr[next] == 0) 
                    {
                        queue.offer(next); // 큐에 추가
                        arr[next] = arr[now] + 1; // 시간 1초 추가
                    }
                }
            }
        }
        
        
        return 0;
    }
}
