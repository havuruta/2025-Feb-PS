// 백준 2609 최대공약수와 최소공배수 (브론즈1)
package jimin;

import java.util.Scanner;

public class B2609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		// 유클리드 호제법 공식 사용 !
		
		// 두 수의 최대공약수 계산
		int GCD = gcd(Math.max(num1, num2), Math.min(num1, num2));
		System.out.println(GCD);

		// 두 수의 최소공배수 계산
		int LCM = (num1 * num2)/gcd(Math.max(num1, num2), Math.min(num1, num2));
		System.out.println(LCM);
		
		sc.close();
	}
	
	public static int gcd(int num1, int num2) {
		// 만약 나머지 값이 0이면 나눈 수를 반환
		if(num2 == 0) return num1;
		// 0이 아니라면 
		return gcd(num2, num1 % num2);
	}
}
