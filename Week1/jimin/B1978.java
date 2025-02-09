// 백준 1978 소수 찾기 (브론즈2)
package jimin;

import java.util.Scanner;

public class B1978 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 수의 개수 입력
		int N = sc.nextInt();
		// 소수의 개수 count
		int cnt = 0;
		
		for (int i=0; i<N; i++) {
			// 수 입력받기
			int a = sc.nextInt();
			// 소수인지 확인
			if(isPrime(a)) {
				cnt += 1;
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}
	// 소수 판별
	public static boolean isPrime(int num) {
		if (num < 2) {
			return false;
		} else {
			for (int i=2; i<num; i++) {
				if(num % i == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
