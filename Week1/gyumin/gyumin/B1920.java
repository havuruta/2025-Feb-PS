package gyumin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// B1920.java
// 문제 1920: 수 찾기 - 배열 내 특정 정수의 존재 여부 확인.
public class B1920 {
	public static void main(String[] args) throws IOException {
	/*
	 * 문제 풀이에 필요한 사전 지식
	 * 이분 탐색
	 * 전체 자료의 중앙값과 찾고자 하는 값을 비교
	 * 1) 찾고자 하는 값이 작을 때:
	 * 끝 점을 중앙값의 한 칸 앞으로 땡김
	 * 2) 찾고자 하는 값이 클 때:
	 * 시작점을 중앙값의 한 칸 뒤로 밈
	 * 
	 *  주의: 이분 탐색을 하기 위해선 반드시 전체 자료는 정렬된 상태여야 함
	 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		StringTokenizer st1 = new StringTokenizer(br.readLine());

		int[] arr = new int[n];
		int i = 0;

		while (st1.hasMoreTokens()) {
			arr[i++] = Integer.parseInt(st1.nextToken());
		}
		
		
		//이분 탐색을 활용하기 위한 정렬
		Arrays.sort(arr);

		int m = Integer.parseInt(br.readLine());

		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int[] target = new int[m];
		int j = 0;

		while (st2.hasMoreTokens()) {
			target[j++] = Integer.parseInt(st2.nextToken());
		}
		
		
		//이분 탐색 진행
		for (int k = 0; k < target.length; k++) {
			System.out.println(binarySearch(arr, target[k]));
		}

	}

	public static int binarySearch(int[] arr, int target) {
		// 시작점과 끝점은 탐색 1회가 끝날 때 까진 유지 되어야
		int start = 0;
		int end = arr.length - 1;
		
		// 시작점보다 끝점이 작아지는 경우는 정상적인 탐색이 아님
		// 그렇게 되는 경우는 두가지가 있음
		// 1) 시작점이 갱신되다가 끝점을 넘어가는 경우
		// 2) 끝점이 갱신되다가 시작점을 넘어가는 경우
		while (start <= end) {
			// 중앙값은 반복이 계속되며 새로운 중앙을 찍어야 함
			int mid = (start + end) / 2;
			if (arr[mid] == target) {
				// 찾았으니까 1 반환
				return 1;
			} else if (arr[mid] > target) {
				// 타겟이 더 작으니까 끝점 이동
				end = mid - 1;
			} else if (arr[mid] < target) {
				// 타겟이 더 크니까 시작점 이동
				start = mid + 1;
			}
		}
		return 0;
	}

}
