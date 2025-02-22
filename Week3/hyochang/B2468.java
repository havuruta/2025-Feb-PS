package hyochang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2468 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[][] location = new int[n][n];

		int high = 0;//가장 높은 곳의 높이까지 물이차는지 확인하면 되니 높이 최댓값 구하기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				location[i][j] = sc.nextInt();
				high = Math.max(high, location[i][j]);
			}
		}

		int[] dy = { 1, -1, 0, 0 };
		int[] dx = { 0, 0, -1, 1 };

		int water = 0;// 물높이
		int max_safe = 0;// 최대 안전지대

		Queue<int[]> que = new LinkedList<>();

		while (water <= high) {//홍수 시뮬레이션 +1씩하며
			int safe = 0;// 안전지대
			boolean[][] visit = new boolean[n][n];// 방문체크

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
                    //낮고 방문을 안했다면 해당 지역을 모두 탐색할거니까 큐에 넣음
					if (water < location[i][j] && !visit[i][j]) {
						que.add(new int[] { i, j });
						visit[i][j] = true;

						while (!que.isEmpty()) {
							int[] temp = que.poll();
							int y = temp[0];
							int x = temp[1];

							for (int k = 0; k < 4; k++) {
								int ny = y + dy[k];
								int nx = x + dx[k];

								if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visit[ny][nx]
										&& location[ny][nx] > water) {
									que.add(new int[] { ny, nx });
									visit[ny][nx] = true;
								}
							}
						}
						safe++;//붙어있는 모든 지역을 탐색한 후에 안전지대 수를 1개 올려줌
					}

				}
			}
			max_safe = Math.max(max_safe, safe);//최대로 많은 안전지역이 나오는 경우를 구해놓음
			water++;//물높이+1
		}
		System.out.println(max_safe);
	}
}