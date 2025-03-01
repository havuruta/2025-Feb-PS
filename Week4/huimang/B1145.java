package Week4.problem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1145 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] numbers = new int[5];
        
        // 5개의 수를 일단 입력 받음.
        for(int i = 0; i<5; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        // 1부터 적어도 3개 이상의 수로 나누어지는 수를 찾을꺼임.
        int num = 1;
        while(true) {
            int count = 0;
            // 0번부터 5번까지 체크를 하면서 count 증가
            if(num % numbers[0] == 0) {
                count++;
            }
            if(num % numbers[1] == 0) {
                count++;
            }
            if(num % numbers[2] == 0) {
                count++;
            }
            if(num % numbers[3] == 0) {
                count++;
            }
            if(num % numbers[4] == 0) {
                count++;
            }

            // 3개 이상이면 더 볼 가치도 없음.
            if(count >=3) {
                break;
            }

            num++;
        }
        // 찾은 수 출력 해 줌.
        bw.write(String.valueOf(num));
        bw.flush();
        bw.close();


    }
}
