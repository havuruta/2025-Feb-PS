package jaesung;

/*
 문제 : 1259(펠린드롬수)
 시간 : 164ms
 풀이 : 입력 문자열의 중앙으로부터 양쪽으로 인덱스를 증감시키며 두 문자의 동일 여부를 판단하여 펠린드롬수 판별
 */

import java.io.IOException;

import java.util.Scanner;

public class B1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			String str = sc.next();
			
			if(str.equals("0")) break;
			
			// 길이가 1인 경우는 무조건 팰린드롬
			if (str.length() == 1) {
				System.out.println("yes");
				continue;
			}
			
			// 문자열의 팰린드롬 판단 시작 인덱스 지정
			int left = 0;
			int right = 0;
			int mid = str.length() / 2;
			if (str.length() % 2 == 1) { // 문자열 길이가 홀수인 경우 중앙 인덱스 기점 양 옆 인덱스
				left = mid - 1;
				right = mid + 1;
			}
			else { // 문자열 길이가 짝수인 경우 중앙의 두 인덱스
				left = mid - 1;
				right = mid;
			}
			
			while (true) { // 두 인덱스를 바깥쪽으로 증감시키며 동일 여부 판단
				if (str.charAt(left--) != str.charAt(right++)) { // 다를 경우
					System.out.println("no");
					break;
				}
				
				if (left < 0) { // 모두 탐색하였음에도 동일한 경우
					System.out.println("yes");
					break;
				}
			}
		}
	}
}

