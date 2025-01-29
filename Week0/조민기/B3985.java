package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B3985 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int L = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int expectMax = 0, expectIdx = 0;
        int realMax=0, realIdx=0;
        boolean[] real = new boolean[L];
        // 인덱스에 유의
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int expectNow = end-start+1;
            if (expectNow>expectMax){
                expectMax = expectNow;
                expectIdx = i;
            }
            
            int temp = 0;
            for (int j = start-1; j<=end-1; j++){
                if (!real[j]){
                    temp++;
                    real[j] = true;
                }
            }
            if (temp>realMax){
                realMax = temp;
                realIdx = i;
            }
        }
        System.out.println(expectIdx+1);
        System.out.println(realIdx+1);
    }
}
