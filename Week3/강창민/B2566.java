package Week3.강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2566 {
    public static void main(String[] args) throws IOException {
        
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	//숫자 배열 사실 없어도 괜찮
    	int[][] numbers = new int[9][9];
    	
    	int maxNum = -1;
    	int x = -1;
    	int y = -1;
    	
    	//숫자 입력받으면서 최대값 찾고 위치 저장
    	for(int i = 0; i < 9; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		for(int j = 0; j < 9; j++) {
    			numbers[i][j] = Integer.parseInt(st.nextToken());
    			if(numbers[i][j] > maxNum) {
    				maxNum = numbers[i][j];
    				x = i+1;
    				y = j+1;
    			}
    		}
    	}
    	
    	bw.write(maxNum + "\n");
    	bw.write(x + " " + y);
    	bw.flush();
    	bw.close();
    	br.close();
    }
}
