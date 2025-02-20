package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1260 {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        StringBuilder sb = new StringBuilder();

        for (List<Integer> l : graph){
            Collections.sort(l);
        }

        visited = new boolean[N+1];
        visited[V] = true;

        dfs(V, sb);
        System.out.println(sb.toString());
        bfs(V);
    }

    static void bfs(int now){
        visited = new boolean[N+1];
        visited[now] = true;
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(now);

        while (!queue.isEmpty()) {
            int n = queue.poll();
            sb.append(n).append(" ");
            for (int next : graph[n]){
                if (visited[next]) continue;
                visited[next] = true;
                queue.add(next);
            }
        }

        System.out.println(sb.toString());
    }

    static void dfs(int now, StringBuilder sb){
        sb.append(now).append(" ");
        for(int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next,sb);
            }
        }
    }


}
