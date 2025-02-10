package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1212 {
    static int[] bin = {4,2,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();

        StringBuilder sb = new StringBuilder();
        if (word.equals("0")) System.out.println(0);
        // 구현 훨씬 빠름
        for (int i = 0; i<word.length(); i++){
            int now = word.charAt(i)-'0';
            for (int b : bin){
                if (now>=b){
                    now-=b;
                    sb.append(1);
                } else {
                    if(sb.length()==0) continue;
                    sb.append(0);
                } 
            }
        }

        // toBinaryString()
        // for (int i = 0; i<word.length(); i++){
        //         int now = word.charAt(i)-'0';
        //         String digits = String.format("%3s",Integer.toBinaryString(now)).replace(' ', '0');
        //         if (i == 0){
        //             int first = Integer.valueOf(digits);
        //             sb.append(first);
        //         } else sb.append(digits);
        //     }
        
        System.out.println(sb.toString());
    }
}

