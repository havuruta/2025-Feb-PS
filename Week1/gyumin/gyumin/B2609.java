package gyumin;

import java.util.Scanner;

// B2609.java
// 문제 2609: 최대공약수와 최소공배수 - 두 자연수의 GCD와 LCM 계산.
public class B2609 {
    public static void main(String[] args) {
        // 문제 2609 해결을 위한 코드를 작성하세요.
    	
    	/*
    	 * 풀이에 필요한 개념: 유클리드 호제법, 최소 공배수의 특징
    	 * 1) 유클리드 호제법
    	 * : a>b 일 때, a%b와 b의 최대 공약수와 a와 b의 최대 공약수는 같다
    	 * -> 나머지가 0일 때 까지 계속 연산하게 하는 알고리즘을 구현하면 됨
    	 * 
    	 * 2) 최소 공배수의 특징
    	 * : a와 b의 최소 공배수는 a*b를 두 수의 최대 공약수로 나눈 값과 같다
    	 * -> 1)을 이용해서 최대 공약수를 구한 후 값을 저장해야 함
    	 */
    	
    	Scanner sc = new Scanner(System.in);
    	
    	int a = sc.nextInt();
    	int copyA = a;
    	int b = sc.nextInt();
    	int copyB = b;
    	int left = -1;
    	if(a < b) {
    		int temp = a;
    		a = b;
    		b = temp;
    	}
    	
    	while (left != 0) {
    		left = a % b;
    		a = b;
    		b = left;
    	}
    	
    	System.out.println(a);
    	System.out.println(copyA * copyB / a);
    }
}
