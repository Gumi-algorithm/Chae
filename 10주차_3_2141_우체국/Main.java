package com.baekjoon.p2141;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;



// 3
// 1 3
// 2 5
// 3 3


// 2
// 1 1
// 2 2


// 그냥 중간?
// 거리의 합이 아니라 사람마다 거리의 합
// 사람이 많을 수록 거리가 짧아야 함


public class Main {

	static int N;
	static int[][] X;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		ArrayList<Node> list = new ArrayList<>();

		N = Integer.parseInt(br.readLine());
		long sum = 0;
		long tmp = 0;

		for(int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			long x = Long.parseLong(st.nextToken());
			long a = Long.parseLong(st.nextToken());
			list.add(new Node(x,a));
			sum += a;
		}

		Collections.sort(list, (n1, n2) -> {
			return (int) (n1.x - n2.x);
		});
		
		if(sum % 2 != 0)
		{
			sum += 1;
		}
		
		long temp = sum/2;
		
		for(int i = 0; i < N; i++)
		{	
			tmp += list.get(i).a;
			if(tmp >= temp) {
				sb.append(list.get(i).x);
				break;
			}
		}

		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
class Node{
	long x;
	long a;
	public Node(long x, long a) {
		this.x = x;
		this.a = a;
	}
	public long getA() {
		return a;
	}
}
