package Week3.강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10798 {
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	//입력이 들어갈 배열 
    	String[][] input = new String[5][15];
    	
    	//입력받기
    	for(int i = 0; i < 5; i++) {
    		String line = br.readLine();
    		for(int j = 0; j < line.length(); j++) {
    			input[i][j] = line.charAt(j) + "";
    		}
    	}
    	//배열 순회하면서 출력넣기
    	for(int i = 0; i < 15; i++) {
    		for(int j = 0; j < 5; j++) {
    			if(input[j][i] != null) {
    				bw.write(input[j][i]);
    			}	
    		}
    	}
    	
    	bw.flush();
    	bw.close();
    	br.close();
    }
}
