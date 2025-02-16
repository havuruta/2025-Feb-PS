package problem;

import java.io.IOException;
import java.util.Scanner;

public class B10820 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			int lower = 0;
			int upper = 0;
			int num = 0;
			int empty = 0;

			String input = sc.nextLine();

			for (int i = 0; i < input.length(); i++) {
				char c = input.charAt(i);
				// c가 소문자일때
				if (c >= 'a' && c <= 'z') {
					lower++;
				}
				// c가 대문자일때
				else if (c >= 'A' && c <= 'Z') {
					upper++;
				}
				// c가 숫자일때
				else if (c >= '0' && c <= '9') {
					num++;
				}
				// c가 공백일 때
				else {
					empty++;
				}
			}
			System.out.println(lower + " " + upper + " " + num + " " + empty);
		}
    }
}
