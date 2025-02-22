package hyochang;

import java.util.Scanner;

public class B2566 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[9][9];

		int ans = Integer.MIN_VALUE;
		int h = 0;
		int w = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr[i][j] = sc.nextInt();
				if (ans < arr[i][j]) {//입력받으며 최솟값이라면 i j 위치도 저장
					ans = arr[i][j];
					h = i+1;
					w = j+1;
				}
			}
		}
		System.out.println(ans);
		System.out.println(h+" "+w);
	}
}