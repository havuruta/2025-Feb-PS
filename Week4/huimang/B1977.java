package Week4.problem;

import java.io.IOException;
import java.util.Scanner;

public class B1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int N = sc.nextInt();
        int M = sc.nextInt();


        // 완전 제곱수를 모두 찾아 합을 출력해야하니..
        int sum = 0;

        //그리고 완전 제곱수 중 최소값
        int min = Integer.MAX_VALUE;
        for(int i = N; i<=M; i++) {

            // i가 완전 제곱수인지.. 1부터 찾아줌.
            for(int j=1; j<=i; j++) {
                if(j * j == i) {
                    // 완전 제곱수면 더함
                    sum += i;

                    // 그리고 최소값 갱신
                    if(min > i) {
                        min = i;
                    } 
                }
            }
        }

        // 합이 0이면 하나도 없는것이니.. -1 출력
        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
