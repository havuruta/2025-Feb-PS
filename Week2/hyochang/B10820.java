package hyochang;

import java.util.Scanner;

public class B10820 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {// 입력 받은 문자열이 있으면 실행
			String str = sc.nextLine();

			int small = 0;//소문자
			int large = 0;//대문자
			int number = 0;//숫자
			int space = 0;//공백

			for (char c : str.toCharArray()) {
				if (Character.isDigit(c)) {//숫자
					number++;
				} else if (Character.isAlphabetic(c)) {//문자
					if (Character.isLowerCase(c)) {//소문자
						small++;
					} else if (Character.isUpperCase(c)) {//대문자
						large++;
					}
				} else if (c == ' ') {//공백
					space++;
				}
			}
			System.out.println(small + " " + large + " " + number + " " + space);
		}
	}
}