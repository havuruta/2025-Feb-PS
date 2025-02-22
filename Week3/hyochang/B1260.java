package hyochang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class B1260 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//정점(노드)의 수
		int m = sc.nextInt();//간선의 수
		int v = sc.nextInt();// 시작점
		int[][] arr = new int[n + 1][n + 1];//이렇게 하면 -1 안해도됨

		for (int i = 0; i < m; i++) {//두 간선이 연결됨을 표시하기 위해 1로 처리
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
//DFS의 경우 스택에서 뺄 때 방문처리를
//BFS의 경우 큐에 넣을 때 방문처리를 한다.

//BFS 스택안에 4-3-2-1순으로 들어가있다고 생각해보면 
//4가 나왓는데 3에 이미 방문처리가 되어있다면 3을 스킵하게 됨
		Stack<Integer> stack = new Stack<Integer>();//DFS를 위한 스택
		boolean[] stackvisited = new boolean[n + 1];//방문 여부를 확인할 배열
		stack.add(v);//시작점
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			if (stackvisited[cur])//방문햇다면
				continue;//넘김
			else
				stackvisited[cur]=true;{//방문처리
			System.out.print(cur + " ");//빼면 출력
			for (int i = n; i >= 1; i--) {
				if (arr[cur][i] == 1 && stackvisited[i] == false) {//지금 뽑은 수에 있는 행에 있는 1로 적힌 수+방문안햇으면
					stack.add(i);//추가
				}}
			}
		}

		System.out.println();
//BFS는 넣은 순서대로 나와야하기때문에 넣을 떄 방문처리를 한다.
		Queue<Integer> que = new LinkedList<Integer>();//BFS를 위한 큐
		boolean[] quevisited = new boolean[n + 1];//방문여부를 확인할 배열
		que.add(v);//시작점
		quevisited[v] = true;//방문처리
		while (!que.isEmpty()) {
			int cur = que.poll();
			System.out.print(cur + " ");//빼면 출력
			for (int i = 1; i <= n; i++) {
				if (arr[cur][i] == 1 && quevisited[i] == false) {//스택과 동일한 기준으로
					que.add(i);
					quevisited[i] = true;
				}
			}
		}

	}

}