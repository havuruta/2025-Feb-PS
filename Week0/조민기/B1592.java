package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1592 {
    static int N, M, L;
    static boolean isOver;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int now = 0;
        arr[now]++;
        int res = 0;

        while (true) {
            if (arr[now]==M) break;
            res++;

            if (arr[now]%2 == 1){
                now = (now+L)%N;
            } else {
                now = (now-L+N)%N;
            }
            arr[now]++;
        }
        
        System.out.println(res);
    }
}
