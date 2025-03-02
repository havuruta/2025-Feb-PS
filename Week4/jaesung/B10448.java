package Week4.problem;

/*
 문제 : 10448(유레카 이론)
 시간 : 296ms
 풀이 : 삼중 for문을 순회하며 세 인덱스 i, j, k에 해당되는 삼각수를 더해 3개의 삼각수로 표현되는지 판별
 */

import java.util.Scanner;

public class B10448 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 삼각수를 미리 구해 저장
		int[] T = new int[51];
		for (int i = 1; i <= 50; i++) {
			T[i] = i * (i+1) / 2;
		}
		
		int K = sc.nextInt();
		
		// 3중 for문을 순회하며 삼각수 판별
		for (int testCase = 0; testCase < K; testCase++) {
			int N = sc.nextInt();
			
			boolean isFound = false;
			
			find:
			for (int i = 1; i < T.length; i++) {
				for (int j = 1; j < T.length; j++) {
					for (int k = 1; k < T.length; k++) {
						int val3 = T[i] + T[j] + T[k];
						
						// 3개의 삼각수로 판별되는 경우 for문 종료
						if (val3 == N) {
							isFound = true;
							break find;
						}
					}
				}
			}
			
			System.out.println(isFound ? 1 : 0);
		}
	}
}
