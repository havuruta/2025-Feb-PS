package problem;
// B2609.java
// 문제 2609: 최대공약수와 최소공배수 - 두 자연수의 GCD와 LCM 계산.

import java.util.Scanner;

public class B2609 {
    public static void main(String[] args) {
        // 문제 2609 해결을 위한 코드를 작성하세요.

        Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int x = a;
		int y = b;

		// 최대공약수 찾기 -> 유클리드 호제법 활용
		while (y != 0) {
			int tmp = y;
			y = x % y;
			x = tmp;
		}

		// 최대공약수 저장
		int gcd = x;

		// 최소공배수 구하기 -> 두 수의 곱을 최대공약수롤 나누면 됨
		int lcm = (a * b) / gcd;

		// 결과 출력
		System.out.println(gcd);
		System.out.println(lcm);
    }
}
