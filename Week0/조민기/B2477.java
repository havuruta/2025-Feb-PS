package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2477 {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] len = new int[6];

        int maxHeight = 0, maxWidth = 0;

        for (int i = 0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
            if (d<=2) maxWidth = Math.max(maxWidth, len[i]);
            else maxHeight = Math.max(maxHeight, len[i]);
        }

        // 긴변 두개 곱의 반대 모서리의 두 변의 곱
        for (int i = 0; i<6; i++) {
            if (len[i]+len[(i+1)%6] == maxHeight+maxWidth) {
                System.out.println((maxHeight*maxWidth-len[(i+3)%6]*len[(i+4)%6])*N);
                return;
            }
        }
    }
}
