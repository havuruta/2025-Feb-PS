package 이창열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8진수 2진수
public class B1212 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		
		String octal = st.nextToken();

		// 8진수를 10진수로 변환한 뒤, 2진수로 변환
		String binary = new java.math.BigInteger(octal, 8).toString(2);
		
		sb.append(binary);

		// 출력
		System.out.println(sb.toString());
	}
}