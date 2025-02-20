package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class B11725 {
    static int N;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N+1];
        visited[1] = true;

        Deque<Integer> queue = new ArrayDeque<>();

        queue.add(1);
        int[] parent = new int[N+1];

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int next : graph[now]){
                if (visited[next]) continue;
                parent[next] = now;
                visited[next] = true;
                queue.add(next);
            }
        }

        for (int i = 2; i<=N; i++) System.out.println(parent[i]);
    }
}
