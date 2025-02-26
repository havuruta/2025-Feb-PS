package chomingi;

import java.io.BufferedReader;
import java.io.IOException;

public class B2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        // 케이스 분할에는 항상
        int start = N - (N + "").length() * 9;
        // 엣지 케이스를 고려해야 한다.
        if (start < 0) {
            start = 0;
        }
        for (int i = start; i < N; i++) {
            int sum = i;
            int temp = i;
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
