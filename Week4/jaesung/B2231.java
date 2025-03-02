package Week4.problem;

/*
 문제 : 2231(분해합)
 시간 : 196ms
 풀이 : 입력 범위를 순회하여 분해합을 구하고, 생성자를 제일 먼저 확인한경우 출력하고 종료를 수행.
 순회가 끝난 후에도 생성자가 없다면 0 출력.
 */

import java.util.Scanner;

public class B2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for (int i = 1; i <= 1000000; i++) {
			int M = 0;
			int val = i;
			
			// 분해합 계산
			while (val != 0) {
				M += val % 10;
				val /= 10;
			}
			
			M += i;
			
			// 생성자 판별
			if (M == N) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
	}
}
