package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B10819 {
	
	static int[] numbers;
	static boolean[] used;
	static int N;
	static int maxSum = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		used = new boolean[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		bt(0, new ArrayList<>());
		
		bw.write(maxSum+"");
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static void bt(int length, List<Integer>seq){
		//6개 모두 자리를 찾앗을 경우
		if(length == N) {
			int sum = 0;
			//빼고 절대값 더하기
			for(int i = 0; i < N-1; i++) {
				sum += Math.abs(seq.get(i) - seq.get(i+1));
			}
			maxSum = Math.max(maxSum, sum);
		}
		
		for(int i = 0; i < N; i++) {
			if(!used[i]) {
				seq.add(numbers[i]);
				used[i] = true;
				bt(length+1, seq);
				seq.remove(seq.size()-1);
				used[i] = false;
			}
		}
	}
}
