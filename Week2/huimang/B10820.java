

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class B10820 {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

    
        String str = br.readLine();
        // 입력이 들어오지 않을 때 까지 반복.
        while(str != null) {
            
            // 캐릭 배열로 변환
            char[] charArr = str.toCharArray();
            // 각각 대문자 소문자 숫자 공백을 셀 변수 선언
            int large = 0;
            int small = 0;
            int number = 0;
            int space = 0;
            // 해당 조건에 맞게끔 변수 증가연산
            for(int i = 0; i<charArr.length; i++) {
                if(charArr[i] >='A' && charArr[i] <='Z') {
                    large++;
                } else if(charArr[i] >= 'a' && charArr[i] <='z') {
                    small++;
                } else if(charArr[i]>='0' && charArr[i] <='9') {
                    number++;
                } else {
                    space++;
                }
            }
            // 결과 빌더에 추가
            sb.append(small).append(" ").append(large).append(" ").append(number)
            .append(" ").append(space).append("\n");
            // 새 라인 입력
            str = br.readLine();
        }
        // 출력
        bw.write(sb.toString().trim());
        bw.flush();
    }
}
