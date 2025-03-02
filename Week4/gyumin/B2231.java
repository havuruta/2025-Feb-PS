package Week4.gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int input = Integer.parseInt(br.readLine());
        int res = input;
        
        // 이미 냅다 더해버린 건 어떻게 할 방법이 없음
        for(int i = 1; i < input; i++) {
        	int temp = i;
        	int sum = temp;
        	while(temp != 0) {
        		sum += temp % 10;
        		temp /= 10;
        	}
        	// 계산 결과가 입력과 같으면 i는 input의 생성자
        	if(input == sum) {
        		// 제일 작은거 찾으라고 했으니까
        		res = Math.min(i, res);
        	}
        }
        
        if(res == input) {
        	res = 0;
        }
        
        bw.write(res+"");
        bw.flush();
        
        bw.close();
        br.close();
    }
}
