package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10820 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input;
		while(true) {
			
			input = br.readLine();
			//입력이 없을경우 중지
			if(input == null) {
				break;
			}
			
			//단어의 길이
			int length = input.length();
			
			//대문자 소문자 숫자 공백 개수
			int up = 0;
			int low = 0;
			int num = 0;
			int space = 0;
			
			//입력받은 문자열 돌면서 확인
			for(int i = 0; i < length; i++) {
				char idx = input.charAt(i);
				
				if (idx >= 'A' && idx <= 'Z') {
					up++;
				} else if (idx >= 'a' && idx <= 'z') {
					low++;
				} else if (idx == ' ') {
					space++;
				} else {
					num++;
				}
				
			}
			
			bw.write(low + " " + up + " " + num + " " + space + "\n");
			
		}
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
