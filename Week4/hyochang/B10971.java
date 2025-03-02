package hyochang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B10971 {

	static int n;// 조합갯수로 필요하니 위로
	static int[][] city;
	static List<int[]> order;
	// 여행요금
	// 한번씩 방문 방문하면 다른 동네로가야함
	// 특별한 경우가 없으니 모든 경우 탐색

	// 도시 순서 조합? 의미없을듯? 애초에 모든 경우를 탐색해보니까?->갓던도시는 안가니까 boolean필요
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		city = new int[n][n];
		visited = new boolean[n];
		order = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				city[i][j] = sc.nextInt();
			}
		}
		permute(0, new int[n]);
		int min = Integer.MAX_VALUE;
		for (int[] c : order) {
			min = Math.min(min, cal(c));
		}
		System.out.println(min);

	}

	static int cal(int[] perm) {
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (city[perm[i - 1]][perm[i]] == 0) {//0인 조합은 가면 안되는 거니까 max로 반영안되게
				return Integer.MAX_VALUE;
			}
			sum += city[perm[i - 1]][perm[i]];
		}
		if (city[perm[n - 1]][perm[0]] == 0) {//마지막도시->시작도시도 확인하고 더하기 
			return Integer.MAX_VALUE;
		} else {
			return sum + city[perm[n - 1]][perm[0]];
		}
	}

	static void permute(int cur, int[] perm) {
		if (cur == n) {// n개 조합을 뽑으니까
			order.add(perm.clone());// 다 채운 조합은 리스트
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				perm[cur] = i;
				permute(cur + 1, perm);
				visited[i] = false;
			}
		}
	}
}