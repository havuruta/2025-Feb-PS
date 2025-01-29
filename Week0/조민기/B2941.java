package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2941 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // shortcut 
        System.out.println(br.readLine().replaceAll("c=|c-|dz=|d-|lj|nj|s=|z=", " ").length());
        
        // 노가다. 
        // String word = br.readLine()+"0000";
        
        // int i = 0;
        // int res = 0;
        // while(i<word.length()){
        //     if ((word.charAt(i) == 's' && word.charAt(i+1) == '=') ||
        //      (word.charAt(i) == 'l' && word.charAt(i+1) == 'j') ||
        //      (word.charAt(i) == 'n' && word.charAt(i+1) == 'j') || 
        //      (word.charAt(i) == 'z' && word.charAt(i+1) == '=') ||
        //      (word.charAt(i) == 'c' && word.charAt(i+1) == '=') ||
        //      (word.charAt(i) == 'c' && word.charAt(i+1) == '-') ||
        //      (word.charAt(i) == 'd' && word.charAt(i+1) == '-')) {
        //         i+=2;
        //         res++;
        //     } else if (word.charAt(i) == 'd' && word.charAt(i+1) == 'z' && word.charAt(i+2) == '=') {
        //         i+=3;
        //         res++;
        //     } else {
        //         if (word.charAt(i) == '0') break;
        //         res++;
        //         i++;
        //     }
        // }
        // System.out.println(res);
    }
}
