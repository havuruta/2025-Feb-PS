package gyumin;

import java.util.Scanner;

// B11050.java
// 문제 11050: 이항 계수 1 - 주어진 N과 K로 이항 계수 계산.
public class B11050 {
    public static void main(String[] args) {
        // 문제 11050 해결을 위한 코드를 작성하세요.
    	
    	/*
    	 * 풀이에 필요한 개념: 조합, 이항계수
    	 * 1) 조합
    	 * : n개의 선택지 중, r개를 무작위로 뽑은 경우의 수
    	 * 
    	 * 2) 이항게수
    	 * : 조합의 개념을 이용하여 이항정리를 하는 내용
    	 * (a+b) ** n 을 생각할 때 각 항은 a를 r개 b를 n-r개 고르는 경우에 해당함
    	 * 이 개념을 이용하면 r을 0부터 n까지 날리는 시그마를 활용해 각 항의 계수를 구할 수 있음
    	 */
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	
    	int r = sc.nextInt();
    	
    	// n!
    	int nfac = factorial(n);
    	
    	// r!
    	int rfac = factorial(r);
    	
    	
    	//(n-r)!
    	int nMr = factorial(n - r);
    	    	
    	// 연산
    	System.out.println(nfac / (rfac * nMr));
    }
    
    public static int factorial(int i) {
    	if(i <= 1) {
    		return 1;
    	}
    	return i * factorial(i - 1);
    }
}
