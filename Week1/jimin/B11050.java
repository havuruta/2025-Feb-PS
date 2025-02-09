// 백준 11050 이항 계수 1 (브론즈1)
package jimin;

import java.util.Scanner;

public class B11050 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		// 이항 계수 = n ! / (n - k)! * k !
		System.out.println(factorial(n) / (factorial(n-k) * factorial(k)));
		sc.close();
	}
	
	public static int factorial(int num)  {
		int count = 1;
		
		for (int i=1; i<=num; i++) {
			count *= i;
		}
		return count;
	}
}
