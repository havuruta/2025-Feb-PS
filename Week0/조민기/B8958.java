package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B8958 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        // 마지막에 놓여있는 연속 자리수도 확인
        for (int t = 0; t<TC; t++){
            String word = br.readLine();
            int acm = 0;
            int res = 0;
            for(int i = 0; i<word.length(); i++){
                if (word.charAt(i)=='O'){
                    acm++;
                } else {
                    res+=(acm*acm+1*acm)/2;
                    acm = 0;
                }
            }
            res+=(acm*acm+1*acm)/2;
            System.out.println(res);
        }
    }
}
