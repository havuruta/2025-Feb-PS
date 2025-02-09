package jaesung;

/*
 문제 : 1920(수 탐색)
 시간 : 1864ms
 풀이 : 처음 입력되는 N개의 수의 배열에 대해 M개의 수 각각을 이분 탐색으로 탐색.
 이분 탐색을 위해 배열을 정렬하고 이분 탐색 알고리즘 수행.
 
 ※ 자바에서 제공하는 이분 탐색 메서드 Arrays.binarySearch(arr, value)를 사용할 수도 있음
 */

import java.util.Arrays;
import java.util.Scanner;
public class B1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] searchedArr = new int[N];
		
		for (int i = 0; i < searchedArr.length; i++)
			searchedArr[i] = sc.nextInt();
		
		int M = sc.nextInt();
		
		// 이분탐색을 위해 배열 정렬
		Arrays.sort(searchedArr);
		
		for (int i = 0; i < M; i++) {
			int target = sc.nextInt();
			
			// 이분 탐색
			int left = 0;
			int right = N-1;
			while (true) {
				int mid = left + (right - left) / 2;
				
				// 탐색 범위 축소
				if (target > searchedArr[mid]) {
					left = mid + 1;
				}
				else if (target < searchedArr[mid]) {
					right = mid - 1;
				}
				else { // 수가 존재함
					System.out.println(1);
					break;
				}
				
				if (left > right) { // 모든 수를 탐색해도 존재하지 않음
					System.out.println(0);
					break;
				}
			}
		}
	}
}