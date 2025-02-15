package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class B10824 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] arr = new String[4];
		
		//숫자 4개 입력받기
		for(int i = 0; i < 4; i++) {
			arr[i] = st.nextToken();
		}
		
		//int 보다 클 수 있어 Long으로 받은후 이어 붙임
		Long sNum1 = Long.parseLong(arr[0] + arr[1]);
		Long sNum2 = Long.parseLong(arr[2] + arr[3]);
		
		bw.write(Long.toString(sNum1 + sNum2));
	
		
		bw.flush();
		bw.close();
	}
}
