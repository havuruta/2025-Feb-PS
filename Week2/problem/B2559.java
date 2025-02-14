package problem;

/*
 문제 : 2559(수열)
 시간 : 680ms
 풀이 : 배열을 순회하며 연속 일수 온도 합을 계산하고, 그 중 최댓값을 도출.
 연속 일수 온도 합은 슬라이딩 윈도우를 활용.입력 시 첫 연속 일수 온도 합을 구한 다음
 배열을 순회하며 이전 연속 일수 온도 합에서 가장 오래된 온도를 빼고 새로운 최근 온도를 더해 계산.
 
 ※ 슬라이딩 윈도우를 활용하지 않고, 배열의 매 순회마다 구간합을 구하는 식으로 문제를 해결할 시
 기존 풀이보다 2배 이상의 시간이 걸리므로 비효율적(680ms vs 1452ms)
 */

import java.util.Scanner;

public class B2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			
			if(i < K) sum += arr[i]; // 처음 연속 일수 온도 합 구하기
		}
		
		int ans = sum;
		
		// 최대 연속 일수 온도 합 구하기
		for (int i = K-1; i < arr.length-1; i++) { // 배열을 순회하며 연속 일수 온도 합 계산.
			// 슬라이딩 윈도우
			// 한 칸씩 이동하며 가장 왼쪽 한 칸의 온도를 빼고, 가장 오른쪽 한 칸의 온도를 더해 계산.
			sum += arr[i+1] - arr[i-K+1];
			
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
    }
}
