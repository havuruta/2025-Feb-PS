package youngjae;

import java.util.Scanner;

// B10809.java
// 문제 10809: 알파벳 찾기 - 각 알파벳의 첫 등장 위치를 출력.
public class B10809 {
    public static void main(String[] args) {
        // 문제 10809 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);

		String S = sc.nextLine();
		int[] arr = new int[26];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = -1;
		}
		for (int j = 0; j < S.length(); j++) {
			char a = S.charAt(j);
			int result = a - 'a';
			if (arr[result] == -1) { 
				arr[result] = j;
			}

		}
		// arr이 a~z까지의 순서임을 알게
		for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k] + " ");
		}
    }
}
