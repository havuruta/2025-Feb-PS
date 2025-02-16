package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class B1259 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // reverse
        while (true) {
            String word = br.readLine();
            if (word.length()==1 && word.equals("0")) break;
            if (word.equals(new StringBuffer(word).reverse().toString())) System.out.println("yes");
            else System.out.println("no");
        }
    }

    // 인덱스 접근 구현
    //     while (true) {
    //         String word = br.readLine();
    //         boolean isPalindrome = true;
    //         if (word.length()==1 && word.equals("0")) break;
    //         for (int i = 0; i<word.length()/2; i++){
    //             if (word.charAt(i)==word.charAt(word.length()-i-1)) continue;
    //             else {
    //                 isPalindrome = false;
    //             }
    //         }
    //         if (isPalindrome) System.out.println("yes");
    //         else System.out.println("no");
    //     }
    // }
}
