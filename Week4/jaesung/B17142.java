package Week4.problem;

/*
 문제 : 17142(연구소 3)
 시간 : 264ms
 풀이 : 존재하는 비활성 바이러스 중 활성시킬 M개의 바이러스를 선택하고,
 해당 케이스에 대해 bfs를 수행하여 모든 빈칸 감염 일수를 계산.
 계산 결과 모든 빈칸을 감염시켰을 경우, 최솟값 갱신을 진행.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 좌표 클래스
class Pos{
	int x;
	int y;
	
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class B17142 {
	static List<Pos> virusList = new ArrayList<>(); // 비활성 바이러스 좌표 저장 리스트
	static int N;
	static int M;
	static int ans = Integer.MAX_VALUE;
	static int[][] lab;
	static boolean[] isActivate; // 비활성 바이러스 활성화 여부. M개 바이러스 선택 시 활용
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	static int blankCount = 0; // 실험실 내 빈칸 수
	
	public static void main(String[] args) throws IOException {
		// 빠른 입출력 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 0; j < N; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
				
				Pos pos = new Pos(i, j);
				
				// 바이러스인 경우 리스트에 저장
				if (lab[i][j] == 2) virusList.add(pos);
				
				// 빈칸 카운트
				if (lab[i][j] == 0) ++blankCount;
			}
		}
		
		isActivate = new boolean[virusList.size()];
		
		// 백트래킹을 통해 케이스(조합) 구성 및 계산 수행
		func(0, 0);
		
		// 모든 빈칸 감염 여부에 따라 출력
		if (ans == Integer.MAX_VALUE) sb.append(-1);
		else sb.append(ans);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	// 백트래킹 수행 재귀함수. 전체 바이러스에서 M개를 중복되지 않게 뽑아(=조합) 테스트케이스를 구성하고
	// 이에 대해 bfs 수행 후 값 갱신
	static void func(int count, int idx) { 
		// 조합 구성 완료 시
		if (count == M) {
			// bfs 수행
			int val = bfs();
			// 감염 완료인 경우 값 갱신
			if (val != -1) ans = Math.min(ans, bfs());
			
			return;
		}
		
		// 테스트케이스가 중복되지 않도록 이전 재귀 호출 인덱스 다음부터 순회
		for (int i = idx; i < virusList.size(); i++) {
			if (isActivate[i]) continue;
			
			isActivate[i] = true;
			func(count + 1, i+1); // 현재 인덱스+1을 인덱스로 전달
			isActivate[i] = false;
		}
	}
	
	// bfs 수행 함수
	static int bfs() {
		Queue<Pos> q = new LinkedList<>();
		
		// 연구실 내 빈 칸 수
		int target = blankCount;
		// 일수 기록 배열
		int[][] map = new int[N][N];
		int day = 1;
		
		// 활성화된 바이러스를 bfs 시작 지점으로 사용
		for (int i = 0; i < virusList.size(); i++) {
			if (isActivate[i]) {
				Pos virus = virusList.get(i);
				q.add(virus);
				
				map[virus.x][virus.y] = 1;
			}
		}
		
		while (!q.isEmpty()) {
			Pos cur = q.poll();
			
			// 빈칸인 경우에 일수 갱신
			if (lab[cur.x][cur.y] != 2)
				day = Math.max(day, map[cur.x][cur.y]);
			
			// 현재 지점으로부터 상하좌우 지점 감염
			for (int dir = 0; dir < 4; dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if (map[nx][ny] >= 1 || lab[nx][ny] == 1) continue;
				
				// 감염시키는데 하루 소모
				map[nx][ny] = map[cur.x][cur.y] + 1;
				// 빈칸 감염시킨경우 체크
				if (lab[nx][ny] == 0) --target;
				
				q.add(new Pos(nx, ny));
			}
		}
		
		// 모든 빈칸 감염 여부에 따라 값 반환
		return target == 0 ? day-1 : -1;
	}
}
