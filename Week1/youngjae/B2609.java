package youngjae;

import java.util.Scanner;

// B2609.java
// 문제 2609: 최대공약수와 최소공배수 - 두 자연수의 GCD와 LCM 계산.
public class B2609 {
    public static void main(String[] args) {
        // 문제 2609 해결을 위한 코드를 작성하세요.
        	Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int max = -1;
		int greatest_common_divisor = 0;
		int least_common_multiple = 0;
		
		// 최대공약수
		if (num1 > num2) {
			for (int i = 1; i <= num1; i++) {
				if (num1 % i == 0 && num2 % i == 0) {
					int medium = i;
					if (i > max) {
						max = i;
					}
				}
			}
		} else {
			for (int j = 1; j <= num2; j++) {
				if (num1 % j == 0 && num2 % j == 0) {
					int medium = j;
					if (j > max) {
						max = j;
					}
				}
			}
		}
		
		
		int remain1 = num1 / max;
		int remain2 = num2 / max;
		least_common_multiple = max * remain1 * remain2; 
		
		System.out.println(max);
		System.out.println(least_common_multiple);
    }
}
