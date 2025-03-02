package Week4.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B14888 {
	static int[] arr;
	static int[] ops;
	static int min = 1000000000;
	static int max = -1000000000;

	static void dfs(int idx, int curr) {
		// 각 분기마다 방문 확인은 안해도 됨
		// 연산자 개수를 줄이며 들아가기 때문에 한 번 쓴 연산자를 다시 쓸 걱정은 없음
		if (idx == arr.length) {
			max = Math.max(max, curr);
			min = Math.min(min, curr);
			return;
		}
		
		if (ops[0] > 0) {
			ops[0]--;
			dfs(idx + 1, curr + arr[idx]);
			ops[0]++; // 백트래킹
		}
		// 을 하는 이유는 다시 제일 첫 호출로 돌아왔을 때
		if (ops[1] > 0) {
			ops[1]--;
			// 이 호출에서 연산자 개수를 제대로 파악하기 위해
			dfs(idx + 1, curr - arr[idx]);
			ops[1]++;
		}
		if (ops[2] > 0) {
			ops[2]--;
			dfs(idx + 1, curr * arr[idx]);
			ops[2]++;
		}
		if (ops[3] > 0) {
			ops[3]--;
			if (curr >= 0) {
				dfs(idx + 1, curr / arr[idx]);
			} else {
				dfs(idx + 1, -(-curr / arr[idx]));
			}
			ops[3]++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int volume = Integer.parseInt(br.readLine());

		arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		ops = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		// 브루트 포스로 풀려더 시간 초과 맞았음
		dfs(1, arr[0]);
		
		bw.write(max + "\n" + min);
		bw.flush();

		br.close();
		bw.close();
	}
}
