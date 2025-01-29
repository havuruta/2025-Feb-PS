package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4698 {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        // 에라토스텔레스의 체 (사실 소수의 원리로 접근해도됌. 이름은 항상 나중에 붙는다. 겁먹지말기)
        for (int i = 2; i<1000001; i++){
            if (!isPrime[i]) continue;
            for (int j = i*2; j<1000001; j+=i){
                isPrime[j] =false;
            }
        }

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Character D = st.nextToken().charAt(0);
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            int res = 0;
            for (int i = A; i<=B; i++){
                if (isPrime[i]){
                    String now = String.valueOf(i);
                    for (int n = 0; n<now.length(); n++){
                        if (now.charAt(n) == D){
                            res++;
                            break;
                        }
                    }
                }
            }

            System.out.println("#"+t+" "+res);
        }
    }
}
