package problem;

/*
 문제 : 2609(최대공약수와 최소공배수)
 시간 : 184ms
 풀이 : 유클리드 호제법으로 최대공약수 계산 후, 두 수의 곱을 최대공약수로 나눠 최소공배수 계산
 */

import java.util.Scanner;
public class B2609 {
    Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b= sc.nextInt();
		
		// 최소공배수 계산을 위해 미리 두 수의 곱 계산
		int val = a * b;
		
		// 유클리드 호제법은 a, b에 대해 a가 b보다 크거나 같은 경우에 성립
		if (a < b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		// 유클리드 호제법으로 최대공약수 계산
		while(b != 0) {
			int tmp = b;
			b = a % b;
			a = tmp;
		}
		
		System.out.println(a);
		System.out.println(val / a); //두 수의 곱을 최대공약수로 나눠 최소공배수 계산
	}
}

