package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1244 {
    static boolean[] switches;
    static int S;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = Integer.parseInt(br.readLine());
        switches = new boolean[S];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i<S; i++){
            switches[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        int P = Integer.parseInt(br.readLine());
        // 100*100 이므로 완탐
        for (int s = 0; s<P; s++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());
            if (sex==1) {
                boy(idx);
            } else {
                girl(idx);
            }
        }
        
        for (int i = 0; i < switches.length; i++) {
            System.out.print((switches[i] ? "1" : "0") + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    private static void toggle(int N){
        if (switches[N]){
            switches[N] = false;
        } else {
            switches[N] = true;
        }
    }

    private static void boy(int N){
        for (int i = N-1; i<S; i+=N){
            toggle(i);
        }
    }

    private static void girl(int N){
        int left = N-2;
        int right = N;
        toggle(N-1);
        while (left>=0 && right<S && switches[left]==switches[right]) {
            toggle(left);
            left--;
            toggle(right);
            right++;
        }
    }
}

// 메모리 시간
//14164	108