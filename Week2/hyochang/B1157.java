package hyochang;

import java.io.IOException;
import java.util.Scanner;

public class B1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine().toUpperCase();//대문자로 변환


		int[] arr = new int[26];//알파벳 갯수 확인할 배열
		for (char ch : str.toCharArray()) {
			if (ch >= 'A' && ch <= 'Z') {
				arr[ch - 'A']++;
			}
		}

		int max = 0;
        int idx = -1;//A->0이므로
		boolean check = true;//여러개의 동일한 출현 횟수의 알파벳
		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {//최댓값 및 해당 인덱스 갱신
				max = arr[i];
				idx = i;
				check = true;
			} else if (arr[i] == max) {//만약에 많이 출현한 수가 2개이상
				check = false;
			}
		}
		if (check)
			System.out.println((char) (idx + 'A'));//다시 int로 변환+'A'만큼
		else
			System.out.println("?");
	}
}
