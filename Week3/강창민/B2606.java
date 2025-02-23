package Week3.강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B2606 {
	
	//방문처리 배열
	static boolean[] virus;
	static List<List<Integer>> graph = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//컴퓨터의 수 (노드)
		int computers = Integer.parseInt(br.readLine());
		
		//연결된 컴퓨터 쌍 (간선)
		int link = Integer.parseInt(br.readLine());
		
		virus = new boolean[computers+1];
		
		//그래프 리스트 초기화
		for(int i = 0; i <= computers; i++) {
			graph.add(new ArrayList<>());
		}
		
		//간선 입력받기
		for(int i = 0; i < link; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			graph.get(num1).add(num2);
			graph.get(num2).add(num1);
		}
		//노드 정렬
		for(int i = 1; i <= computers; i++) {
			Collections.sort(graph.get(i));
		}
		
		dfs(1);
		
		int count = 0;
		for(boolean isVirus : virus) {
			if(isVirus) count++;
		}
		
		bw.write(String.valueOf(count-1));
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void dfs(int node) {
		//방문했으면 호출한 곳으로
		if(virus[node]) {
			return;
		}
		//안했었으면 방문처리
		virus[node] = true;
		
		//더 깊은 노드가 있으면 탐
		for(int i = 0; i < graph.get(node).size(); i++) {
			dfs(graph.get(node).get(i));
		}
		
		
	}
}
