package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17609 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t<T; t++){
            String now = br.readLine();
            System.out.println(isPalindrome(now,0,now.length()-1));
        }
    }
    // 정해
    static int isPalindrome(String word, int start, int end){
        while (start<end) {
            if(word.charAt(start)==word.charAt(end)){
                start++;
                end--;
                continue;
            } else {
                if (isPalindrome(word, start+1, end)==0 || isPalindrome(word, start, end-1)==0){
                    return 1;
                }
                else return 2;
            }
        }
        return 0;
    }

    // 97퍼틀. 웨않됌?
    // static int isPalindrome(String word){
    //     int start = 0;
    //     int end = word.length()-1;

    //     int res = 0;
    //     boolean chance = true;
    //     while (start<end) {
    //         if(word.charAt(start)==word.charAt(end)){
    //             start++;
    //             end--;
    //             continue;
    //         } else if (chance==true) {
    //             if (start+1==end) return 1;
    //             if (word.charAt(start)==word.charAt(end-1)&& word.charAt(start+1)==word.charAt(end-2)){
    //                 start+=2;
    //                 end-=3;
    //             } else if (word.charAt(start+1)== word.charAt(end) && word.charAt(start+2)==word.charAt(end-1)){
    //                 start+=3;
    //                 end-=2;
    //             } else {
    //                 return 2;
    //             }
    //             chance = false;
    //             res = 1;
    //         } else return 2;
    //     }

    //     return res;
    // }
}
