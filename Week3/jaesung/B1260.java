package Week3.jaesung;

/*
 문제 : 1260(DFS와 BFS)
 시간 : 540ms
 풀이 : 입력에 맞게 그래프를 구성하고 DFS와 BFS를 수행하며 현재 탐색 노드를 출력.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Problem {
	// 그래프 입력을 위한 인접 배열을 2차원 배열로 선언
	static int[][] graph;
	
	// 정점 방문 여부 확인 배열. 탐색 시 무한 루프 방지를 위해 사용.
	static boolean[] isVisit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int V = sc.nextInt();
		
		// 정점 개수만큼 배열을 생성
		// N+1을 크기로 정하는 이유 : 정점 번호가 1번부터 N번인 경우, 정점 번호를 인덱스로 사용하는 것이 편리하여 종종 사용
		// 선호에 따라 N or N + 1 사용 가능
		graph = new int[N+1][N+1];
		
		// 각 st정점에서 방문 가능한 en정점을 인접 배열에 추가
		for (int i = 0; i < M; i++) {
			int st = sc.nextInt();
			int en = sc.nextInt();
			
			// 문제에서 간선이 양방향이므로 양 정점에 모두 추가
			graph[st][en] = 1;
			graph[en][st] = 1;
		}
		
		// 탐색을 위해 방문 여부 배열 초기화
		isVisit = new boolean[N+1];
		// DFS(V);
		DFS_recur(V);
		
		System.out.println();
		
		// 탐색을 위해 방문 여부 배열 초기화
		isVisit = new boolean[N+1];
		BFS(V);
	}
	
	// BFS
	static void BFS(int v) {
		// 탐색 대상 정점을 삽입할 큐
		Queue<Integer> q = new LinkedList<>();
		
		// 시작 정점 삽입
		q.add(v);
		
		// 시작 정점 방문 처리
		isVisit[v] = true;
		
		// 큐가 빌 때까지(=연결된 모든 노드를 탐색할 때까지) 탐색 수행
		while (!q.isEmpty()) {
			// 현재 방문 정점 갱신 및 큐에서 제거
			int cur = q.poll();
			
			System.out.print(cur + " ");
			
			// 현재 방문 정점의 인접 정점을 순회하며 방문 가능 정점을 탐색
			for (int i = 1; i < graph[cur].length; i++) {
				// 이미 정점을 방문한 경우 방문하지 않음
				if (isVisit[i] == true) {
					continue;
				}
				
				// 방문할 수 없는 정점인 경우 방문하지 않음
				if (graph[cur][i] == 0) {
					continue;
				}
				
				// 방문하지 않은 경우
				// 해당 정점 방문 처리
				// 탐색 과정에서 방문 처리를 하지 않을 경우, 추가 구현이 없다면
				// 다음 방문 정점에서 중복 방문 처리를 하게 될 수 있으므로 주의
				isVisit[i] = true;
				
				// 큐에 정점 삽입
				q.add(i);
			}			
		}
		
		System.out.println();
	}
	
	// DFS(스택 사용)
	static void DFS(int v) {
		// 탐색 대상 정점을 삽입할 스택
		Stack<Integer> st = new Stack<>();
		
		// 시작 정점 삽입
		st.push(v);
		
		// 스택이 빌 때까지(=연결된 모든 노드를 탐색할 때까지) 탐색 수행
		while (!st.isEmpty()) {
			// 현재 방문 정점 갱신 및 스택에서 제거
			int cur = st.pop();
			
			// 이미 정점을 방문한 경우 탐색 수행하지 않음
			if (isVisit[cur]) {
				continue;
			}
			
			// 정점 방문 처리
			isVisit[cur] = true;
			
			System.out.print(cur + " ");
			
			// 현재 방문 정점의 인접 정점을 순회하며 방문 가능 정점을 탐색
			// 해당 문제에서는 정점 번호가 작은 것을 먼저 방문해야하기 때문에
			// 스택에 삽입되는 순서를 고려하여 역순으로 순회
			for (int i = graph[cur].length-1; i >= 0; i--) {
				// 이미 정점을 방문한 경우 방문하지 않음
				if (isVisit[i] == true) {
					continue;
				}
				
				// 방문할 수 없는 정점인 경우 방문하지 않음
				if (graph[cur][i] == 0) {
					continue;
				}
				
				// 방문하지 않은 경우
				// 스택에 정점 삽입
				st.add(i);
			}
		}
	}
	
	// DFS(재귀)
	static void DFS_recur(int v) {
		System.out.print(v + " ");
		
		// 정점 방문 처리
		isVisit[v] = true;
		
		// 현재 방문 정점의 인접 정점을 순회하며 방문 가능 정점을 탐색
		for (int i = 1; i < graph[v].length; i++) {
			// 이미 방문한 정점이거나 방문할 수 없는 정점인 경우 방문하지 않음
			if(isVisit[i] || graph[v][i] == 0) continue;
			
			// 방문하지 않은 경우
			// 해당 정점에 대한 재귀함수 호출
			DFS_recur(i);
		}
	}
}
