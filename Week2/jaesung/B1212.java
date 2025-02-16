package jaesung;

/*
 문제 : 1212(8진수 2진수)
 시간 : 432ms
 풀이 : 8진수를 문자열로 입력 받은 후, 가장 낮은 자리수부터 2진수로 변환.
 8 = 2^3 이므로, 8진수의 한 자리는 2진수의 세자리에 해당됨을 활용.
 한 자리마다 2로 나눈 나머지를 도출하는 과정을 세번씩 수행하여 변환.
 올바른 출력을 위해 stack을 사용하여 도출되는 수열을 반전.
 
 스캐너 및 string출력 사용 시 시간초과가 발생하여 빠른 입출력 사용.
 
 ※ String builder 의 isEmpty 메서드는 java11에서 사용 불가.
 백준에서 제출할 언어를 java15로 바꾸거나 java11에서는 sb.length() == 0을 사용.
 */

import java.util.Stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String oct = br.readLine();
		
		// 변환된 2진수 각 자리수를 담을 스택
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < oct.length(); i++) {
			// 나누기를 위해 자릿수 문자를 숫자로 변환
			int val = oct.charAt(i) - '0';
			
			// 2진수 변환을 위해 2로 나누는 과정을 3회 수행(8진수 한 자리는 2진수 세 자리를 차지하기 때문)
			int count = 3;
			while (count-- != 0) { // 3회 수행하여 자릿수가 0인 경우도 저장
				stack.push(val % 2);
				val /= 2;
			}
			
			while (!stack.empty()) { // 출력을 위해 string builder에 저장
				if (sb.length() == 0 && stack.peek() == 0) // 가장 앞자리가 0인 경우 출력하지 않음 
					stack.pop();
				else 
					sb.append(stack.pop());
			}
		}
		
		if (sb.length() == 0) System.out.println("0");
		else System.out.println(sb);
	}
}

