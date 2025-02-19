

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10798 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        
        String[][] str = new String[5][];
        

        // 배열 초기화
        for(int i = 0; i<5; i++) {
            str[i] = br.readLine().split("");
        }
        
        // 열우선 순회 -> 열 고정 행 순회이니 열의 최대 길이만큼 반복.
        for(int i = 0; i<15; i++) {


            // 열의 최대 길이 = 이 문제에서는 5이지만, str의 길이만큼 반복.
            for(int j = 0; j<str.length; j++) {
                // 근데 i가 해당 열의 최대 길이만큼 벗어난다? 그럼 그냥 씹어버림.
                if(i>=str[j].length) {
                    continue;
                }
                // 출력해야하니까 여기 찍음.
                sb.append(str[j][i]);
            }

        }
        bw.write(sb.toString());
        bw.flush();
        
    }
}
