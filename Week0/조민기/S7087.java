package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class S7087 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            Set<Character> firstLetters = new TreeSet<>(); // 자동 정렬되는 Set

            for (int n = 0; n < N; n++) {
                String word = br.readLine();
                firstLetters.add(word.charAt(0));
            }

            int now = 0;
            for (char c : firstLetters) {
                if (c - 'A' == now) {
                    now++;
                } else {
                    break;
                }
            }

            System.out.println("#" + t + " " + now);
        }
        
    }
}
