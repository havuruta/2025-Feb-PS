package Week3.problem;

import java.io.IOException;
import java.util.Scanner;

public class B2738 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arrA = new int[N][M];
		int[][] arrB = new int[N][M];
		int[][] result = new int [N][M];
		
		// 입력값 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arrA[i][j] = sc.nextInt();
			}
		}
		
		// 입력값 넣기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arrB[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result[i][j] = arrA[i][j] + arrB[i][j];
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
    }
}
