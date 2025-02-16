package jaesung;

/*
 문제 : 1157(단어 공부)
 시간 : 412ms
 풀이 : 입력받은 단어의 대문자를 소문자로 변환한 후, 단어 문자열을 순회하며 알파벳 소문자를 카운팅하여 가장 많이 사용된 알파벳 도출.
 이후 가장 많이 사용된 알파벳의 중복 여부를 판별하고 이에 따른 결과 출력.
 */

import java.util.Scanner;

public class B1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		// 모든 알파벳을 입력과 동시에 소문자로 변환
		String str = sc.next().toLowerCase();
		
		// 알파벳 카운팅 배열
		int[] arr = new int['z'-'a'+1];
		
		int maxCount = 0;
		for (int i = 0; i < str.length(); i++) {
			int idx = str.charAt(i) - 'a';
			++arr[idx];
			
			maxCount = Math.max(maxCount, arr[idx]); // 가장 많이 사용된 알파벳의 개수 파악
		}
		
		int count = 0;
		int ansIdx = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == maxCount) { // 가장 많이 사용된 알파벳의 중복 여부 파악
				++count;
				ansIdx = i; // 중복되지 않을 경우 출력을 위해 인덱스 저장
			}
		}
		
		if (count > 1) System.out.println("?");
		else System.out.println((char)(ansIdx + 'A'));
	}
}
