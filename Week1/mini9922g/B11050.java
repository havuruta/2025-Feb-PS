package mini9922g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// B11050.java
// 문제 11050: 이항 계수 1 - 주어진 N과 K로 이항 계수 계산.
public class B11050 {
    public static void main(String[] args) throws IOException {
        // 문제 11050 해결을 위한 코드를 작성하세요.
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int N = Integer.parseInt(st.nextToken());
    	int K = Integer.parseInt(st.nextToken());
    	
    	int facN = 1;
    	int facK = 1;
    	int facNK = 1;
    	
    	for(int i = 1; i <= N; i++) {
    		facN *= i;
    	}
    	
    	for(int i = 1; i <= K; i++) {
    		facK *= i;
    	}
    	
    	for(int i = 1; i <= N-K; i++) {
    		facNK *= i;
    	}
    	
    	int result = facN / (facK*facNK) ;
    	
    	System.out.println(result);
    	
    }
}
