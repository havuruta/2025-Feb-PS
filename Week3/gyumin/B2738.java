package Week3.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2738 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 입력 처리 시작
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] a = new int[n][];
		for (int i = 0; i < n; i++) {
			a[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		int[][] b = new int[n][];
		for (int i = 0; i < n; i++) {
			b[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		// 입력 처리 끝

		// 이제 같은 인덱스 위치를 찍어가면서 더하면 됨
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(a[i][j] + b[i][j]).append(" ");
			}
			sb.append("\n");
		}

		// 배열에 일단 담고 다시 for문으로 출력할 수도 있겠지만 애초에 문자열 형태로 값을 관리했으니까 바로 출력 
		bw.write(sb.toString());
		
		bw.flush();
		
		br.close();
		bw.close();

	}
}
