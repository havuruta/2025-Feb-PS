package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B3052 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 혹은 사이즈가 41인 배열에 +1 씩 해줘도된다.
        Map<Integer,Integer> restMap = new HashMap<>();
        for (int i = 0; i<10; i++){
            int now = Integer.parseInt(br.readLine());
            int rest = now%42;
            restMap.put(rest, restMap.getOrDefault(rest,0)+1);
        }

    System.out.println(restMap.keySet().size());
    }
}
