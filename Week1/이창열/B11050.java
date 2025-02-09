package problem;
// B11050.java
// 문제 11050: 이항 계수 1 - 주어진 N과 K로 이항 계수 계산.

import java.util.Scanner;

public class B11050 {
    public static void main(String[] args) {
        // 문제 11050 해결을 위한 코드를 작성하세요.

        Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		// N!
		int n = 1;
		// (N-k)!
		int nk = 1;
		// K!
		int k = 1;

		// N! 계산
		for (int i = 1; i <= N; i++) {
			n *= i;
		}

		// (N-K)!
		for (int i = 1; i <= N - K; i++) {
			nk *= i;
		}

		// K!
		for (int i = 1; i <= K; i++) {
			k *= i;
		}

		// 결과
		int res = n / (nk * k);

		System.out.println(res);
    }
}
