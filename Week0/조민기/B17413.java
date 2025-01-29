package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B17413 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        boolean isTag = false; 
        // 조건 분기 제대로 확인하기
        for (int i = 0; i<word.length(); i++){
            if (word.charAt(i)=='<'){
                res.append(new StringBuilder(temp).reverse().toString());
                isTag = true;
                temp = new StringBuilder("<");
            } else if (word.charAt(i)=='>'){
                isTag=false;
                temp.append(">");
                res.append(temp);
                temp = new StringBuilder();
            } else if (!isTag && word.charAt(i)==' '){
                res.append(new StringBuilder(temp).reverse().toString());
                res.append(" ");
                temp = new StringBuilder();
            } else {
                temp.append(word.charAt(i));
            }
        }
        res.append(new StringBuilder(temp).reverse().toString());
        System.out.println(res.toString());
    }
}
