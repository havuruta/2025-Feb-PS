package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10820 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            int lower = 0, upper = 0, digit = 0, space = 0;
            
            for (char ch : line.toCharArray()) {
                if (Character.isLowerCase(ch)) lower++;
                else if (Character.isUpperCase(ch)) upper++;
                else if (Character.isDigit(ch)) digit++;
                else if (ch == ' ') space++;
            }
            
            System.out.println(lower + " " + upper + " " + digit + " " + space);
        }
    }
}
