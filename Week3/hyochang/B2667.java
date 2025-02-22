package hyochang;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

public class B2667 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		int[][] apart = new int[n][n];//아파트 배열
		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				apart[i][j] = temp.charAt(j) - '0';
			}
		}

		Queue<int[]> que = new ArrayDeque<>();
		boolean[][] visit = new boolean[n][n];// 방문 처리를 위한 똑같은 크기의 배열

		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		int ans = 0;//총 단지 수를 체크
		List<Integer> list = new ArrayList<>();//단지내 집의 수를 저장하기 위한 리스트(오름차순으로 정렬해야하기 때문에 필요)
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (apart[i][j] == 1 && !visit[i][j]) {//집이 있고(==1) 방문하지 않았다면
					int cnt = 1;//단지 내 집 수를 세는 변수
					que.add(new int[] { i, j });//큐에 넣음
					visit[i][j] = true;// 방문 처리
					while (!que.isEmpty()) {//연결된 집을 모두 셈
						int[] arr = que.poll();
						int y = arr[0];
						int x = arr[1];

						for (int k = 0; k < 4; k++) {//델타 탐색
							int ny = y + dy[k];
							int nx = x + dx[k];

                            //배열 범위 안이고 방문하지 않았다면
							if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visit[ny][nx] && apart[ny][nx] == 1) {
								que.add(new int[] { ny, nx });//큐에 추가하고
								visit[ny][nx] = true;//방문처리
								cnt++;//단지 내 집의 수를 올려줌
							}
						}
					}
					ans++;//처음 발견한 단지의 시작에서 모든 탐색이 끝나면 단지 수를 올려줌
					list.add(cnt);//리스트에 추가
				}
			}
		}
		Collections.sort(list);//오름차순 정렬
		sb.append(ans).append("\n");
		for(int i:list) {
			sb.append(i).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}
}