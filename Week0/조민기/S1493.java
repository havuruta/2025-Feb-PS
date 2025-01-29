package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            System.out.println("#"+t+" "+locTopoint(new int[] {pointToLoc(p)[0]+pointToLoc(q)[0],pointToLoc(p)[1]+pointToLoc(q)[1]}));
        }
    }

    static int[] pointToLoc(int N){
        int row = (int) ((-1 + Math.sqrt(1 + 8 * (N - 1))) / 2);
        int rowPoint = (row*row+row)/2;

        return new int[]{N-rowPoint,row+2-N+rowPoint};
    }

    static int locTopoint(int[] location){
        int x = location[0];
        int y = location[1];
        int n = Math.abs(y+x)-2;
        return (n*n+n)/2+x;
    }
}
