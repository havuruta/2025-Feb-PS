package Week3.jaesung;

/*
문제 : 11725(트리의 부모 찾기)
시간 : 612ms(빠른 입출력 사용. Scanner 사용 시 1860ms)
풀이 : 트리의 루트 노드 1번에서부터 dfs를 수행하며 부모 노드를 갱신.
현재 방문 노드가 아직 방문하지 않은 인접 노드를 순회할 때 해당 노드의 부모 노드를 현재 방문 노드임을 이용.
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem {
	// 인접 리스트로 트리 입력
	static List<List<Integer>> tree = new ArrayList<>();
	// 부모 노드 저장 배열
	static int[] ans;
	// 방문 여부 체크 배열
	static boolean isVisit[];
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		
		ans = new int[N+1];
		isVisit = new boolean[N+1];
		
		// 중첩 리스트 추가
		for (int i = 0; i <= N; i++) {
			tree.add(new ArrayList<Integer>());
		}
		
		// 트리 정보 입력
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			// dfs 수행을 위해 양방향 입력
			tree.get(v1).add(v2);
			tree.get(v2).add(v1);
		}
		
		// 루트에서부터 dfs 수행하며 부모 노드 파악
		dfs(1);
		
		for (int i = 2; i <= N; i++) {
			sb.append(ans[i] + "\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dfs(int v) {
		isVisit[v] = true;
		
		for (int nxt : tree.get(v)) {
			// 노드를 방문하지 않았을 경우
			if (!isVisit[nxt]) {
				// 부모 노드  
				ans[nxt] = v;
				
				dfs(nxt);
			}
		}
	}
}
