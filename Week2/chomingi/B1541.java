package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1541 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] accu = br.readLine().split("-");
        
        
        StringBuilder sb = new StringBuilder();
        int res = 0;
        int temp = 0;

        for (int j = 0; j<accu.length; j++) {
            String outer = accu[j];
            String[] inner = outer.split("[+]");
            temp = 0;
            for (String i : inner){
                if (j == 0) temp += Integer.parseInt(i);
                else temp -= Integer.parseInt(i);
            }
            res+=temp;
        }

        System.out.println(res);
    }
}
