import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B10824 {
    public static void main(String[] args) throws IOException{
        
        // 입출력을 위한 리더, 라이터, 그리고 입력을 처리할 토크나이져.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 네 변수에 값을 집어넣고
        String a = st.nextToken(" ");
        String b = st.nextToken(" ");
        String c = st.nextToken(" ");
        String d = st.nextToken(" ");

        // 문제의 자연수 범위가 백만인데, 이거 두개 붙여버리면 짱 짱 커질 수 있어서 롱으로 두 문자열 합친 뒤 컨버팅
        long e = Long.parseLong(a+b);
        long f = Long.parseLong(c+d);

        // 출력해주면 꿑~
        bw.write(String.valueOf(e+f));
        bw.flush();


    }
}
