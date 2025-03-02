package Week4.problem;

/*
 문제 : 1977(완전제곱수)
 시간 : 172ms
 풀이 : 입력 범위를 순회하며 완전제곱수를 판별. 완전제곱수일 경우 가산, 최소값이 아직 없을 경우 갱신.
 */

import java.util.Scanner;

public class B1977 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0;
		int minVal = -1;
		
		// 완전제곱수 판별
		for (int i = M; i <= N; i++) {
			double root = Math.sqrt(i);
			
			// 소수점 아래 값이 존재하지 않으면 완전제곱수
			if (root % 1 == 0.0) {
				sum += i;
				
				// 최소값이 아직 없을 경우 갱신
				if (minVal == -1) {
					minVal = i;
				}
			}
		}
		
		if (sum == 0) {
			System.out.println(-1);
		}
		else {
			System.out.println(sum);
			System.out.println(minVal);
		}
	}
}
