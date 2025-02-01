package nayoung;
// B11050.java
// 문제 11050: 이항 계수 1 - 주어진 N과 K로 이항 계수 계산.
import java.util.Scanner;

public class B11050 {
    public static void main(String[] args) {
        // 문제 11050 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        // n! 구해주기
        int n_fact = 1;
        for(int i=n;i>=1;i--){
            n_fact *= i;
        }

        // (n-k)! 구해주기
        int nk = 1;
        for(int i=(n-k);i>=1;i--){
            nk *= i;
        }

        // k! 구해주기
        int k_fact = 1;
        for(int i=k;i>=1;i--){
            k_fact *= i;
        }

        // 5_C_2 출력하기
        System.out.println(n_fact/(nk*k_fact));
    }
}
