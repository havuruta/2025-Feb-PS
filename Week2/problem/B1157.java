package problem;

import java.io.IOException;
import java.util.Scanner;

public class B1157 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
		// 특징 1. 대문자와 소문자는 상관이 없다.
		// 특징 2. 가장많이 사용된 알파벳의 개수가 동일하면 ?를 출력
		// 대문자와 소문자는 32씩 차이난다. ex) A : 65, a : 97
		String input = sc.next();
		int[] word = new int[26]; // 단어의 개수를 저장할 배열
		int max = Integer.MIN_VALUE;
		int maxIdx = 0;

		// String에서 문자를 하나씩 빼올거야
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c >= 'a' && c <= 'z') {
				word[(c - 'a')]++;
			} else if (c >= 'A' && c <= 'Z') {
				word[(c - 'A')]++;
			}
		}
		// 배열을 순회하며 가장 많은 숫자가 들어있는 인덱스를 출력
		for (int i = 0; i < word.length; i++) {
			if (max < word[i]) {
				max = word[i];
				maxIdx = i;
			}
		}
		
		// max의 빈도수가 동일하면 ?를 출력 아니면 문자를 출력
		boolean isOk = true;
		int count = 0;
		for (int i = 0; i < word.length; i++) {
			if (max == word[i]) {
				count++;
			}
		}
		if (count >= 2) {
			System.out.println("?");
		} else  {
			System.out.println((char) (maxIdx + 'A'));
		}
    }
}