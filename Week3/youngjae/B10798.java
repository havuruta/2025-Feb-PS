package Week3.problem;

import java.util.Scanner;

import java.io.IOException;

public class B10798 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

		// 입력을 받아야한다.
		// String으로 받고 하나하나씩 배열에 넣는다.
		char[][] c = new char[5][15];
		for (int i = 0; i < 5; i++) {
			String tmp = sc.nextLine();
			for (int j = 0; j < tmp.length(); j++) {
				c[i][j] = tmp.charAt(j);
			}
		} // 문자열에 입력을 통해 저장

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (c[j][i] == '\0') {
					continue;
				} else {
					System.out.print(c[j][i]);
				}

			}
		}
		// i와 j의 의미는?
    }
}
