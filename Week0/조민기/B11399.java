package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] atm = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .sorted()
                        .toArray();
        int res = 0;
        for (int i = 0; i<N; i++){
            res+=atm[i]*(N-i);
        }
        System.out.println(res);
    }
        
}
