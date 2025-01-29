package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2851 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int res = 0;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i<10; i++){
            int now = Integer.parseInt(br.readLine());
            if (diff >= Math.abs(100-(res+now))){
                diff = Math.abs(100-(res+now));
                res+=now;
            } else break;
        }

        System.out.println(res);
    }
}
