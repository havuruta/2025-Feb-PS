package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/* B10971 외판원 순회2
 * N과 비용 행렬이 주어졌을 때, 가장 적은 비용을 들이는 외판원의 순회 여행 경로를 구하는 프로그램을 작성하시오.
 * 첫째 줄에 도시의 수 N이 주어진다. (2 ≤ N ≤ 10) 다음 N개의 줄에는 비용 행렬이 주어진다. 
 * 각 행렬의 성분은 1,000,000 이하의 양의 정수이며, 갈 수 없는 경우는 0이 주어진다. W[i][j]는 도시 i에서 j로 가기 위한 비용을 나타낸다.
 * 항상 순회할 수 있는 경우만 입력으로 주어진다.
 */

public class B10971 {

    static int N; //도시의 수
    static int[][] costs; //비용배열
    static int minCost = Integer.MAX_VALUE; //최소비용
    static boolean[] visited; //방문처리

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        costs = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                costs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            visited[i] = true; //첫 도시방문처리
            findMin(i, i, 1, 0);  
            visited[i] = false; //다시 취소
        }

        bw.write(minCost + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void findMin(int start, int current, int count, int cost) {
        if (cost >= minCost) { //이미 비용이 최소비용보다 크면 탈출
        	return;
        }

        if (count == N) { //길이가 꽉 찬경우
            if (costs[current][start] > 0) { // 돌아가는 경로가 존재하는 경우 
                minCost = Math.min(minCost, cost + costs[current][start]); //최소비용 계산
            }
            return;
        }

        for (int i = 0; i < N; i++) { 
            if (!visited[i] && costs[current][i] > 0) { //방문하지 않았고, 경로가 존재하는 경우
                visited[i] = true; //방문처리
                findMin(start, i, count + 1, cost + costs[current][i]); //재귀 가즈아
                visited[i] = false; //다시 방문취소
            }
        }
    }
}

