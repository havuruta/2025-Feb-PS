package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1037 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] row = new int[N];
        int[] col = new int[N];
        for (int i = 0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int temp = 0;
            for (int j = 0; j<N; j++){
                int now = Integer.parseInt(st.nextToken());
                temp+=now;
                col[j]+=now;
            }
            row[i] = temp;
        }

        int rowCnt = -1;
        int colCnt = -1;
        for (int n = 0; n<N; n++){
            if (row[n]%2==1) {
                if (rowCnt!=-1) {
                    System.out.println("Corrupt");
                    return;
                } else {
                    rowCnt = n+1;
                }
            }
            if (col[n]%2==1) {
                if (colCnt!=-1) {
                    System.out.println("Corrupt");
                    return;
                } else {
                    colCnt = n+1;
                }
            }
        }
        // OK 조건을 위한 -1 세팅
        if (rowCnt==-1 && colCnt==-1) System.out.println("OK");
        else System.out.println("Change bit ("+ rowCnt +","+ colCnt +")");
    }
}
