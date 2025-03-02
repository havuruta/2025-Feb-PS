package Week4.problem;

/*
 문제 : 9663(N-Queen)
 시간 : 2664ms
 풀이 : 백트래킹을 통해 체스판에 모든 퀸을 배치하는 경우의 수를 확인하며 가능한 경우를 체크.
 퀸 배치 시 퀸이 존재하는 열, 양 대각선 방문을 체크하고 이후 케이스에서 이를 활용하여 가지치기(조건에 해당하는 케이스를 확인하지 않음) 수행.
 */

import java.util.Scanner;

public class B9663 {
	static boolean[] colCheck; // 열 체크 배열
	static boolean[] crossRUCheck; // 대각선(/) 체크 배열
	static boolean[] crossRBCheck; // 대각선(\) 체크 배열
	static int N;
	static int ans = 0;
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// 체크 배열 생성. 대각선 배열은 N보다 많은 공간이 필요하기에 여유롭게 2N으로 설정
		// ※ 대각선 배열이 이해되지 않을 경우, 체스판에 대각선을 긋고 번호를 매겨보면 도움이 됨.
		colCheck = new boolean[N];
		crossRUCheck = new boolean[2*N];
		crossRBCheck = new boolean[2*N];
		
		// 백트래킹 및 가지치기 수행
		func(0);
		
		System.out.println(ans);
	}
	
	// 백트래킹 수행 재귀 함수
	static void func(int depth) {
		// 모든 퀸 배치가 완료되었 을 때, 카운팅
		// 가지치기로 이미 불가능한 경우를 패스했기 때문에, 배치가 완료되었을 때 별도 파악이 필요하지 않음.
		if (depth == N) {
			++ans;
			return;
		}
		
		// 체스판 depth 행의 각 열을 순회하며 배치 가능한 경우를 체크
		for (int i = 0; i < N; i++) {
			// 이미 배치된 퀸에 의해 열, 양 대각선 방문이 체크된 경우 패스(가지치기).
			if (colCheck[i] || crossRUCheck[depth + i] || crossRBCheck[depth - i + N - 1]) continue;
			
			// 배치 가능한 경우, 열과 양 대각선 방문 배열 해당 인덱스에 체크
			colCheck[i] = true;
			crossRUCheck[depth + i] = true;
			crossRBCheck[depth - i + N - 1] = true;
			func(depth + 1);
			// 체크 복구
			colCheck[i] = false;
			crossRUCheck[depth + i] = false;
			crossRBCheck[depth - i + N - 1] = false;
		}
	}
}
