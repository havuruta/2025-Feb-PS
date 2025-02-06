package youngjae;
import java.util.Scanner;

import java.util.Scanner;

// B11050.java
// 문제 11050 : 이항 계수 1 - 주어진 N과 K로 이항 계수 계산.
// 풀이 11050 : 
public class B11050 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int result = 1;
		int result2 = 1;
		int divide = 0;
		
		for (int i = N; i > K; i--) {
			result *= i;
		} // 120
		for (int i = N-K; i > 0; i--) {
			result2 *= i;
		} // 
		divide = result / result2;
		System.out.println(divide);
        
    }
}
