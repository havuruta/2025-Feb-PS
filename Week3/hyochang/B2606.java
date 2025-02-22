package hyochang;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int point =sc.nextInt();
		int node = sc.nextInt();
		
		int[][] computer= new int[point+1][point+1];
		
		for(int i=0; i<node;i++) {//연결된 노드끼리 1로 바꾸어 주어 1인경우 해당 i나j로 이동
			int a= sc.nextInt();
			int b= sc.nextInt();
			computer[a][b]=1;
			computer[b][a]=1;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[point+1];//방문처리를 위한 배열
		queue.add(1);
		visited[1]=true;
		while (!queue.isEmpty()) {
			int cur=queue.poll();
			
			for(int i =1; i<point+1;i++) {
				if(computer[cur][i]==1&&!visited[i]) {//1이고 방문도 안햇다면
					queue.add(i);
					visited[i]=true;
				}
			}
		}
		int ans = 0;
		for(boolean a:visited) {//1에서 연결된 컴퓨터만 방문햇으므로 true 수만큼 +1
			if(a)
				ans++;
		}
		System.out.println(ans-1);//1이 감염시킨 컴퓨터 수이므로 1번 컴퓨터를 빼줌
	}
}