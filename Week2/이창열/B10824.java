package 이창열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 네 수
public class B10824 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		String[] num = new String[4];
		
		// 숫자 A B C D 입력 -> 문자 변환
		for(int i = 0; i < 4; i++) {
			num[i] = st.nextToken();
		}
		
		// 문자 A + B
		String AB = num[0] + num[1];
		
		// 문자 C + D
		String CD = num[2] + num[3];
		
		// 숫자 AB + 숫자 CD
		long sum = Long.parseLong(AB) + Long.parseLong(CD);
		
		System.out.println(sum);
	}
}
