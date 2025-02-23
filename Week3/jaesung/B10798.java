package Week3.jaesung;

/*
 문제 : 10798(세로 읽기)
 시간 : 168ms
 풀이 : 2차원 배열에 입력을 저장하고, 각 열에 대해 행을 순회하며 세로읽기 수행.
 모든 열을 순회할 수 있도록 입력 시 가장 긴 열의 길이를 저장하여 반복문에서 사용.
 현재 열 인덱스에 접근할 수 없는 경우(= 열 인덱스가 현재 행 배열의 크기보다 크거가 같음) 접근하지 않고 이외 원소 출력.
 */

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[][] arr = new char[5][];
		
		// 배열 입력과 동시에 가장 긴 열의 길이 저장
		int maxCol = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next().toCharArray();
			
			maxCol = Math.max(maxCol, arr[i].length);
		}
		
		// 배열 세로방향 출력
		for (int i = 0; i < maxCol; i++) { // 가장 긴 열까지 순회
			for (int j = 0; j < arr.length; j++) { // 모든 행 순회
				if (i >= arr[j].length) { // 현재 행 배열이 해당 열을 인덱스로 가질 수 없는 경우 패스
					continue;
				}
				
				System.out.print(arr[j][i]);
			}
		}
	}
}
