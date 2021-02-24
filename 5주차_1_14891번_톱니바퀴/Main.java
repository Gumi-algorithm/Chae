package com.baekjoon.p14891;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	
	
	// 회전 시킬 바퀴와 방향으로
	// 주위에 맞닿은 톱니를 확인하여 회전 할지 안할지 정한다.
	// 톱니마다 결정된 방향으로 회전 한다.
	// 0인덱스의 톱니 극을 확인하여 점수를 구한다.
	static int[][] arr;
	static int K;
	static int rst;
	static int[] Check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String[] s;
		arr = new int[5][8];
		Check = new int[5];
		// 1 ~ 4 개 톱니바퀴
		// 0 ~ 7 개 극

		//입력
		for (int i = 1; i <= 4; i++) {
			s = br.readLine().split(""); // 하나씩 분리
			for (int j = 0; j < 8; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		K = Integer.parseInt(br.readLine()); // 회전 횟수

		// 회전 시킬 획수
		for (int i = 0; i < K; i++) {
			s = br.readLine().split(" ");
			int num = Integer.parseInt(s[0]);        // 회전시킬 바퀴 번호
			int direction = Integer.parseInt(s[1]);  // 방향 
			// 1:시계 방향
			// -1:반시계 방향

			Arrays.fill(Check, 0); // 초기화
			Check[num] = direction;
			right(num + 1, -1 * direction); // 오른쪽 회전 체크
			left(num - 1, -1 * direction ); // 왼쪽 회전 체크
			rotate();
		}

		solve();
		sb.append(rst);
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	private static void solve() {
		int cnt = 1;

		for (int i = 1; i <= 4; i++) {
			if (arr[i][0] == 1) {
				rst += cnt;    
			}    
			cnt *= 2; // 1, 2, 4, 8
		}
	}

	// 오른쪽 방향  체크
	private static void right(int num, int direction) {
		if (num == 5) { // 범위를 이탈하면
			return;
		}

		if (arr[num - 1][2] != arr[num][6]) { // 서로 만나는 부분 다르면 회전
			Check[num] = direction;
			right(num + 1, -1 * direction);
		}
	}

	// 왼쪽 방향 체크
	private static void left(int num, int direction) {
		if (num == 0) { // 범위를 이탈하면
			return;
		}

		if (arr[num][2] != arr[num + 1][6]) { // 서로 만나는 부분 다르면 회전
			Check[num] = direction;
			left(num - 1, -1 * direction);
		}
	}

	private static void rotate() {
		for (int i = 1; i <= 4; i++) { 
			if (Check[i] == -1) { // 반시계 방향으로 회전 할 때
				int first = arr[i][0];
				for (int j = 1; j < 8; j++) { // 한칸씩 바꾸기
					arr[i][j - 1] = arr[i][j];
				}
				arr[i][7] = first;
			} 
			else if (Check[i] == 1) { // 시계 방향으로 회전 할 때
				int last = arr[i][7];
				for (int j = 6; j >= 0; j--) { // 한칸씩 바꾸기
					arr[i][j + 1] = arr[i][j];
				}
				arr[i][0] = last;
			}
		}
	}
	
}
