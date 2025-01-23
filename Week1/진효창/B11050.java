package 진효창;
// B11050.java
// 문제 11050: 이항 계수 1 - 주어진 N과 K로 이항 계수 계산.
import java.util.Scanner;

public class B11050 {
	public static void main(String[] args) {
		// 문제 11050 해결을 위한 코드를 작성하세요.

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
//n k -> n!/((n-k)!*k)!
		int ans = fac(n) / (fac(n - k) * fac(k));
		System.out.println(ans);

	}

	public static int fac(int a) {
		int b = 1;//기본값
		for (int i = 1; i <= a; i++) {
			b *= i;//a까지 반복해서 곱
		}
		return b;
	}

}
