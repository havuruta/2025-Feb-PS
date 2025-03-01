import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B2231 {
	static int i;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int length = String.valueOf(N).length();
		for (i = Math.max(N - length * 9, 0); i < N; i++) {
			int sum = i;
			String num = String.valueOf(i);
			for (int j = 0; j < num.length(); j++) {
				sum += Integer.parseInt(String.valueOf(num.charAt(j)));
			}
			if(N == sum) break;
		}
		bw.write(String.valueOf(i == N?0:i));
		br.close();
		bw.flush();
		bw.close();
	}
}
