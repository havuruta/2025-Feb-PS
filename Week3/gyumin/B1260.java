package Week3.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1260 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][n];

		for (int i = 0; i < m; i++) {
			StringTokenizer input = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(input.nextToken()) - 1;
			int b = Integer.parseInt(input.nextToken()) - 1;
			
			// 입력받은 그래프의 간선관계를 표현하기 위한 작업
			arr[a][b] = arr[b][a] = 1;
		}
		
		// DFS는 스택을 활용하여 구현함
		// 스택의 후입 선출 구조를 활용해서 하위 레벨 요소를 먼저 탐색
		// 스택에서 하나씩 꺼내면서 상위 요소를 탐색하는 방향
		// 재귀 호출은 결국 시스템 스택을 이용하는 과정이기에 이 문제에서는 스택만을 활용해서 풀이함
		Stack<Integer> DFS = new Stack<>();
		// 방문한 요소를 재방문하지 않도록 처리
		// 실제 코드는 그 위치를 찍지만 이후 로직에서 출력되지 않게하여 논리적으로는 방문하지 않은 것으로 처리
		boolean[] visitedD = new boolean[n];
		int top = v;
		visitedD[top - 1] = true;
		DFS.push(top);
		sb.append(top + " ");

		while (!DFS.isEmpty()) {
			// 그 노드의 다음 방문 요소를 다 탐색하기 전 까진 스택에서 제거하면 안됨
			top = DFS.peek();
			boolean hasNext = false;

			for (int i = 0; i < n; i++) {
				if (arr[top - 1][i] == 1 && !visitedD[i]) {
					visitedD[i] = true;
					DFS.push(i + 1);
					sb.append((i + 1) + " ");
					hasNext = true;
					break;
				}
			}
			
			// 다 방문했으니까 버리기
			if (!hasNext) {
				DFS.pop();
			}
		}
		sb.replace(sb.length() - 1, sb.length(), "").append("\n");

		// BFS는 큐를 활용해서 구현함
		// 같은 레벨의 모든 요소를 먼저 탐색하고 그 다음 레벨로 넘어가기 때문에
		// 큐에 순서대로 차곡차곡 쌓고 앞에서부터 꺼내가면서 탐색을 진행함
		Queue<Integer> BFS = new ArrayDeque<>();
		// 방문한 요소를 재방문하지 않도록 처리
		// 실제 코드는 그 위치를 찍지만 이후 로직에서 출력되지 않게하여 논리적으로는 방문하지 않은 것으로 처리
		boolean[] visitedB = new boolean[n];
		int start = v;
		visitedB[start - 1] = true;
		BFS.add(v);

		while (!BFS.isEmpty()) {
			// 지금 가리키는 노드를 바로 큐에서 제거해도 됨
			start = BFS.remove();
			sb.append(start + " ");
			for (int i = 0; i < n; i++) {
				// 실제 코드도 방문하지 않는다면 굳이 여기서 if문으로 플래그 변수를 확인할 필요가 없음
				if (arr[start - 1][i] == 1 && !visitedB[i]) {
					// 다음에 찾아갈 큐를 저장
					visitedB[i] = true;
					BFS.add(i + 1);
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
	}

}
