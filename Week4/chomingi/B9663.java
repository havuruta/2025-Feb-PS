package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9663 {

    static int res, N;
    static boolean[] colCheck, lbrtCheck, ltrbCheck;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        colCheck = new boolean[N];
        // y+x
        lbrtCheck = new boolean[2*N-1];
        // -y+n-1+x
        ltrbCheck = new boolean[2*N-1];

        putQueen(0);

        System.out.println(res);
    }

    static void putQueen(int r){
        if(r == N){
            res++;
            return;
        }
        for (int c = 0; c<N; c++){
            if (colCheck[c] || lbrtCheck[r+c] || ltrbCheck[-r+N-1+c]) continue;
            colCheck[c] = lbrtCheck[r+c] = ltrbCheck[-r+N-1+c] = true;
            putQueen(r+1);
            colCheck[c] = lbrtCheck[r+c] = ltrbCheck[-r+N-1+c] = false;
        }
        return;
    }

    // 스터디 예정 : N이 15 이하는 비트마스킹 사용
    // static int N;
    // static int[] col;
    // static int[] lTrB;
    // static int[] rTlB;

    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    //     N = Integer.parseInt(br.readLine());

    //     col = new int[N];
    //     lTrB = new int[2 * N - 1];
    //     rTlB = new int[2 * N - 1];

    //     System.out.println(dfs(0, 0, 0, 0));
    // }

    // static int dfs(int r, int cols, int lTrBs, int rTlBs) {
    //     if (r == N) return 1;

    //     int cnt = 0;
    //     for (int c = 0; c < N; c++) {
    //         int colMask = 1 << c;
    //         int lTrBMask = 1 << (r + c);
    //         int rTlBMask = 1 << (r - c + N - 1);
    //         if ((cols & colMask) != 0 || (lTrBs & lTrBMask) != 0 || (rTlBs & rTlBMask) != 0) continue;
    //         cnt += dfs(r + 1, cols | colMask, lTrBs | lTrBMask, rTlBs | rTlBMask);
    //     }
    //     return cnt;
    // }
}
