package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2999 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String message = br.readLine();
        int messageLen = message.length();
        int start = (int) Math.floor(Math.sqrt(messageLen));

        int r=0, c =0;
        for (int i = start; i>0; i--){
            if (messageLen%i==0){
                r=i;
                c=messageLen/i;
                break;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int j = 0; j<r; j++){
            for (int k = 0; k<c; k++){
                res.append(message.charAt(j+k*r));
            }
        }

        System.out.println(res.toString());
    }
}
