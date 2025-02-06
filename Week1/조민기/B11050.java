package 조민기;

import java.util.HashMap;
import java.util.Map;

// B11050.java
// 문제 11050: 이항 계수 1 - 주어진 N과 K로 이항 계수 계산.
public class B11050 {
    public static void main(String[] args) {
        // 문제 11050 해결을 위한 코드를 작성하세요.

        // 반복문으로도 충분히 풀림
        //     Scanner sc = new Scanner(System.in);
        //     int n = sc.nextInt();
        //     int k = sc.nextInt();
        //     sc.close();
    
        //     System.out.println(binomialCoefficient(n, k));
    // }

    // public static int binomialCoefficient(int n, int k) {
    //     if (k == 0 || k == n) return 1;
    //     int result = 1;
    //     for (int i = 0; i < k; i++) {
    //         result = result * (n - i) / (i + 1);
    //     }
    //     return result;
    // }

        
        // 재귀를 생각할수도 있겠고
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        // sc.close();

        // System.out.println(binomialCoefficient(n, k));
    // }

    // public static int binomialCoefficient(int n, int k) {
    //     if (k == 0 || k == n) return 1;
    //     return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    // }

        // 재귀를 효율적으로 돌리기 위해서 메모이제이션(값 저장)을 활용할수도 있음
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int k = sc.nextInt();
    //     sc.close();

    //     System.out.println(binomialCoefficient(n, k));
    // }

    // public static int binomialCoefficient(int n, int k) {
    //     if (k == 0 || k == n) return 1;
    //     if (dp[n][k] != 0) return dp[n][k]; // 이미 계산된 값이면 바로 반환

    //     return dp[n][k] = binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    // }

        // 메모이제이션 1차원에도 할수있으면 해보기
            
}
