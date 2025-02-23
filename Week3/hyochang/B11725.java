import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class B11725 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		// int[][] 2차원 배열을 만들어 실행하면 메모리 초과 발생
		// 배열의 경우 초기값이 0으로 채워져있음->연결안된 노드도 0으로 표현
		// 리스트의 경우 연결된 값만 추가하면되기때문
		List<List<Integer>> tree = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			tree.add(new ArrayList<>());// 각 줄에 n만큼의 리스트를 생성
		}

		for (int i = 0; i < n - 1; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			tree.get(node1).add(node2);
			tree.get(node2).add(node1);
		}

		int[] ans = new int[n + 1];
//		findup(1, tree, ans);
		findup(tree, ans);
		for (int i = 2; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

	//BFS
	//1이 루트이므로 1을 넣고 시작
	static void findup(List<List<Integer>> tree, int[] check) {
		Queue<Integer> que = new LinkedList<>();
		que.add(1);
		check[1] = 1;
		while (!que.isEmpty()) {
			int cur = que.poll();

			for (int pre : tree.get(cur)) {
				if (check[pre] == 0) {
					check[pre] = cur;
					que.add(pre);
				}
			}
		}

	}
    // DFS
	// 부모찾기(해당 노드, 트리, 부모 체크)
//	static void findup(int cur, List<List<Integer>> tree, int[] check) {
//		for (int a : tree.get(cur)) {// 해당 노드에 연결된 모든 노드 호출
//			if (check[a] == 0) {// 체크 배열 값이 0=>방문하지 않음+부모를 못찾음
//				check[a] = cur;// 해당하는 부모를 넣음
//				findup(a, tree, check);// 부모 노드도 다시 재귀로
//			}
//		}
//	}
}