package com.baekjoon.p1092;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		ArrayList<Integer> crane = new ArrayList<>();
		ArrayList<Integer> box = new ArrayList<>();
		int rst = 0;
		
		//크레인 입력
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
		{
			crane.add(Integer.parseInt(st.nextToken()));
		}
		
		//박스 입력
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++)
		{
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		//람다를 이용한 내림차순정렬
		Collections.sort(crane, (i1,i2)->i2-i1);
		Collections.sort(box, (i1,i2)->i2-i1);
		

		if(box.get(0)>crane.get(0)) rst = -1; // 박스가 크레인보다 크다면 옮기지 못해서 -1출력
		else 
		{
			while(box.size() != 0)
			{
				int idx = 0;
				int temp = 0;
				while( N > idx) 
				{
					if(temp == box.size()) break;  
					else if(box.get(temp)<= crane.get(idx)) { // 크레인으로 박스를 옮길 수 있을 때
						box.remove(temp);
						idx++;
					}
					else if(box.get(temp) > crane.get(idx)) temp++; // 크레인으로 박스을 못 옮길 때
				}
				rst++;
			}
		}
		sb.append(rst);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

}
