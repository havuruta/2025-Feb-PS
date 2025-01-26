package gyumin;

import java.util.Scanner;

// B10809.java
// 문제 10809: 알파벳 찾기 - 각 알파벳의 첫 등장 위치를 출력.
public class B10809 {
	public static void main(String[] args) {
		// 문제 10809 해결을 위한 코드를 작성하세요.

		Scanner sc = new Scanner(System.in);

		// 입력받고 자르기
		String s = sc.next();
		char[] arr = s.toCharArray();

		// 횟수 카운팅 할 배열 선언 및 전 idx 값 -1로 초기화
		int[] result = new int[26];
		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}

		// 돌기
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == 'a' + i) {
					result[i] = j;
					break;
				}
			}
		}

		// 출력
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
