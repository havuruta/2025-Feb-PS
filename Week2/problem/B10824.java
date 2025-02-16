package problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10824 {    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	String a = st.nextToken();
    	String b = st.nextToken();
    	String c = st.nextToken();
    	String d = st.nextToken();
    	
    	String ab = a+b;
    	String cd = c+d;
    	long aa=Long.parseLong(ab);//1,000,000,000,000은
    	long cc=Long.parseLong(cd);// 약 21,000,000,00(INT 범위)
    	long ans = aa+cc;
    	bw.write(String.valueOf(ans));//문자열로 변환 후 출력
    	bw.flush();
    	bw.close();
    }
}