package mini9922g;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// B10809.java
// 문제 10809: 알파벳 찾기 - 각 알파벳의 첫 등장 위치를 출력.
public class B10809 {
    public static void main(String[] args) throws IOException {
        // 문제 10809 해결을 위한 코드를 작성하세요.
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	String input = br.readLine();
    	
    	//'a'부터 돌아가면서 input에 몇번째 위치에 있나 출력
    	for(int i = 0; i < 26; i++) {
    		System.out.print(input.indexOf('a'+ i) + " ");
    	}
    	
    }
}
