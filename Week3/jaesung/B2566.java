package Week3.jaesung;

/*
 문제 : 2566(최댓값)
 시간 : 196ms
 풀이 : 배열 입력과 동시에 최댓값 판별을 진행하여 값과 행, 열을 갱신.
 출력 시 행과 열에 1을 더하여 출력.
 */

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] arr = new int[9][9];
		
		// 최댓값, 행, 열
		int maxVal = 0;
		int row = 0;
		int col = 0;
		
		// 각 수 입력과 동시에 최댓값 판별 수행
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
				
				if (maxVal <= arr[i][j]) {
					maxVal = arr[i][j];
					row = i;
					col = j;
				}
			}
		}
		
		// 출력 시 행과 열에 1더하여 출력
		System.out.println(maxVal);
		System.out.println(++row + " " + ++col);
	}
}
