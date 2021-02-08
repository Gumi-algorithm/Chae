package blackjack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr;
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int	rst = 0;
		st =  new StringTokenizer(br.readLine());
		
		
		for(int i = 0; i < N; i++) 
		{
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < N - 2; i++) // 중복 제거를 위해 -2
		{
			for(int j = i + 1; j < N - 1; j++) // 중복 제거를 위해 -1
			{
				for(int k = j + 1; k < N; k++)
				{
					if( rst < arr[i] + arr[j] + arr[k] && arr[i] + arr[j] + arr[k] <= M) { // 뽑은 3개의 숫자의 합이 가장 크고, M보다 작거나 같을때
						rst = arr[i] + arr[j] + arr[k];
					}
					
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
