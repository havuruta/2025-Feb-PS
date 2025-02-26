package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10448 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int maxIdx = 44;
        int[] arr = new int[maxIdx + 1];

        for (int i = 1; i <= maxIdx; i++) {
            arr[i] = i * (i + 1) / 2;
        }

        boolean[] eureka = new boolean[1001];

        // 3중 for문
        for (int i = 1; i<=maxIdx; i++) {
            for (int j = i; j<=maxIdx; j++) {
                for (int k = j; k<=maxIdx; k++) {
                    if (arr[i] + arr[j] + arr[k] <= 1000) eureka[arr[i] + arr[j] + arr[k]] = true;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            System.out.println(eureka[K] ? 1 : 0);
        }


    }
}
