package problem;
// B1978.java
// 문제 1978: 소수 찾기 - 주어진 숫자 중 소수의 개수를 계산.

import java.util.Scanner;

public class B1978 {
    public static void main(String[] args) {
        // 문제 1978 해결을 위한 코드를 작성하세요.

        Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 소수 개수
		int cnt = 0;

		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			boolean isPrime = true;

			// 소수 판별
			if (num == 1) {
				isPrime = false;
			} else {
				for (int j = 2; j * j <= num; j++) {
					if (num % j == 0) {
						isPrime = false;
						break;
					}
				}
			}
			
			// 소수 개수 카운팅
			if (isPrime) {
				cnt++;
			}
		}
		System.out.println(cnt);
    }
}
