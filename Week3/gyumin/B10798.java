package Week3.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[][] arr = new char[5][];
        
        // 입력 처리
        for(int i = 0; i < arr.length; i++) {
        	arr[i] = br.readLine().toCharArray();
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 이제 세로 탐색을 할건데
        for(int i = 0; i < 15; i++) {
        	for(int j = 0; j < arr.length ; j++) {
        		// 그 열의 길이가 찍어야 되는 행을 담을 수 없다면
        		if(i >= arr[j].length) {
        			// 탐색을 하지 않고 넘어가서 ArrayIndexOutOfBoundException을 회피
        			// 조건 걸기 싫으면 걍 try - catch 문으로 쓰고 catch 시 아무 동작도 하지 않도록 코드블록을 비우는 방법도 가능할듯
        			continue;
        		}
        		// 일열로 출력하라고 했으니까
        		sb.append(arr[j][i]);
        	}
        }
        
        bw.write(sb.toString());
        bw.flush();
        
        br.close();
        bw.close();
    }
}
