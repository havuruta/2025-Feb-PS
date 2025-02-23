package Week3.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B2566 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[][] arr = new int [9][];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		int r = 0;
		int c = 0;
		
		int max = -1;
		
		// 그냥 완탐 돌면서 최댓값 찾으면 행, 열, 최댓값 변수를 갱신
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] > max) {
					r = j + 1;
					c = i + 1;
					max = arr[i][j];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(max).append("\n").append(c).append(" ").append(r);
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
}
