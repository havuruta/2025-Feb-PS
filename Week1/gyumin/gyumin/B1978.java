package gyumin;

import java.util.Scanner;

// B1978.java
// 문제 1978: 소수 찾기 - 주어진 숫자 중 소수의 개수를 계산.
public class B1978 {
	public static void main(String[] args) {
        // 문제 1978 해결을 위한 코드를 작성하세요.
		
		/*
    	 * 풀이에 필요한 개념: 에라토스테네스의 체
    	 * 찾아내고 싶은 범위만큼 자연수를 늘어놓고 합성수를 지워나가는 방식
    	 * 결과적으로 살아남은 수는 모두 소수임
    	 */
		
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int count = 0;
    	
    	// 소수 여부를 저장할 체 역할의 배열 선언
    	// 조건에 맞추어 1000번째 인덱스까지 가진 배열 선언
    	int [] filter = new int [1001];
    	
    	// 해당 수와 동일한 인덱스에 소수면 0, 합성수면 -1로 변경되는 로직의 반복문 작성
    	for(int i = 0; i < filter.length; i++) {
    		if(i < 2) {
    			filter[i] = -1;
    			continue;
    		}
    		for(int j = i + 1 ; j <filter.length; j++) {
    			if(j % i == 0) {
        			filter[j] = -1;
        		}
    		}
    	}
    	
    	// input 받은 값에 해당하는 index의 값 비교
    	for(int i = 0; i < n; i++) {
    		int input = sc.nextInt();
    		if(filter[input] == 0) {
    			count++;
    		}
    	}
    	
    	System.out.println(count);
    	
    }
}
