package Week4.Youngjae;

import java.io.IOException;
import java.util.Scanner;

public class B2231 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 숫자로 받아옴
		String str = String.valueOf(N); // 숫자를 문자열로 전환
		int result = 0;
		int count = 0;

		for (int rotate = 0; rotate < N; rotate++) {
			int sum = rotate;
			int num = rotate;
			while (num > 0) {
				sum += num % 10;
				num /= 10;
			}
			if (sum == N) {
				result = rotate;
				count++;

				break;
			}
		}

		if (count > 0) {
			System.out.println(result);
		} else {
			System.out.println(0);
		}
	}
}
