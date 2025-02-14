package problem;

/*
 문제 : 3273(두 수의 합)
 시간 : 804ms
 풀이 : 수열을 정렬시킨 후, 양 끝에서부터 인덱스를 이동하며 두 수의 합을 확인.
 두 수의 합과 x의 대소 관계를 통해 인덱스를 이동하기 위해 정렬이 필요.
 */

import java.util.Arrays;
import java.util.Scanner;

public class B3273 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) 
			arr[i] = sc.nextInt();
		
		int x = sc.nextInt();
		
		// 배열 정렬
		Arrays.sort(arr);
		
		// 순서쌍 도출
		int ans = 0;
		int left = 0;
		int right = arr.length-1;
		while (left < right) { // 정렬된 배열 양 끝에서부터 인덱스를 이동하며 두 수의 합 확인
			 // 두 수의 합이 일치하는 경우 양쪽 인덱스 이동.
			if(arr[left] + arr[right] == x) {
				++left;
				--right;
				++ans;
			}
			// 두 수의 합이 x보다 작은 경우. 더이상 left와 더해 x가 되는 수가 없으므로 left를 이동.
			else if (arr[left] + arr[right] < x) ++left; 
			// 아직 left에 해당하는 순서쌍을 구할 수 있으므로 right를 이동.
			else --right;
		}
		
		System.out.println(ans);
    }
}
