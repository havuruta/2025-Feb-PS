package chomingi;

import java.io.*;
import java.util.StringTokenizer;

public class B10971 {
    static int N;
    static int[][] arr;
    static boolean[] visited;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visited = new boolean[N+1];
        min = Integer.MAX_VALUE;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i, 0, 1);
            visited[i] = false;
        }
        
        System.out.println(min);
    }

    static void dfs(int start, int now, int sum, int cnt) {
        if (cnt == N) { // 모든 도시 방문 후
            if (arr[now][start] != 0) { // 출발 도시로 돌아갈 수 있다면
                min = Math.min(min, sum + arr[now][start]);
            }
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && arr[now][i] != 0) {
                visited[i] = true;
                dfs(start, i, sum + arr[now][i], cnt + 1);
                visited[i] = false;
            }
        }
    }
    
}
