package Week4.problem;

/*
 문제 : 6064(카잉 달력)
 시간 : 692ms
 풀이 : 최초 x인 해부터 M과 N의 최소공배수인 가장 마지막 해까지 y에 M을 더하며 해를 계산
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B6054 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for (int testCase = 0; testCase < T; testCase++) {
			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			// 가장 마지막 해
			int last = 0;
			
			// 가장 마지막 해 구하기
			// M, N의 최소공배수
			int a = M > N ? N : M;
			int b = M > N ? M : N;
				
			// 최대 공약수 계산
			while (a != 0) {
				int tmp = a;
				a = b % a;
				b = tmp;
			}
				
			// 최소공배수 계산
			last = M * N / b;
			
			// 처음 x인 순간부터 M씩 더하며 연도 계산
			int ans = -1;
			for (int i = x; i <= last; i += M) {
				// N 이상인 경우 나머지 값을 갖도록 계산
				int curY = i % N;
				// N인 경우 나머지 연산으로 인해 0이되므로 체크
				if (curY == 0) curY = N;
				
				if (curY == y) {
					ans = i;
					break;
				}
			}
			
			sb.append(ans + "\n");
			bw.write(sb.toString());
			bw.flush();
		}
		bw.close();
	}
}