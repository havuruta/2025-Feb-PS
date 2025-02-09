package 조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

// B1920.java
// 문제 1920: 수 찾기 - 배열 내 특정 정수의 존재 여부 확인.
public class B1920 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        Set<String> numbers = new HashSet<>();
        for (int n = 0; n<N; n++){
            numbers.add(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int m = 0; m<M; m++){
            sb.append((numbers.contains(st.nextToken())) ? 1 : 0).append("\n");
        }
        System.out.println(sb.toString());
    }
}
