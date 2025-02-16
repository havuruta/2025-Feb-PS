package chomingi;

import java.io.*;
import java.io.IOException;

public class B1157 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine().toUpperCase();  // 전체 대문자 변환
        int[] count = new int[26];
        for (int i = 0; i < word.length(); i++) {
            count[word.charAt(i) - 'A']++;
        }
        int max = 0, idx = -1;
        boolean duplicate = false;
        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                idx = i;
                duplicate = false;
            } else if (count[i] == max) {
                duplicate = true;
            }
        }
        System.out.println(duplicate ? "?" : (char)(idx + 'A'));
    }
}
