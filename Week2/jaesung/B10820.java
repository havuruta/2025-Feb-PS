package jaesung;

/*
 문제 : 10820(문자열 분석)
 시간 : 244ms
 풀이 : 각 줄 전체를 하나의 문자열로 입력받은 뒤, 해당 문자열을 순회하며 각 요소를 카운팅
 소문자, 대문자, 숫자를 구분하기 위해 조건문에 아스키코드 숫자를 적을 필요 없이 'a', 'z'를 사용해도 문제 없음
 더이상 입력받을 문자열이 없는지를 파악하는 sc.hasNext 메서드를 활용해야 스캐너 사용 시 런타임에러를 방지 할 수 있음
 */

import java.io.IOException;

import java.util.Scanner;

public class B10820 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) { // 더 이상 입력받을 것이 없을 때까지 루프. 입력된 문자열이 없는 경우(eof) 루프 종료.
			String str = sc.nextLine();
						
			// 순서대로 소문자, 대문자, 숫자, 공백
			int lower = 0;
			int upper = 0;
			int digit = 0;
			int blank = 0;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				if (c >= 'a' && c <= 'z') ++lower; // 소문자
				else if (c >= 'A' && c <= 'Z') ++upper; // 대문자
				else if (c >= '0' && c <= '9') ++digit; // 숫자
				else ++blank; // 공백
			}
			
			System.out.printf("%d %d %d %d\n", lower, upper, digit, blank);
		}
	}
}
