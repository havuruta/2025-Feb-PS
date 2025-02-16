import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1259 {

    public static void main(String[] args) throws IOException {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine().trim();

        // 0을 입력 받을 때 까지 반복.
        while(!str.equals("0")) {

            // 받은 문자열 캐릭 배열로 바꿈.
            char[] charArr = str.toCharArray();
            
            // flag 세우고 회문인지, 아닌지 체크.
            boolean flag = true;

            //양쪽 인덱스부터 줄여오면서 보는거임.
            for(int i = 0; i<charArr.length/2; i++) {
                if(charArr[i] !=  charArr[charArr.length-1-i]) {
                    // 이때 같지않다? 그럼 회문이 아닌데~~~ 어쩌지~~~ 
                    flag = false;
                    break;
                }
            }
            // 글서 회문이면 Yes 출력
            if(flag) {
                sb.append("yes").append("\n");
            } else {
                // 아니면 No 출력
                sb.append("no").append("\n");
            }
            //다음 줄 read
            str = br.readLine();
        }
        // 출력
        bw.write(sb.toString());
        bw.flush();
    }
    
}
