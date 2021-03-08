package com.baekjoon.p2661;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;




// 1
// 12
// 121
// 1213
// 12131
// 뒤에 붙여나갈때 앞에 같은 수열이 있는지 검사
public class Main {
	static int N;
	static String rst;
	static boolean gcheck = false;

	public static void main(String[] args) throws NumberFormatException, IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		solve(N , 1, "");
		sb.append(rst);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
	
	static void solve(int leng, int num, String s)
	{
		if(gcheck) return;
		if(num - 1 == leng)
		{
			gcheck = true;
			rst = s;
			return;
		}
		
		for(int i = 1; i < 4; i++) // 1, 2, 3
		{
			String next = s + i; // 원래 문자열에 i값 붙이기
			int tmp = num / 2; // 나쁜 수열은 반복되기 때문에 절반탐색 ( 121, 1212)
			boolean check = false;
			for(int j = 1; j <= tmp; j++)
			{
				String a = next.substring(num-j, num); // 
				String b = next.substring(num - j - j, num - j);
				if(a.equals(b))
				{
					check = true; // 같은 문자열이 나오면 임시로 넣은 숫자 사용 불가능 함
					break;
				}
			}
			if(check) continue; // 다음숫자 넣고 재진행
			else solve(leng, num + 1, next); // 같은 문자열이 발견되지 않았으므로 확정
		}
	}

}
