package Week3.jaesung;

/*
 문제 : 1967(트리의 지름)
 시간 : 3020ms
 풀이 : 트리의 각 노드에서 dfs를 수행하여 얻는 가중치의 합들 중 최댓값을 출력.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class node{
	// 연결된 노드 번호
	int arrival;
	// 가중치
	int weight;
	
	public node(int arrival, int weight) {
		this.arrival = arrival;
		this.weight = weight;
	}
}

public class Problem {
	static List<List<node>> tree = new ArrayList<>();
	static int ans;
	static int val;
	static boolean[] isVisit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		
		// 트리 입력
		for (int i = 0; i <= n; i++) {
			tree.add(new ArrayList<>());
		}
		
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			tree.get(v1).add(new node(v2, e));
			tree.get(v2).add(new node(v1, e));
		}
		
		// 모든 노드에 대해 dfs 수행
		isVisit = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			val = 0;
			dfs(i);
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	
	static void dfs(int cur) {
		for (node nxt : tree.get(cur)) {
			if (isVisit[nxt.arrival]) {
				continue;
			}
						
			// 최댓값 갱신
			isVisit[cur] = true;
			val += nxt.weight;
			ans = Math.max(ans, val);
			dfs(nxt.arrival);
			isVisit[cur] = false;
			val -= nxt.weight;
		}
	}
}
