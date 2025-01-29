package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2563 {
    public static void main(String[] args) throws IOException{
        boolean[][] black = new boolean[100][100];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // 100*100은 충분히 배열로 구성할만함
        for (int i = 0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j = 0; j<10; j++){
                for (int k = 0; k<10; k++) black[x+j][y+k] = true;
            }
        }
        int res = 0;
        for (int j = 0; j<100; j++){
            for (int k = 0; k<100; k++){
                if(black[j][k]) res++;
            }
        }

        System.out.println(res);
    }
}
