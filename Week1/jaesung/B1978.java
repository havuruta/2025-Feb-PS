package jaesung;

/*
 문제 : 1978(소수 찾기)
 시간 : 180ms
 풀이 : 입력받은 수 n에 대해 2부터 n까지 약수를 계산. 약수가 n인 경우에만 n이 소수이므로 카운팅
 */

import java.util.Scanner;

public class B1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int ans = 0;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();

			for (int j = 2; j <= num; j++) {
				if (num % j == 0) {
					if(j == num) ++ans;
					else break;
				}
			}
		}

		System.out.println(ans);
	}
}