package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class S7272 {
    static Map<Character, String> badEyes = new HashMap<Character, String>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        badEyes.put('B', "1");
        badEyes.put('A', "2");
        badEyes.put('D', "2");
        badEyes.put('O', "2");
        badEyes.put('P', "2");
        badEyes.put('Q', "2");
        badEyes.put('R', "2");
        int T = Integer.parseInt(br.readLine());
        // 항상 성립하는 케이스를 고려해보기
        for (int t = 1; t<=T; t++){
            String res = "SAME";
            String[] words = (br.readLine().split(" "));
            String prev = null;
            for (String word : words){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i<word.length(); i++){
                    sb.append(badEyes.getOrDefault(word.charAt(i), "3"));
                }
                String transformed = sb.toString();
                if (prev != null && !prev.equals(transformed)) {
                    res = "DIFF";
                }
                prev = transformed;
            }
            System.out.println("#"+t+" "+res);
        }
    }

}
