package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S2005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        int[][] pascal = new int[11][11];
        for (int[] arr : pascal){
            Arrays.fill(arr, 1);
        }

        for (int i = 2; i<10; i++){
            for (int j = 1; j<i; j++){
                pascal[i][j] = pascal[i-1][j-1]+pascal[i-1][j];
            }
        }
        for (int i = 1; i<=T; i++){
            int N = Integer.parseInt(br.readLine());
            System.out.println("#"+i);
            for (int j = 0; j<N; j++){
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k<=j; k++){
                    sb.append(pascal[j][k]).append(" ");
                }
                System.out.println(sb.toString());
            }
        }
    }
}
