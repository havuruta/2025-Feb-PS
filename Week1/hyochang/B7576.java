package hyochang;
//B7576.java
//문제 7576: 토마토 - BFS를 이용하여 토마토가 모두 익는 최소 일수 계산.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B7576 {
 public static void main(String[] args) {
     // 문제 7576 해결을 위한 코드를 작성하세요.
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] tomato = new int[n][m];

		Queue<int[]> queue = new LinkedList<int[]>();//큐 생성
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				tomato[i][j] = sc.nextInt();
				if (tomato[i][j] == 1) {
					queue.offer(new int[] { i, j });//1일때 {행,열} 순으로 큐에 넣음 
				} 
			}
		}
		int ans = bfs(queue, tomato);
		
		boolean check=true;//bfs이후에 익지 않은 토마토 확인
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tomato[i][j] == 0) {
					check=false;//하나라도 있으면 숙성실패
				} 
			}
		}
		if(check)
			System.out.println(ans);
		else
			System.out.println(-1);
	}

	public static int bfs(Queue<int[]> sample, int[][] arr) {//bfs 메서드
		int h = arr.length;
		int w = arr[0].length;

		int[] dy = new int[] { 1, -1, 0, 0 };
		int[] dx = new int[] { 0, 0, 1, -1 };//델타탐색 하, 상, 우, 좌
		
		int count = -1;//처음 입력받은 수를 출력할때도 +1하기 때문에 0으로 만들기 위해
		while (!sample.isEmpty()) {//큐가 빌 때까지 계속
			int size = sample.size();//현재 큐의 크기 
			count++;//하루가 지날때마다 +1
			for (int i = 0; i < size; i++) {
				int[] tt = sample.poll();//큐에 있는 요소 꺼내기
				int y = tt[0];//행
				int x = tt[1];//열

				for (int j = 0; j < 4; j++) {
					int ny = y + dy[j];
					int nx = x + dx[j];
					if (ny >= 0 && ny < h && nx >= 0 && nx < w && arr[ny][nx] == 0) {//범위 안나가고 배열 값이 0일때
						arr[ny][nx] = 1;//1로 바꿔줌=> 배열 값이 0일때만 탐색하기때문에 방문여부를 확인하는 배열이 없어도 여부를 확인할 수 있음
						sample.offer(new int[] {ny,nx});//큐에 추가
					}
				}
			}
		}
		return count;
	}
}