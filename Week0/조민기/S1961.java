package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] res = new int[N][3*N+1];
            for (int y = 0; y<N; y++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int x = 0; x<N; x++){
                    int now = Integer.parseInt(st.nextToken()); 
                    res[x][N-1-y]=now;
                    res[N-1-y][2*N-1-x]=now;
                    res[N-1-x][2*N+y]=now;
                }
            }
            System.out.println("#"+t);
            for (int j = 0; j < N; j++){
                for (int i = 0; i < 3*N; i++){
                    System.out.print(res[j][i]);
                    if ((i+1)%N==0) System.out.print(" ");
                }
                System.out.println();
            }
        }

    }
    
}
