package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1259 {
    public static void main(String[] args) throws IOException{
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	String input = br.readLine();
    	
    	//입력값이 0이 아닐때까지
    	while(!(input.equals("0"))) {
    		
    		//팰린드롬 체크
    		boolean palin = true;
    		
    		//문자열로 받은 숫자 대칭 확인
    		for(int i = 0; i < input.length() / 2; i++) {
    			if(input.charAt(i) != input.charAt(input.length() - 1 - i)) {
    				palin = false;
    			}
    		}
    		
    		//팰린드롬 결과 확인
    		if(palin) {
    			bw.write("yes\n");
    		} else {
    			bw.write("no\n");
    		}
    		
    		input = br.readLine();
    	}
    	bw.flush();
    	bw.close();
    	br.close();
    	
    	
    }
}
