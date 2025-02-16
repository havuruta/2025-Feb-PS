package 이창열;

import java.util.Scanner;

// 문자열 분석
public class B10820 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		

		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			
			int lower = 0;
			int upper = 0;
			int digit = 0;
			int space = 0;
			
			for(int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				
				// 소문자
				if(Character.isLowerCase(c)) {
					lower++;
				}
				
				// 대문자
				else if(Character.isUpperCase(c)) {
					upper++;
				}

				// 숫자
				else if(Character.isDigit(c)) {
					digit++;
				}
				
				// 공백
				else if(Character.isSpaceChar(c)) {
					space++;
				}
			}
			
			System.out.println(lower + " " + upper + " " + digit + " " + space);
		}
	}
}
