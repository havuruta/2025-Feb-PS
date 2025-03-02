package Week4.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1977 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		int sum = 0;
		int min = 10000;

		for (int i = a; i <= b; i++) {
			// 완전 제곱수의 경우 .0으로 떨어짐
			// 그러니 * 10을 하면 온전한 10의 배수가 되지만
			// 완전 제곱수가 아니면 10의 배수가 되지 않음
			if (Math.sqrt(i) * 10 % 10 == 0) {
				sum += i;
				min = Math.min(min, i);
			}
		}

		if (sum == 0) {
			sb.append(-1);
		} else {
			sb.append(sum).append("\n").append(min);
		}

		bw.write(sb.toString());

		bw.flush();

		br.close();
		bw.close();
	}
}
