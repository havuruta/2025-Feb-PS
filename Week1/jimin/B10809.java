// 백준 10809 알파벳 찾기 (브론즈2)
package jimin;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B10809 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String alphabet = "abcdefghijklmnopqrstuvwxyz";

		// 단어 S 입력받기 (소문자로만 이루어짐, 단어의 길이는 100을 넘지 않음)
		String S = br.readLine();

		// 단어 포함 여부
		boolean a;
		// length() : 총 문자의 수를 리턴
		for (int i = 0; i < alphabet.length(); i++) {
			// 초기화
			a = true;

			for (int j = 0; j < S.length(); j++) {
				// charAt(int index) : 특정 위치의 문자를 리턴
				if (alphabet.charAt(i) == S.charAt(j)) {
					System.out.print(j + " ");
					a = false;
					break;
				}
			}
			// 만약 단어가 포함되어 있지 않다면,
			if (a) {
				System.out.print(-1 + " ");
			}
		}
		// indexOf(String str) : 문자열 내에서 주어진 문자열의 위치를 리턴
	}
}
