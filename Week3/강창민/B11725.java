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

public class B11725 {
	
	
	static List<List<Integer>> graph;
	
	//각 노드별 조상 저장배열
	static int[] mama;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		//0번 인덱스 버리고 노드번호 = 인덱스
		mama = new int[N+1];
		graph = new ArrayList<>();
		visited = new boolean[N+1];
		
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		//간선 입력받기
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			
			graph.get(node1).add(node2);
			graph.get(node2).add(node1);
		}
		
		//자식노드 정렬
		for(int i = 1; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		
		//조상찾기
		findMama(1);
		
		
		for(int i = 2; i < mama.length; i++) {
			bw.write(mama[i] + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	static void findMama(int v) {
		
		visited[v] = true;
		
		for(int child : graph.get(v)) {
			if(!visited[child])  {
				//조상을 찾앗으니 조상 배열에 값 추가
				mama[child] = v;
				
				findMama(child);
			}
		}
	}
}
