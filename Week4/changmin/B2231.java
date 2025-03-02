package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/*
 * B2231 분해합
 * 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 
 * 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 */
public class B2231 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine()); // 숫자
		
		int num = 1;
		while(num < N) { //생성자는 N보다 작음
			int tmpNum = num; // N
			int sum = 0; // 각 자리숫자 합
			while(tmpNum > 0) { //각 자리 계산
				sum += tmpNum % 10;
				tmpNum /= 10;
			}
			
			if(N == sum + num) { // (수 + 자리의 합) 이 N과 같으면 생성자임
				bw.write(num +"");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
			num++; //아닐경우 +1
		}
		
		bw.write(0+"");
		bw.flush();
		bw.close();
		br.close();
	}
}

