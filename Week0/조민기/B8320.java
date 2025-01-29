package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B8320 {
    // 수학적 해석
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int res = 0;
        // 제곱근의 floor 까지 순회
        for (int i = 1; i<=(int) Math.floor(Math.sqrt(n)); i++){
            // -i+1 로 중복케이스 제거
            res+=((int) Math.floor(n/i)-i+1);
        }
        System.out.println(res);
    }
}
