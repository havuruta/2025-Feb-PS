package chomingi;

import java.io.BufferedReader;
import java.io.IOException;

public class B1977 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        //sqrt ceil
        int start = (int)Math.ceil(Math.sqrt(M));
        //sqrt floor
        int end = (int)Math.floor(Math.sqrt(N));

        int sum = 0;
        int min = 0;

        for (int i = start; i <= end; i++) {
            sum += i * i;
            if (min == 0) {
                min = i * i;
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
