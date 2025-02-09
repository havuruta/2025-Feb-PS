package jaesung;

/*
 문제 : 10809(알파벳 찾기)
 시간 : 192ms
 풀이 : 알파벳 소문자 개수만큼의 배열에 입력 문자열 각 원소의 인덱스를 저장하고 이를 출력.
 문자열 각 문자에 해당하는 배열 인덱스는 (문자의 아스키코드 - 'a'의 아스키 코드)로 계산 가능.
 */

import java.util.Scanner;

public class B10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int[] alphabets = new int[26];
		
		String S = sc.next();
		
		for (int i = 0; i < S.length(); i++) {
			int idx = S.charAt(i) - 'a';
			
			if(alphabets[idx] == 0)
				alphabets[S.charAt(i) - 'a'] = i+1;
		}

		for (int i = 0; i < alphabets.length; i++)
			System.out.print(alphabets[i]-1 + " ");
	}
}