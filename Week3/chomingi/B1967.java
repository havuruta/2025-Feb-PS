package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1967 {
    static int n, farthestNode, farthestDist, start;
    static boolean[] visited;
    static List<Node>[] graph;

    static class Node{
        int n;
        int v;

        public Node(int n, int v){
            this.n = n;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        graph = new ArrayList[n+1];
        for (int i = 0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph[S].add(new Node(E, V));
            graph[E].add(new Node(S, V));
        }
        visited = new boolean[n+1];
        farthestDist = 0;
        farthestNode = 0;
        
        dfs(1,0);
        
        visited = new boolean[n+1];
        farthestDist = 0;

        dfs(farthestNode, 0);

        System.out.println(farthestDist);
    }



    static void dfs(int now, int cost){
        visited[now] = true;

        if (cost > farthestDist){
            farthestDist = cost;
            farthestNode = now;
        }

        for (Node next : graph[now]){
            if (visited[next.n]) continue;
            dfs(next.n, cost+next.v);
        }
        return;
    }
}
