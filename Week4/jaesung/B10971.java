package Week4.problem;

/*
 문제 : 10971(외판원 순회 2)
 시간 : 304ms
 풀이 : 모든 도시를 출발점으로 지정한 각 경우에 대해 백트래킹을 수행하며 출발점과 도착점이 같은 경우 최소 비용을 갱신한다.
 
 ※ 시간 개선 : 1772ms -> 1680ms -> 304ms
 1차 개선 : Scanner에서 빠른 입출력으로 변경. 하지만 눈에 띄는 개선이 되지 않음.
 2차 개선 : 재귀함수 탈출 조건을 N이 아닌 N-1로 지정한 결과, 많은 시간 단축.
 백트래킹 과정에서 depth를 한단계 덜 탐색한 것이 원인으로 보임.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10971 {
	static int N;
	static int[][] route;
	static int ans = Integer.MAX_VALUE;
	static boolean visit[];
	static int start;
	static int val;
	
	public static void main(String[] args) throws IOException {		
		// 빠른 입출력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		route = new int[N+1][N+1];
		visit = new boolean[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for (int j = 1; j <= N; j++) {
				route[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 모든 도시를 출발지로 설정하고 백트래킹 수행
		for (int i = 1; i <= N; i++) {
			start = i;
			// 출발지 방문처리
			visit[i] = true;
			travel(0, i);
			visit[i] = false;
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	// 백트래킹 수행
	static void travel(int count, int cur) {		
		if (count == N-1) {
			// 최종도시에서 출발도시로 도달할 수 있는 경우 값 갱신
			if (route[cur][start] != 0) ans = Math.min(ans, val + route[cur][start]);
			
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (visit[i] || route[cur][i] == 0) continue;
				
			visit[i] = true;
			val += route[cur][i];
			
			travel(count + 1, i);
			
			visit[i] = false;
			val -= route[cur][i];
		}
	}
}
