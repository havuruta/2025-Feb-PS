package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1541 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//입력
		String line = br.readLine();
		
		//합
		int sum = 0;
		
		// - 기준으로 분리
		String[] splitLine = line.split("-");
		
		// +만 있던 앞부분 분리 (맨앞숫자부터 첫 - 나오기 전까지)
		String[] pSLine0 = splitLine[0].split("\\+");
		
		// + 부분 더하기
		for(int i = 0; i < pSLine0.length; i++) {
			sum += Integer.parseInt(pSLine0[i]);
		}
		
		// - 부분 빼기(첫 - 이후 나온 숫자는 모두 빼야함)
		for(int i = 1; i < splitLine.length; i++) {	
			
			// - 뒤에있던 + 분리
			String[] pSLine1 = splitLine[i].split("\\+");
			
			//분리한 수들 빼기
			for(int j = 0; j < pSLine1.length; j++) {
				sum -= Integer.parseInt(pSLine1[j]);
			}
		}
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();
		br.close();
		
		
		
		
		
	}
}
