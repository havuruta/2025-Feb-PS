import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
	static int N, M, V;
	static int[][] arr;
	static boolean[] visited;
	static BufferedReader br;
	static BufferedWriter bw;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점(node)의 개수
		M = Integer.parseInt(st.nextToken()); // 간선(edge)의 개수
		V = Integer.parseInt(st.nextToken()); // 탐색을 시작할 정점의 번호

		// 정점 번호는 1 ~ N 까지 -> 배열의 크기: N + 1
		arr = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			// 양방향
			arr[node1][node2] = 1;
			arr[node2][node1] = 1;
		}

		visited = new boolean[N + 1]; // 방문 여부
		DFS(V);
		bw.newLine();

		visited = new boolean[N + 1]; // 방문 여부
		BFS(V);

		br.close();
		bw.flush();
		bw.close();
	}

	// dfs -> 깊이 우선 탐색 (재귀)
	public static void DFS(int V) throws IOException {
		visited[V] = true; // 헤딩 노드의 방문 여부 체크
		bw.write(V + " ");
		// V(탐색을 시작할 정점 번호)가 정점의 총 개수보다 클 수 없음
		if (V > arr.length - 1) {
			return;
		}

		for (int node = 1; node < arr.length; node++) {
			if (arr[V][node] == 1 && visited[node] == false) {
				DFS(node);
			}
		}
	}

	// bfs -> 너비 우선 탐색 (큐)
	public static void BFS(int V) throws IOException {
		Queue<Integer> queue = new LinkedList<>();

		queue.add(V);
		visited[V] = true;
		bw.write(V + " ");

		while (!queue.isEmpty()) {
			int tmp = queue.poll();
			for (int node = 1; node < arr.length; node++) {
				if(arr[tmp][node] == 1 && visited[node] == false) {
					queue.add(node);
					visited[node] = true;
					bw.write(node + " ");
				}
			}
		}
	}
}
