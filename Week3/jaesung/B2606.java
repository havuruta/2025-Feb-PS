package Week3.jaesung;

/*
 문제 : 2606(바이러스)
 시간 : 192ms
 풀이 : 1번 컴퓨터부터 bfs 혹은 dfs를 통해 1번에서 도달 가능한 컴퓨터 개수를 파악.
 */

import java.util.Scanner;
import java.util.Stack;

public class Problem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int v = sc.nextInt();
		
		int[][] graph = new int[v+1][v+1];
		boolean[] isVisit = new boolean[v+1];
		
		int e = sc.nextInt();
		for (int i = 0; i < e; i++) {
			int st = sc.nextInt();
			int en = sc.nextInt();
			
			graph[st][en] = 1;
			graph[en][st] = 1;			
		}
		
		Stack<Integer> st = new Stack<>();
		
		st.push(1);
		
		int ans = 0;
		while (!st.isEmpty()) {
			int cur = st.pop();
			
			if (isVisit[cur]) {
				continue;
			}
			
			isVisit[cur]= true;
			++ans;
			
			for (int i = 1; i < graph[cur].length; i++) {
				if (isVisit[i]) {
					continue;
				}
				
				if (graph[cur][i] == 1) {
					st.push(i);
				}
			}
		}
		
		System.out.println(ans-1);
	}
}
