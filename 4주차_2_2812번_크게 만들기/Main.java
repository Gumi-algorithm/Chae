package com.baekjoon.p2812;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		//		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		Stack<Integer> stack = new Stack<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		String[] s = br.readLine().split(""); // 숫자하나씩 분리
		
		
		for(int i = 0; i < N; i++)
		{
			int temp = Integer.parseInt(s[i]); // 숫자 하나
			if(stack.isEmpty()) // 맨 처음에는 무조건 푸시
			{
				stack.push(temp);
			}
			else
			{
				while(!stack.isEmpty()) // 스택이 비어있지 않다면 반복
				{
					if(cnt == K) break; // K만큼 지웟으면 종료
					if(stack.peek() < temp ) // 현재 숫자가 스택에 있는 숫자보다 크면 스택팝
					{
						stack.pop();
						cnt++;
					}
					else if(stack.peek() >= temp) break; // 현재 숫자가 작으면 종료
				}
				stack.push(temp);
			}
		}
		
		
		
		if(cnt < K) // K만큼 못 지웠다면
		{
			for(int i = 0; i < stack.size() - (K - cnt); i++)
			{
				sb.append(stack.get(i));
			}
		}
		else
		{
			for(int i = 0; i < stack.size(); i++)
			{
				sb.append(stack.get(i));
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
