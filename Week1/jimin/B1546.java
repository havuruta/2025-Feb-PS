// 백준 1546 평균 (브론즈1)

package jimin;

import java.util.Scanner;

public class B1546 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 시험 과목 개수
		int N = sc.nextInt();
		// 시험 과목만큼 점수를 저장할 배열 선언
		int[] nums = new int[N];
		
		// 최대값 저장할 변수 선언
		int max = Integer.MIN_VALUE;
		// 새로운 평균 구하기 위해 sum 변수 선언
		double sum = 0;
		
		// 시험 점수를 배열에 담기
		for(int i=0; i<N; i++) {
			nums[i] = sc.nextInt();

			// 만약 현재 과목 점수가 최대값보다 높은 경우
			if(max < nums[i]) {
				max = nums[i];
			}
		}

		// 점수 / 최대값 * 100 을 sum에 더하기
		for(int i=0; i<N; i++) {
			sum += (double) nums[i] / max * 100;
		}
		
		System.out.println(sum/N);
		sc.close();
	}
}
