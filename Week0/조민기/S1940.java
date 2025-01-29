package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int dist = 0;
            int vel = 0;
            for (int n = 0; n<N; n++){
                StringTokenizer st = new StringTokenizer(br.readLine());
    
                int cmd = Integer.parseInt(st.nextToken());
                if (cmd==0) {
                    dist+=vel;
                    continue;
                }
                int acc = Integer.parseInt(st.nextToken());

                // 최소 속도 보장
                if (cmd==2) acc*=-1;
                vel = Math.max(vel+acc,0);
                dist+=vel;
            }
            System.out.println("#"+t+" "+dist);

        }
    }
}
