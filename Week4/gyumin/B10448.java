package Week4.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10448 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 입력은 1000 이하니까 대충 Tn의 n 최댓값은 n(n + 1)/2 <= 1000 이라는 부등식을 풀면 나옴
		// 그럼 적당히 반올림하면 44랑 -45가 나옴
		// 그러니까 n 최댓값은 44(반올림 하기 전 값이 44보다 큼)

		int[] arr = new int[44 + 1];

		for (int i = 1; i <= 44; i++) {
			arr[i] = i * (i + 1) / 2;
		}

		int T = Integer.parseInt(br.readLine());

		for (int tests = 1; tests <= T; tests++) {
			int input = Integer.parseInt(br.readLine());
			boolean IsFound = false;

			// 그냥 3중 for문으로 냅다 값 3개 뽑아서 더하는게 제일 정신건강에 좋은 풀이 같음
			for (int i = 1; i <= 44; i++) {
				for (int j = 1; j <= 44; j++) {
					for (int k = 1; k <= 44; k++) {
						if (input == arr[i] + arr[j] + arr[k]) {
							IsFound = true;
							break;
						}
					}
				}
			}

			if (IsFound) {
				bw.write(1 + "\n");
			} else {
				bw.write(0 + "\n");
			}

			bw.flush();

		}

		br.close();
		bw.close();
	}
}
