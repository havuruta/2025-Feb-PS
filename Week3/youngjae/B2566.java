package Week3.problem;

import java.io.IOException;
import java.util.Scanner;

public class B2566 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
		
		int [][] arr = new int [9][9];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
			}
		}// 입력
		
		
		int row = 0;
		int col = 0;
		// 최댓값
		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] > max) {
					max = arr[i][j];
					row = i;
					col = j;
				}
			}
		}
		System.out.println(max);
		System.out.println(row+1 + " " + (col+1));
    }
}
