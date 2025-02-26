package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class B14888 {
    static int N, max, min;
    static int[] arr;
    static int[] operators;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        //중복이 특정한 개수만큼 허용되고 순서가 있는 순열

        dfs(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int result){
        if (depth == N){
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        for (int i = 0; i<4; i++){
            if (operators[i] > 0){
                operators[i]--;
                dfs(depth+1, calculate(result, arr[depth], i));
                operators[i]++;
            }
        }
    }

    static int calculate(int res, int num, int op){
        switch(op){
            case 0:
                return res + num;
            case 1:
                return res - num;
            case 2:
                return res * num;
            case 3:
                if (res<0) return -(-res / num);
                return res / num;
        }
        return 0;
    }
}
