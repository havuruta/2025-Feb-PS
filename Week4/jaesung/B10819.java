package Week4.problem;

/*
 문제 : 10819(차이를 최대로)
 시간 : 196ms
 풀이 : 백트래킹을 통해 가능한 모든 자리바꿈 배열(=순열)을 구성하고, 최댓값을 갱신
 
 ※ 처음 풀이에서는 boolean배열을 이용한 체크가 아닌 for문을 통한 비교체크를 진행하였는데,
 196ms vs 212ms 차이가 발생. 예상외로 20ms 차이밖에 발생하지 않음.
 코드 (재귀함수 "for (int i = 0; i < arr.length; i++) {" 아래 작성)
 	for (int j = 0; j < arr.length; j++) {
		if (i == pur[j]) continue find;
	}
 */

import java.util.Scanner;

public class B10819 {
	static int N;
	static int[] arr;
	static int[] pur;
	static boolean[] visit;
	static int ans = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		pur = new int[N];
		visit = new boolean[N];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			pur[i] = -1;
		}
				
		// 백트래킹 수행
		func(0);
		
		System.out.println(ans);
	}
	
	// 백트래킹 수행 재귀함수
	static void func(int depth) {
		// 순열 구성이 완료된 경우
		if (depth == N) {
			// 계산을 수행
			int sum = 0;
			for (int i = 0; i < pur.length-1; i++) {
				sum += Math.abs(arr[pur[i]] - arr[pur[i+1]]);
			}
			
			// 최댓값을 갱신
			ans = Math.max(ans, sum);
			
			return;
		}
		
		// 순열 값으로 지정할 입력배열(arr) 인덱스를 순열 배열(pur)에 저장
		for (int i = 0; i < arr.length; i++) {
			// 이미 지정한 인덱스일 경우 패스
			if (visit[i]) {
				continue;
			}

			// 인덱스 지정 및 지정 체크
			pur[depth] = i;
			visit[i] = true;
			
			func(depth + 1);
			
			pur[depth] = -1;
			visit[i] = false;
		}
	}
}
