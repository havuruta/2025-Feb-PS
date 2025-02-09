package problem;
// B1546.java
// 문제 1546: 평균 - 점수를 조작하여 새로운 평균 계산.

import java.util.Scanner;

public class B1546 {
    public static void main(String[] args) {
        // 문제 1546 해결을 위한 코드를 작성하세요.
        
        Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 점수를 저장할 배열 선언
		double[] scores = new double[N];

		// 최댓값 찾기
		double maxScore = 0;
		for (int i = 0; i < N; i++) {
			// 점수를 하나씩 입력
			scores[i] = sc.nextInt();

			// 순회하며 최댓값 갱신
			if (scores[i] > maxScore) {
				maxScore = scores[i];
			}
		}

		// 새로운 점수의 합
		double sum = 0;

		for (int i = 0; i < N; i++) {
			scores[i] = (scores[i] / maxScore) * 100;
			sum += scores[i];
		}

		// 새로운 평균
		double newAvg = sum / N;

		System.out.println(newAvg);
	}
}
