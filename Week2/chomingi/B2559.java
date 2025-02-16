package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2559 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        // 누적합
        int[] prefix = new int[N+1];
        for (int n = 1; n<=N; n++){
            prefix[n] = prefix[n-1]+Integer.parseInt(st.nextToken());
        }

        int res = Integer.MIN_VALUE;
        for (int i = K; i<=N; i++){
            res = Math.max(res, prefix[i]-prefix[i-K]);
        }

        // 슬라이딩 윈도우
        // int sumOfTemperature = 0;

        // for (int i = 0; i<K; i++) sumOfTemperature += temp[i];

        // int res = sumOfTemperature;

        // for (int i = 1; i<=N-K; i++){
        //     sumOfTemperature-=temp[i-1];
        //     sumOfTemperature+=temp[i+K-1];
        //     res = Math.max(sumOfTemperature, res);
        // }

        System.out.println(res);
    }
}
