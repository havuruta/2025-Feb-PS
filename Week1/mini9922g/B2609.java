package mini9922g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// B2609.java
// 문제 2609: 최대공약수와 최소공배수 - 두 자연수의 GCD와 LCM 계산.
public class B2609 {
    public static void main(String[] args) throws IOException {
        // 문제 2609 해결을 위한 코드를 작성하세요.
    	
    	BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	//두 자연수 입력받기
    	int num1 = Integer.parseInt(st.nextToken());
    	int num2 = Integer.parseInt(st.nextToken());
    	
    	//최대공약수
    	int maxDivisor = 1;
    	
    	//최대공약수 계산
    	for(int i = 2; i <= num1; i++) {
    		if(num1 % i == 0 && num2 % i == 0) {
    			if (i > maxDivisor) {
    				maxDivisor = i;
    			}
    		}
    	}
    	
    	System.out.println(maxDivisor);
    	
    	//최소공배수 (최대공약수 * 최대공약수로 나눈 몫1 * 최대공약수로 나눈 몫2 
    	int minMultiple = maxDivisor * (num1 / maxDivisor) * (num2 / maxDivisor);
    	
    	System.out.println(minMultiple);
    }
}
