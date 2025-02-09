package hyochang;
// B1074.java

// 문제 1074: Z - Z 모양으로 배열을 탐색하여 특정 위치 계산.

import java.util.Scanner;

public class B1074 {
	public static void main(String[] args) {
		// 문제 1074 해결을 위한 코드를 작성하세요.
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();

		int ans = 0;
		for (int i = n - 1; i >= 0; i--) {// r,c를 나눠서 위치를 알기 위해
			int a = (int) Math.pow(2, i);// 배열의 길이는 2^n|a->4개의 사각형의 한변 길이
			int area = (int) Math.pow(4, i);// 배열 안의 숫자는 사분면마다 (4^n) 만큼 값이 증가함

			int r_point = (r / a) % 2;// 1이 나오면 아래 0이 나오면 위
			int c_point = (c / a) % 2;// 1이 나오면 오른쪽 0이나오면 왼쪽
										// 전체 한변의 절반으로 r과c의 나누기때문에 1아니면 0이 나옴
			ans += (2 * r_point + c_point) * area;// 1사분면은 0~(4^n)-1 2사분면은 (4^n)~2*(4^n)-1 3사분면은2*(4^n)~3*(4^n)-1 //
													// 4사분면은3*(4^n)~4*(4^n)-1
		} // 1사분면-> 0 0(=0~(4^n)-1)일때 2사분면-> 0 1(=(4^n)++) 3사분면-> 1 0(=2*(4^n)++) 4사분면 1
			// 1(=3*(4^n))
		System.out.println(ans);

	}
}
