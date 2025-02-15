// 문제 : 백준 1212 8진수 2진수 (브론즈2)
// 해석 : 8진수가 주어졌을 때, 2진수로 변환하는 프로그램
// 링크 : https://www.acmicpc.net/problem/1212

package jimin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1212 {
    public static void main(String[] args) throws IOException{
    // 가능하면 500ms 이내로 풀어봅시다. -> 424ms ! !
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		// 8진수 <= 333,334
		String octal = br.readLine();
		
		for (int i = 0; i < octal.length(); i++) {
			String binary = Integer.toBinaryString(octal.charAt(i) - '0'); // 2진수 변환
			if(binary.length() == 2 && i != 0) { 
				sb.append("0" + binary);
			} else if(binary.length() == 1 && i != 0) {
				sb.append("00" + binary);
			} else {
				sb.append(binary);
			}
		}
		bw.write(sb.toString());
		
		br.close();
		bw.flush();
		bw.close();
    }
}

