package Week3.nayoung;

import java.io.IOException;
import java.util.Scanner;

public class B2738 {
    public static void main(String[] args) throws IOException {
        //행렬덧셈
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //행개수
        int m = sc.nextInt(); //열개수

        int[][] arr1 = new int[n][m];
        int[][] arr2 = new int[n][m];

        //arr1 값입력
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                arr1[r][c] = sc.nextInt();
            }
        }
        //arr2 값입력
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                arr2[r][c] = sc.nextInt();
            }
        }
        //행렬덧셈
        for(int r=0;r<n;r++) {
            for (int c = 0; c < m; c++) {
                System.out.print((arr1[r][c] + arr2[r][c]) + " ");
            }
            System.out.println();
        }
    }
}
