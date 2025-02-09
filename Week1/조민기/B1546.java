package 조민기;

import java.util.Scanner;

// B1546.java
// 문제 1546: 평균 - 점수를 조작하여 새로운 평균 계산.
public class B1546 {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            double num = sc.nextInt();
            max = Math.max(max, num);
            sum += num;
        }
        System.out.println((sum / max) * 100 / n);
    }
}
