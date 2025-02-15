package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10824 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		String[] numStr = new String[2];

		long[] num = new long[2];

		for (int i = 0; i < numStr.length; i++) {
			numStr[i] = st.nextToken();
			numStr[i] = numStr[i].concat(st.nextToken());

			num[i] = Long.parseLong(numStr[i]);
		}

		long sum = num[0] + num[1];

		StringBuffer sb = new StringBuffer();

		sb.append(sum);

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
	}
}
