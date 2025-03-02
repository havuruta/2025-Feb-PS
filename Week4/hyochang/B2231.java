package hyochang;

import java.util.Scanner;

public class B2231 {

    //각 자리를 분리하는 방법
    //1. 1,000,000범위니까 1,000,000부터 1까지 모두 나누어 더하기 -> 적절한 범위 설정이 없어서 비효율적임
    //2. Math.log10을 활용 -> 상용로그(log10) https://devshovelinglife.tistory.com/842  
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //1번 방법 메모리 17872kb, 시간 212ms
        int result = 0;

        for (int i = 1; i <= n; i++) {
            int sum = i; 
            int num = i;
            int divisor = 1000000; // 가장 큰 자리수부터 나누기 시작

            while (divisor >= 1) { // 각 자리수를 추출하여 합산
                sum += (num / divisor) % 10;
                divisor /= 10;
            }

            if (sum == n) {
                result = i;
                break; // 가장 작은 생성자를 찾으면 종료
            }
        }

        //2번 방법 메모리 17720kb, 시간 172ms
//        int digits = (int) Math.log10(n) + 1; // N의 자릿수 구하기
//        int start = n - (digits * 9); // 최소 생성자 후보 (각 자리 최대 9이므로)
//
//        if (start < 1) start = 1; // 1 이상이어야 함
//
//        for (int i = start; i <= n; i++) {
//            int sum = i;
//            int num = i;
//
//            while (num > 0) {
//                sum += num % 10;
//                num /= 10;
//            }
//
//            if (sum == n) {
//                result = i;
//                break; // 가장 작은 생성자를 찾으면 종료
//            }
//        }
//
        System.out.println(result);
    }
}
