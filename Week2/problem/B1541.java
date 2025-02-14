package problem;

/*
 문제 : 1541(잃어버린 괄호)
 시간 : 168ms
 풀이 : 문자열을 순회하며 숫자를 변환하고, 다음 문자가 부호일 경우 계산을 수행.
 - 문자 이후 변환되는 모든 수를 감산함으로써 식의 최소값을 도출.
 */

import java.util.Scanner;

public class B1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int ans = 0;
		int val = 0;
		boolean isMinus = false;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if (c != '+' && c != '-') { // 숫자 변환
				val += c - '0'; // 각 자릿수 가산
				
				// 다음 문자가 부호이거나 마지막 숫자인 경우 계산
				if(i == str.length()-1 || str.charAt(i+1) == '+' || str.charAt(i+1) == '-') {
					ans = isMinus ? ans - val : ans + val; // 이미 -가 등장했으면 계속해서 감산
					val = 0; // 숫자 변환 초기화
				}
				else val *= 10; // 자릿수 증가
			}
			// - 등장 시 이후 숫자를 모두 감산
			else if (c == '-') isMinus = true;
		}
				
		System.out.println(ans);
    }
}
