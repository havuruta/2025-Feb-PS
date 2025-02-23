package Week3.jaesung;

/*
 문제 : 17471(게리맨더링)
 시간 : 204ms
 풀이 : 백트래킹으로 각 구역을 두 그룹으로 나누는 모든 경우의 수를 확인하며 최소값 갱신
 두 그룹이 모두 존재할 때, bfs를 통해 각 그룹의 구역에 모두 접근 가능한지 체크.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem {
	static List<Integer>[] graph;
	static int N, total;
	static int[] popularity;
	static boolean[] selected;
	static int ans = 100000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		popularity = new int[N+1];
		graph = new ArrayList[N+1];
		selected = new boolean[N+1];
		
		// 인구 입력 및 전체 인구 합 저장
		for (int i = 1; i <= N; i++) {
			popularity[i] = sc.nextInt();
			total += popularity[i];
			graph[i] = new ArrayList<>();
		}
			
		// 그래프 입력
		for (int i = 1; i <= N; i++) {
			int edgeCount = sc.nextInt();
			
			for (int j = 0; j < edgeCount; j++) {
				int num = sc.nextInt();
				graph[i].add(num);
			}
		}
		
		divide(1);
		
		if (ans == 100000) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}
	
	// 백트래킹으로 그룹 분할
	static void divide(int idx) {
		// 그룹 분할 완료 후 체크
		if (idx > N) {
			List<Integer> groupA = new ArrayList<>();
			List<Integer> groupB = new ArrayList<>();
			
			// 그룹 체크 여부에 따라 그룹 분할
			for (int i = 1; i <= N; i++) {
				if (selected[i]) groupA.add(i);
				else groupB.add(i);
			}
			
			// 가능한 경우인지 체크
			// 1. 두 그룹 모두 하나 이상 포함
			if (!groupA.isEmpty() && !groupB.isEmpty()) {
				// 2. 두 그룹이 모두 접근 가능한가
				if (isConnected(groupA, true) && isConnected(groupB, false)) {
					int popA = 0;
					for (Integer num : groupA) popA += popularity[num];
					
					int popB = total - popA;
					
					// 모두 성립하는 경우 최소값 갱신
					ans = Math.min(ans, Math.abs(popA - popB));
				}
			}
			
			return;
		}
		
		// 백트래킹 수행
		selected[idx] = true;
		divide(idx + 1);
		selected[idx] = false;
		divide(idx + 1);
	}
	
	// 해당 그룹에 속한 노드로 모두 접근이 가능한지 체크
	static boolean isConnected(List<Integer> group, boolean isGroupA) {
		// bfs로 체크
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisit = new boolean[N+1];
		
		q.add(group.get(0));
		isVisit[group.get(0)] = true;
		
		// 연결 여부 판단 변수
		int count = 0;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			count++;
			
			for (int num : graph[cur]) {
				// 해당 노드를 방문하지 않았으며 노드가 현재 그룹에 속할 경우 노드 추가
				if (!isVisit[num] && selected[num] == isGroupA) {
					isVisit[num] = true;
					q.add(num);
				}
			}
		}
		
		// 리스트 크기만큼 탐색이 되었을 때 그룹 성립
		return count == group.size();
	}
}
