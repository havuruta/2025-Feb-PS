package Week3.jaesung;

/*
 문제 : 2468(안전 영역)
 시간 : 488ms
 풀이 : 2차원 배열을 순회하며 bfs를 수행하여 안전 영역의 최대 개수를 파악한다.
 0부터 입력 배열의 최대 높이 + 1까지를 물에 잠기는 높이로 지정하여 각 높이에 대해 수행한다.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 배열 좌표 표현 클래스
class point{
	int x;
	int y;
	
	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] arr = new int[N][N];
		
		// bfs 탐색 범위
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		
		// 가장 높은 지점의 높이
		int maxHeight = 0;
		
		// 입력과 동시에 가장 높은 지점 높이 저장
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				arr[i][j] = sc.nextInt();
				
				maxHeight = Math.max(maxHeight, arr[i][j]);
			}
		}
		
		// 물에 잠기는 모든 경우에 대해 bfs를 수행하여 최대 영역 개수 파악
		int ans= 0;
		for (int height = 1; height <= maxHeight+1; height++) {
			boolean[][] isVisit = new boolean[N][N];
			Queue<point> q = new LinkedList<>();
			
			int val = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					// 안전한 영역이 아닐 경우 스킵
					if (arr[i][j] <= height) {
						continue;
					}
					
					// 이미 방문한 경우 스킵
					if (isVisit[i][j]) {
						continue;
					}
					
					// 안전한 영역일 경우 bfs 수행
					q.add(new point(i, j));
					isVisit[i][j] = true;
					
					++val;
					while (!q.isEmpty()) {
						point cur = q.poll();
						
						for (int dir = 0; dir < 4; dir++) {
							int nx = cur.x + dx[dir];
							int ny = cur.y + dy[dir];
							
							// 인덱스 범위 벗어날경우 스킵
							if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
								continue;
							}
							
							// 안전한 영역이 아니거나 이미 방문한 경우 스킵
							if (arr[nx][ny] <= height || isVisit[nx][ny]) {
								continue;
							}
							
							// 방문 가능한 안전 영역인 경우 체크
							isVisit[nx][ny] = true;
							q.add(new point(nx, ny));
						}
					}
				}
			}
			
			ans = Math.max(ans, val);
		}
		
		System.out.println(ans);
	}
}
