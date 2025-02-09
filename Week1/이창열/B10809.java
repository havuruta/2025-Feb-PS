package problem;
// B10809.java
// 문제 10809: 알파벳 찾기 - 각 알파벳의 첫 등장 위치를 출력.

import java.util.Scanner;

public class B10809 {
    public static void main(String[] args) {
        // 문제 10809 해결을 위한 코드를 작성하세요.

        Scanner sc = new Scanner(System.in);

		// 단어 S 입력
		String S = sc.next();

		// 처음 등장하는 위치를 나타내는 배열 선언
		int[] pos = new int[26];
		
		// 배열 -1로 초기화
		for (int i = 0; i < 26; i++) {
			pos[i] = -1;
		}

		// 알파벳 첫 등장 위치 저장
		for (int i = 0; i < S.length(); i++) {
			// 현재 문자
			char alphabet = S.charAt(i);
			// 알파벳을 a를 기준으로 0부터 25까지 인덱스로 변환 
			int idx = alphabet - 'a';
			// 알파벳이 처음 등장하면 위치 저장
			if (pos[idx] == -1) {
				pos[idx] = i;
			}
		}

		// 결과 출력
		for (int i = 0; i < 26; i++) {
			System.out.print(pos[i] + " ");
            
		}
    }
}
