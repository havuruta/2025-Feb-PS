package youngjae;

import java.util.Scanner;

// B1978.java
// 문제 1978: 소수 찾기 - 주어진 숫자 중 소수의 개수를 계산.
public class B1978 {
    public static void main(String[] args) {
        // 문제 1978 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int count = 0;
			for (int j = 1; j <= a; j++) {
				if (a != 1 && a % j == 0) {
					count += 1;
					
				}
			}
            if (count == 2) {
						result += 1;
			}
		}
		System.out.println(result);
    }

}
