package jaesung;

/*
 문제 : 1546(평균)
 시간 : 208ms
 풀이 : 점수 배열 입력과 함께 최댓값 M을 도출하고, 이를 사용하여 고친 값들에 대한 평균을 출력
 */

import java.util.Scanner;
public class B1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		// 입력 및 최댓값 M 도출
		double M = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			M = Math.max(M, arr[i]);
		}
		
		// 평균 계산
		double avg = 0;
		for (int i = 0; i < arr.length; i++) {
			avg += (arr[i] / M * 100);
		}
		
		System.out.println(avg / N);
	}
}