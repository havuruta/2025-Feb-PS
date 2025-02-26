package chomingi;

import java.io.*;
import java.util.Arrays;

public class B10819 {
    static int N, max;
    static int[] arr; 
    static int[] result;
    static boolean[] visited;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        visited = new boolean[N];
        result = new int[N];
        max = 0;
        dfs(0);
        System.out.println(max);
    }

    static void dfs (int depth){
        if (depth == N){
            int temp = 0;
            for (int i = 0; i < N - 1; i++){
                temp += Math.abs(result[i] - result[i + 1]);
            }
            max = Math.max(max, temp);
            return;
        }

        for (int n = 0; n<N; n++){
            if (!visited[n]){
                visited[n] = true;
                result[depth] = arr[n];
                dfs(depth + 1);
                visited[n] = false;
            }
        }
    }
}
