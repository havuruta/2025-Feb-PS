package gyumin;

import java.util.Scanner;

// B1546.java
// 문제 1546: 평균 - 점수를 조작하여 새로운 평균 계산.
public class B1546 {
    public static void main(String[] args) {
        // 문제 1546 해결을 위한 코드를 작성하세요.
    	
    	Scanner sc = new Scanner(System.in);
    	// 과목 수 입력받기
    	int n = sc.nextInt();
    	// 총점 및 점수들 저장할 공간
    	double sum = 0.0;
    	int [] scores = new int[n];
    	double high = 0;
    	
    	// 점수 등록
    	for(int i = 0; i < n; i++) {
    		int temp = sc.nextInt();
    		scores[i] = temp;
    	}
    	
    	// 최고점 탐색
    	for(int i = 0; i < n; i++) {
    		if(scores[i] > high) {
    			high = scores[i];
    		}
    	}
    	
    	// 점수 조작
    	for(int i = 0; i < n; i++) {
    		sum += (scores[i] / high * 100);
    	}
    	
    	System.out.println(sum / n);
    	
    }
}
