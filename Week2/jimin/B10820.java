// 문제 : 백준 10820 문자열 분석 (브론즈2)
// 해석 : 문자열에 포함되어 있는 소문자, 대문자, 숫자, 공백의 개수를 구하는 프로그램
// 링크 : https://www.acmicpc.net/problem/10820

package jimin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10820 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str;
		while(true) {
			str = br.readLine(); // 한줄씩 입력받기
			/*
			 왜 if문에 str == null 과 str.isEmpty()를 꼭 같이 써야 하는가?
			 str == null -> EOF(입력 종료) 체크
			 null인 상태에서 str.isEmpty()를 호출하면 런타임 에러(NullPointer) 발생
			 str.isEmpty() -> 빈 줄(공백만 있는 경우) 체크
			 isEmpty()를 체크하지 않으면 빈 줄이 입력되었을 때 무한 루프가 발생할 수 있음
			*/
			if(str == null || str.isEmpty()) break;
			
			int[] count = new int[4]; // 0: 소문자 1: 대문자 2:숫자 3: 공백
			for(char ch : str.toCharArray()) { // 한 문자씩
				if(ch >= 'a' && ch <= 'z') count[0]++; // 문자가 소문자일 때
				else if(ch >= 'A' && ch <= 'Z') count[1]++; // 대문자일 때
				else if(ch >= '0' && ch <= '9') count[2]++; // 숫자일 때
				else count[3]++; // 나머지 : 공백일 때
			}
			for(int i : count) {
				bw.write(i + " ");
			}
			bw.newLine();
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
