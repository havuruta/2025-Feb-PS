// 문제 : 백준 10824 네 수 (브론즈3)
// 해석 : 네 자연수 A,B,C,D 중 A,B 붙인 수와 C,D 붙인 수의 합을 구하는 프로그램
// 링크 : https://www.acmicpc.net/problem/10824

package jimin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10824 {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 1 <= A, B, C, D <= 1,000,000  숫자의 범위가 큼 -> long으로 선언 !
		long AB = Long.parseLong(st.nextToken() + st.nextToken());
		long CD = Long.parseLong(st.nextToken() + st.nextToken());
		bw.write(String.valueOf(AB + CD)); 
				
		br.close();
		bw.flush();
		bw.close();
    }
}
