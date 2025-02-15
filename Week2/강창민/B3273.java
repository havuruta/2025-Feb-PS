package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3273 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//수열의 크기
		int N = Integer.parseInt(br.readLine());
		
		//자연수 배열
		int[] numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//자연수 배열 입력받기
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(numbers);
		
		//목표 숫자
		int target = Integer.parseInt(br.readLine());
		
		//투포인터
		int left = 0;
		int right = N-1;
		
		//횟수 
		int count = 0;
		
		while(left < right) {
			
			int sum = numbers[left] + numbers[right];
			
			if(sum == target) {
				count++;
				left++;
				right--;
			} else if (sum > target) {
				right--;
			} else if (sum < target) {
				left++;
			}
			
		}
		
		bw.write(String.valueOf(count));
		bw.flush();
		bw.close();
		br.close();
		
	}
}
