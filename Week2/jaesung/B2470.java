package jaesung;

/*
 문제 : 2470(두 용액)
 시간 : 352ms
 풀이 : 정렬된 배열의 양 끝 두 지점에서부터 두 용액의 부호 동일 여부와 합의 부호에 따라 각 인덱스를 이동하며 두 용액 값의 합 최소값을 도출.
 */

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2470 {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		// 이분 탐색을 위해 배열 정렬
		Arrays.sort(arr);
		
		int val = 2000000001;
		int leftVal = 0;
		int rightVal = 0;
		int left = 0;
		int right = arr.length - 1;
		
		while (left < right) {
			int sum = arr[left] + arr[right];
			
			// 기준 값보다 작다면 기준 값 갱신
			if (Math.abs(sum) <= val) {
				leftVal = arr[left];
				rightVal = arr[right];
				
				if (sum == 0) 
					break;
				
				val = Math.abs(sum);
			}
			
			// 루프 탈출 조건
			if (right - left == 1) break;
			
			// 양쪽 값의 부호가 다를 경우
			if (arr[right] > 0 && arr[left] < 0) {
				// 합이 음수라면 더 작은 음수로 이동
				if (sum < 0) ++left;
				// 합이 양수라면 더 작은 양수로 이동
				else --right;
			}
			// 양쪽 값의 부호가 같을 경우(=양쪽 범위 내 동일 부호만 존재). 이분 탐색 수행
			else {
				int mid = (left + right) / 2;
				
				// 음수일 경우 더 작은 음수로 이동
				if (sum < 0) left = mid;
				else right = mid;
			}
		}
		
		String ans = leftVal + " " + rightVal;
		bw.write(ans);
		bw.flush();
		bw.close();
    }
}
