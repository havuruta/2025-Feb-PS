package Week3.강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
	
	//DFS BFS 방문 처리 배열
	static boolean[] visitedDFS;
	static boolean[] visitedBFS;
	
	static List<List<Integer>> graph = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		//정점의 수
		int N = Integer.parseInt(st.nextToken());
		//간선의 수
		int M = Integer.parseInt(st.nextToken());
		//시작 정점의 번호
		int V = Integer.parseInt(st.nextToken());
		
		//방문처리배열
		visitedDFS = new boolean[N+1];
		visitedBFS = new boolean[N+1];
		
		//리스트 초기화
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//노드 넣기
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}
		
		//빠른 순 정렬
		for(int i = 1; i <= N; i++) {
			Collections.sort(graph.get(i));
		}
		
		//dfs탐색, bfs탐색 
		dfs(V);
		sb.append("\n");
		bfs(V);
		
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int node) {
		//방문한 노드라면 호출한 곳으로 리턴
		if(visitedDFS[node]) {
			return;
		}
		//방문처리 + 순서 저장
		visitedDFS[node] = true;
		sb.append(node).append(" ");
		//해당 노드와 연결되는 다른 노드들 탐색
		for(int i = 0; i < graph.get(node).size(); i++) {
			dfs(graph.get(node).get(i));
		}
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		//시작노드 삽입, 방문처리
		queue.offer(start);
		visitedBFS[start] = true;
		
		//큐가 빌때까지
		while(!queue.isEmpty()) {
			//현재 노드 꺼내
			int node = queue.poll();
			sb.append(node).append(" ");
			
			//노드와 이어져 있는 다른 노드 탐
			for(int i = 0; i < graph.get(node).size(); i++) {
				//방문하지 않았으면 방문처리, 큐에 삽
				if(!visitedBFS[graph.get(node).get(i)]) {
					visitedBFS[graph.get(node).get(i)] = true;
					queue.offer(graph.get(node).get(i));
				}
			}
		}
	}
}
