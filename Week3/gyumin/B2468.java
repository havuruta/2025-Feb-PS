package Week3.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B2468 {
	static int n;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	static void dfs(int height, int r, int c) {
		// 들어왔으니까 방문처리
		visited[r][c] = true;
		
		// 델타 탐색 진행을 트리 형태로 잘 그려보면 재귀 호출이라는 트리를 DFS 하고있는 형태
		for(int i = 0; i < 4; i++) {
			int newr = r + dr[i];
			int newc = c + dc[i];
			if(newr >= 0 && newr < n && newc >= 0 && newc < n ) {
				if(arr[newr][newc] > height && !visited[newr][newc]) {
					dfs(height, newr, newc);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());

		arr = new int[n][];
		
		// 일단 지대에 관한 정보를 전부 저장
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		// 최대 높이를 찾는 로직
		int maxHeight = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				maxHeight = Math.max(maxHeight, arr[i][j]);
			}
		}

		// 최대 영역을 찾는 로직
		int maxArea = 0;

		for (int i = 0; i < maxHeight; i++) {
			// 높이가 바뀔 때마다 방문 여부를 다시 확인해주어야 함
			visited = new boolean[n][n];
			int area = 0;
			for (int j = 0; j < n; j++) {
				for(int k = 0; k < n; k++) {
					if(arr[j][k] > i && !visited[j][k]) {
						// DFS를 끝내고 나오면 나오기 전까지 진행된 탐색에서 찾은 자리들이 한 영역 묶음임
						dfs(i, j, k);
						// 그러니까 나오면 영역 수 늘려주기
						area++;
					}
				}
			}
			maxArea = Math.max(maxArea, area);
		}

		bw.write(maxArea + "");
		bw.flush();

		br.close();
		bw.close();
	}
}
