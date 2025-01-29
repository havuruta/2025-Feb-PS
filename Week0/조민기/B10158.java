package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10158 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        p = (p+t)%(w*2);
        q = (q+t)%(h*2);
        // 역방향 고려
        if (p>w) p = 2*w-p;
        if (q>h) q = 2*h-q;
        // 입사각 반사각 - 시간초과
        // int[] direction = {1,1};
        // while (t>0) {
        //     p = p+direction[0];
        //     q = q+direction[1];

        //     if (p == 0 || p == w) direction[0]*=-1;
        //     if (q == 0 || q == h) direction[1]*=-1;

        //     t--;
        // }

        System.out.println(p+" "+q);
    }
}
