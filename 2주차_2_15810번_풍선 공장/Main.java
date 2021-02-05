package factory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int minute = 0;
		int sum = 0;
		
		int[] arr = new int[N];
		s = br.readLine();
		st =  new StringTokenizer(s);
		for(int i = 0; i < N; i++)
		{
			arr[i] = Integer.parseInt(st.nextToken());
			if(minute < arr[i]) minute = arr[i];
		}
		for(int i = 0; i < N; i++)
		{
			sum += minute / arr[i];
		}

		while(true)
		{
			if(sum > M) {
				sum = 0;
				minute = 0;
				while(true)
				{
					if(sum==M) break;
					for(int i = 0; i < N; i++)
					{
						if( minute % arr[i]   == 0) sum += 1;
					}
					minute++;
				}
			}
			else if(sum == M) break;
			minute++;		
			for(int i = 0; i < N; i++)
			{
				if( minute % arr[i]   == 0) sum += 1;
			}
		}
		sb.append(Integer.toString(minute));		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}
}
