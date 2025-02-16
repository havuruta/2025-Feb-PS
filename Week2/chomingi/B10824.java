package chomingi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10824 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A1 = st.nextToken();
        String A2 = st.nextToken();
        
        String B1 = st.nextToken();
        String B2 = st.nextToken();

        System.out.println(Integer.parseInt(A1+A2)+Integer.parseInt(B1+B2));
    }
}
