// 문제 : 백준 1259 팰린드롬수 (브론즈1)
// 해석 : 팰린드롬수면 'yes', 아니면 'no'를 출력하는 프로그램
// 링크 : https://www.acmicpc.net/problem/1212

package jimin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1259 {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String T;
		while(true) {
			T = br.readLine();
			if(T.equals("0")) break; // T -> String(참조자료형) ! 비교할 때 equals 사용
			boolean isPalindrome = true;
			for(int i=0; i<T.length()/2; i++) {
				if(T.charAt(i) != T.charAt(T.length()-1-i)) {
					isPalindrome = false;
					break;
				}
			}
			bw.write(isPalindrome ? "yes" : "no");
			bw.newLine();
		}
		br.close();
		bw.flush();
		bw.close();
    }
}
