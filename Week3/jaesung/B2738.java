package Week3.jaesung;

/*
 문제 : 2738(행렬 덧셈)
 시간 : 500ms
 풀이 : 첫번째 행렬을 입력받은 뒤, 두번째 행렬을 입력받음과 동시에 첫번째 행렬 해당 원소에 덧셈 수행
 
 ※ 행렬 덧셈 값을 저장하지 않고 바로 출력하는 것도 정답 처리됨.
 System.out.print((mat[i][j] + sc.nextInt()) + " ");
 어느정도 실행 시간을 단축시킬 수 있다 생각했지만 오히려 실행 시간이 약간 증가함
 */

import java.util.Scanner;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] mat = new int[N][M];
		
		// 첫번째 행렬 입력
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		// 두번째 행렬 입력과 동시에 덧셈
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				mat[i][j] += sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
