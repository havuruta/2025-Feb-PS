
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class B1212 {
    public static void main(String[] args) throws IOException{
        // 가능하면 500ms 이내로 풀어봅시다.
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Long의 범위를 벗어나는.. 어마무시한놈... 그래서 BigInteger로 받는 방식이 있더라구요.
        String num = br.readLine().trim();
        BigInteger bigInteger =new BigInteger(num,8);

        // 바로 2진수로 쏴주면 풀림.. 근데 어케 500ms내로 ...??
        bw.write(bigInteger.toString(2));
        bw.flush();
    }
}

