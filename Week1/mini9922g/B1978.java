package mini9922g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// B1978.java
// 문제 1978: 소수 찾기 - 주어진 숫자 중 소수의 개수를 계산.
public class B1978 {
    public static void main(String[] args) throws IOException {
       
    	
    	BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    	
    	//숫자개수
    	int numberCount = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	
    	//숫자 배열
    	int[] numbers = new int[numberCount];
    	
    	//배열에 값 넣기
    	for(int i = 0; i < numberCount; i++) {
    		numbers[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	//소수개수
    	int primeCount = 0;
    	
    	//소수찾기
    	for(int number : numbers) {
    		int divisor = 0;
    		
    		//약수의 갯수 확인하기
    		for(int i = 1; i <= number; i++) {
    			if(number % i == 0) {
    				divisor++;
    			}
    		}
    		
    		//약수 2개면 소수+1
    		if(divisor == 2) {
    			primeCount++;
    		}
    		
    	}
    	
    	//출력
    	System.out.println(primeCount);
    	
    	
    }
}
