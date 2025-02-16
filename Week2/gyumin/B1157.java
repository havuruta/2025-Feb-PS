package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1157 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 입력을 받아서
		String input = br.readLine();

		int[] check = new int[26];
		for (int i = 0; i < input.length(); i++) {
			char temp = input.charAt(i);

			if (Character.isUpperCase(temp)) {
				// 대문자는 - 'A'
				// 배열에 체크하기
				check[temp - 'A']++;
			} else {
				// 소문자는 - 'a' 한 값을
				// 배열에 체크하기
				check[temp - 'a']++;
			}
		}

		// 최댓값을 찾아
		char res = '\u0000';
		boolean isSame = false;
		int max = check[0];
		int idx = 0;
		for (int i = 0; i < check.length; i++) {
			if (i != 0 && max == check[i]) {
				// 최댓값이 지금 값이랑 같으면 같은 거
				isSame = true;
				// 플래그 변수를 한 번 변경했다고 해서 바로 나가면 안됨
				// 최댓값이 바뀔 수 있으니까
				// ex. abcc -> c를 찍으면 최댓값이 2로 바뀌어야 하는데 b에서 brake 맞고 나가서 ?를 출력함
			} else if (check[i] > max) {
				isSame = false;
				max = check[i];
				idx = i;
			}
		}

		if (!isSame) {
			int code = idx + 'A';
			res = (char) code;
		} else {
			res = '?';
		}

		bw.write(res);
		bw.flush();

		br.close();
		bw.close();
	}
}
