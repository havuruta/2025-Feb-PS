package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class B2606 {
    static List<List<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int computer = Integer.parseInt(br.readLine());
        int network = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        visited = new boolean[computer + 1];
        int count = 0;

        for (int i = 0; i <= computer; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < network; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // dfs(1);
        bfs(1);
        for (int i = 2; i <= computer; i++) {
            if (visited[i]) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int neighbor : graph.get(start)) {
            if (!visited[neighbor]) {
                dfs(neighbor);
            }
        }
    }

    public static void bfs(int start) {
        visited[start] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }
}