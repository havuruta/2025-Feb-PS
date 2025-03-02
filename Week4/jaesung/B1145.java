package Week4.problem;

/*
 문제 : 1145(적어도 대부분의 배수)
 시간 : 200ms
 풀이 : 입력 배열에서 가장 작은 값을 1씩 증가시키며 적어도 대부분의 배수인지 판별
 */

import java.util.Scanner;

public class B1145 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		// 가장 작은 값을 1씩 증가시키며 적어도 대부분의 배수 도출
		int val = arr[0];
		while (true) {
			int count = 0;

			for (int j = 0; j < arr.length; j++) {
				// 배수 확인
				if (val % arr[j] == 0) {
					++count;
				}
			}

			// 최소값 출력
			if (count >= 3) {
				System.out.println(val);
				return;	
			}
			
			++val;
		}
	}
}