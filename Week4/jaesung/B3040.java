package Week4.problem;

/*
 문제 : 3040(백설 공주와 일곱 난쟁이)
 시간 : 172ms
 풀이 : 배열 입력 과정에서 전체 합을 구하고, 이중 for문에서 서로 다른 인덱스의 키를 뺀 값이 100인 경우에 해당되는 두 인덱스를 도출.
 해당 가짜 인덱스를 제외하고 출력. 
 */

import java.util.Scanner;

public class B3040 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[9];
		
		// 입력과 동시에 전체 합을 계산
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			
			sum += arr[i];
		}
		
		// 두 가짜 인덱스를 도출
		int fake1 = 0;
		int fake2 = 0;
		
		find:
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					continue;
				}
				
				// 전체 합에서 두 후보를 뺀 값을 통해 판별
				if (sum - arr[i] - arr[j] == 100) {
					// 가짜 인덱스 저장
					fake1 = i;
					fake2 = j;
					
					// 전체 루프 탈출
					break find;
				}
			}
		}
		
		// 가짜 인덱스 제외 출력
		for (int i = 0; i < arr.length; i++) {
			if (i == fake1 || i == fake2) {
				continue;
			}
			
			System.out.println(arr[i]);
		}
	}
}
