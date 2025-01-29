package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class S4789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i<=T; i++){
            String handClap = br.readLine();
            int clap = 0;
            int res = 0;
            for (int j = 0; j<handClap.length(); j++){
                int diff = j-clap;
                if (diff>0){
                    clap+=diff;
                    res+=diff;
                }
                clap+=(handClap.charAt(j)-'0');
            }
            System.out.println("#"+i+" "+res);
        }
    }
}
