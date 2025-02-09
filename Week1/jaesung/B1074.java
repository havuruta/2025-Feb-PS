package jaesung;

/*
 문제 : 1074(Z)
 시간 : 168ms
 풀이 : 배열의 크기가 1x1이 될 때까지 행과 열, 방문 번호를 갱신하며 재귀를 수행.
 각 재귀함수 수행 시 lenxlen 크기의 배열을 사분면으로 구분하고 전달된 행과 열이 어느 사분면에 해당하는지 파악한 뒤
 그에 맞게 행과 열을 갱신한 뒤 방문 번호를 더함. 이후 len / 2, 갱신된 행과 열 변수를 매개변수로 재귀함수를 호출.
 */

import java.util.Scanner;

public class B1074 {
    public static int ans = 0;
	
	public static void z(int len, int r, int c) {
		if(len == 1)
			return;
		
		if(r < len / 2 && c < len / 2) {
			z(len / 2, r, c);
		}
		else if(r < len / 2 && c >= len / 2) {
			ans += len * len / 4;
			z(len / 2, r, c - len / 2);
		}
		else if(r >= len / 2 && c < len / 2) {
			ans += (len * len / 4) * 2;
			z(len / 2, r - len / 2, c);
		}
		else {
			ans += (len * len / 4) * 3;
			z(len / 2, r - len/2, c - len/2);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();;
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		z((int)Math.pow(2, N), r, c);
		System.out.println(ans);
	}
}