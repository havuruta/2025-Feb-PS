package jaesung;

/*
 문제 : 7576(토마토)
 시간 : 1648ms
 풀이 : 2차원 배열에서 익은 토마토의 위치로부터 BFS를 수행.
 배열에서 탐색 위치의 값에 현재 위치 값 + 1을 저장하며 해당 위치 토마토가 익는 일수 계산.
 이후 2차원 배열을 순회하며 가장 큰 값을 정답으로 출력. 만약 값이 0인 위치가 있다면 -1을 출력.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		// 순회할 상하좌우 위치 지정 배열
		int[] dx = {0, -1, 0, 1};
		int[] dy = {1, 0, -1, 0};
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		int[][] arr = new int[N][M];
		
		// 탐색 좌표를 담을 큐
		Queue<Integer> xQ = new LinkedList<>();
		Queue<Integer> yQ = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
				
				if (arr[i][j] == 1) { // 익은 토마토 위치 큐에 저장
					xQ.add(i);
					yQ.add(j);
				}
			}
		}
		
		// 익은 토마토 위치로부터 BFS 수행
		while (!xQ.isEmpty()) {
			// 현재 칸 위치
			int curX = xQ.poll();
			int curY = yQ.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = curX + dx[i];
				int ny = curY + dy[i];
				
				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue; // 배열을 벗어나는 인덱스
				if(arr[nx][ny] >= 1 || arr[nx][ny] == -1) continue; // 이미 익었거나, 토마토가 들어있지 않은 칸
				
				// 다음 BFS 대상
				xQ.add(nx);
				yQ.add(ny);
				
				arr[nx][ny] = arr[curX][curY] + 1; // 현재 칸 토마토가 익은 일수에 하루 추가 
			}
		}
		
		// 정답 도출
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(arr[i][j] == 0) { // 익지 않은 토마토가 존재
					System.out.println(-1);
					return;
				}
				
				ans = Math.max(ans, arr[i][j] - 1); // 가장 마지막 토마토가 익을때까지의 날짜 저장
			}
		}
		
		System.out.println(ans);
	}
}