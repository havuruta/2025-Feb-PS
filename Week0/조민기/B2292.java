package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2292 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        //1 2 8 20 38 62 ..
        // 1 6 12 18 24 ..
        // 1 2 3 4
        int res = 0;
        if (N<=2){
            res = N;
        } else {
            res = (int) Math.floor((0.5+Math.sqrt((float) N/3-(float)5/12)))+1;
        }

        System.out.println(res);
    }

}
