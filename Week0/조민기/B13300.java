package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13300 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        //F,M/grade
        int[][] cnt = new int[2][7];
        int res = 0;
        for (int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            // 새로운 방 확장 카운팅
            if (cnt[S][Y]==0){
                res++;
            }
            cnt[S][Y]++;
            // 카운터 리셋
            if (cnt[S][Y]==K){
                cnt[S][Y] = 0;
            }
        }
        System.out.println(res);
    }
    
}
