package jaesung;

/*
 문제 : 11050(이항 계수1)
 시간 : 176ms
 풀이 : 이항계수는 조합*과 같으므로, nCk를 계산하여 출력.
 *조합(combination) : n개의 집합에서 원하는 개수 k만큼 중복없이 순서를 고려하지 않고 선택하는 것
 */

import java.util.Scanner;

public class B11050 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
	
		int p = 1;
		int c = 1;
		while(K != 0)
		{
			p *= N;
			c *= K;
			
			--N;
			--K;
		}
		
		System.out.println(p / c);
	}
}
