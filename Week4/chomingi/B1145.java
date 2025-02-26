package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class B1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] res = new int[1000000];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = arr[i]; j < 1000000; j += arr[i]) {
                res[j]++;
                if (res[j] == 3) {
                    min = Math.min(min, j);
                }
            }
        }
        System.out.println(min);
    }
}
