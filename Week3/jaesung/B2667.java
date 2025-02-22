package Week3.jaesung;

/*
 문제 : 2667(단지번호붙이기)
 시간 : 184ms
 풀이 : 2차원 배열을 순회하며 bfs를 수행. 이웃한 1을 값으로 갖는 원소를 순회하므로 단지 수 파악 가능.
 bfs 수행 과정에서 해당 원소 방문 시 집의 수를 카운팅하고 각 bfs 종료 시 리스트에 추가.
 정렬 후 리스트 크기와 오름차순 데이터 출력.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class point{
	int x, y;
	
	public point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, -1, 0, 1};
		
		int N = sc.nextInt();
		
		int[][] arr = new int[N][N];
		for (int i = 0; i < arr.length; i++) {
			String str = sc.next();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		boolean isVisit[][] = new boolean[N][N];
		// 집의 수 저장 리스트
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				// 탐색 가능 여부 체크
				if (isVisit[i][j] || arr[i][j] == 0) {
					continue;
				}
				
				// 집의 수 카운팅 시작
				int count = 0;
				
				isVisit[i][j] = true;
				
				Queue<point> q = new LinkedList<>();
				q.add(new point(i, j));
				
				while (!q.isEmpty()) {
					point cur = q.poll();
					// 방문 시 카운팅
					++count;
					
					for (int dir = 0; dir < 4; dir++) {
						int nx = cur.x + dx[dir];
						int ny = cur.y + dy[dir];
						
						if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
							continue;
						}
						
						if (isVisit[nx][ny] || arr[nx][ny] == 0) {
							continue;
						}
						
						isVisit[nx][ny] = true;
						q.add(new point(nx, ny));
					}
				}
				
				list.add(count);
			}
		}
		
		// 정렬 후 출력
		Collections.sort(list);
		
		System.out.println(list.size());
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
}
