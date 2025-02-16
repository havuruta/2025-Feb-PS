package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2559 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] days = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			days[i] = Integer.parseInt(st.nextToken());
		}
		
		//투포인터, 최대 온도의 합
		int left = 0;
		int right = K-1;
		int maxSum = Integer.MIN_VALUE;
		
		//오른쪽 포인터가 마지막날까지 갈때까지만
		while(right < N) {
			//온도의 합
			int sum = 0;
			
			//포인터의 왼쪽부터 오른쪽까지 더하기
			for(int i = left; i <= right; i++) {
				sum += days[i];
			}
			
			//최대합과 비교
			if(sum > maxSum) {
				maxSum = sum;
			}
			
			//포인터 둘다 이동
			left++;
			right++;
		}
		
		bw.write(String.valueOf(maxSum));
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
		
	}
}
