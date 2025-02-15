package problem;

import java.util.Scanner;

public class B2559 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 온도를 측정한 전체 날짜의 수
		int K = sc.nextInt(); // 합을 구하기 위한 연속적인 날짜의 수
		int max = Integer.MIN_VALUE; // 최대값 찾아야하므로
		
		// 슬라이딩 윈도우 > 1차원 배열 인덱싱 놀이
		// 몇일 동안의 온도의 합이 가장 큰 가
		
		int [] arr = new int [N];// 배열로 N 만큼 받는다.
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		// 출력 배열을 끝까지 훑는 느낌으로 풀면된다.
		// 근데 끝까지 훑는데 길이가 K만큼
		// 항상 훑을 때 기준점을 잡자!
		
		for (int i = 0; i <= N-K; i++) {
			int result = 0;
			for (int j = i; j < i+K; j++) {
					result += arr[j];
			}
			if (result > max) {
				max = result;
			}
		}
		System.out.println(max);
		
		
		
		// 고민 : 수의 합이 인덱스를 옮길 때마다 리셋되서 max랑 비교해야하는데 어떻게 구현하지? 

    }
}
