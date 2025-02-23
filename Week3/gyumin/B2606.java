package Week3.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2606 {
	
	static int[][] graph;
	
	static int[] visited;
	
	// 여기선 DFS를 재귀적으로 구현
	private static int dfs(int start) {
		int count = 0;
		// 도착했으니까 방문처리
		visited[start] = 1;
		
		for(int i = 0; i < graph.length; i++) {
			if(graph[start][i] == 1 && visited[i] != 1) {
				// 다음 방문지가 있으니까 카운터를 올리고
				count++;
				// 재귀적으로 호출한 카운터의 값을 새로 더해줌
				count += dfs(i);
			}
		}
		
		// 계산 끝났으니까 리턴
		return count;
		
	}
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        
        graph = new int [n + 1][n + 1];
        
        for(int i = 0; i < m; i++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		// 입력받은 간선 정보를 저장
        		graph[a][b] = graph[b][a] = 1;
        }
        
        visited = new int [n + 1];
        int count = dfs(1);
        
        bw.write(count+"");
        bw.flush();
        
        br.close();
        bw.close();
        
    }
}
