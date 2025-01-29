package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2810 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String sits = br.readLine();
        int i = 0;
        int res = 1;
        // L 인경우 2칸 
        while (i<sits.length()) {
            if (sits.charAt(i)=='L') i+=2;
            else i++;
            res++;
        }

        System.out.println(Math.min(res, N));
    }
}
