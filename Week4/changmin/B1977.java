package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* B1977 완전 제곱수
 * M이상 N이하의 자연수 중 완전제곱수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최솟값을 출력한다. 
 * 단, M이상 N이하의 자연수 중 완전제곱수가 없을 경우는 첫째 줄에 -1을 출력한다.
 */
public class B1977 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int sum = 0;
		int small = Integer.MAX_VALUE;

		int i = 1;
		while (i * i <= N) {

			int num = i * i;

			if (num < M) {
				i++;
				continue;
			}

			if (num >= M && num <= N) {
				small = Math.min(small, num);
				sum += num;
			}
			i++;
		}
		
		if(sum == 0) {
			bw.write(-1 +"");
		} else {
			bw.write(sum + "\n");
			bw.write(small + "");
		}
		
		bw.flush();
		br.close();
		bw.close();
	}
}
