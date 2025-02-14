package hyochang;

import java.io.IOException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10824 {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	String a = st.nextToken();
    	String b = st.nextToken();
    	String c = st.nextToken();
    	String d = st.nextToken();
    	
    	String ab = a+b;
    	String cd = c+d;
        //첫째 줄에 네 자연수 A, B, C, D가 주어진다. (1 ≤ A, B, C, D ≤ 1,000,000)
    	long ab_num=Long.parseLong(ab);//1,000,000,000,000,000(1경)
    	long cd_num=Long.parseLong(cd);//2,100,000,000(21억)넘어감
    	long ans = ab_num+cd_num;
    	bw.write(String.valueOf(ans));
    	bw.flush();
    	bw.close();
    }
}
