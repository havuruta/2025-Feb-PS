package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S7964 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 항상 성립하는 케이스를 고려해보기
        for (int t = 1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int D = Integer.parseInt(st.nextToken());
            int[] map = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();
            
            int[] addMap = new int[map.length+1];
            addMap[0] = 1;
            System.arraycopy(map, 0, addMap, 1, map.length);
            int temp = 0;
            int res = 0;
            for (int i = 0; i<map.length+1; i++) {
                if (addMap[i]==1){
                    temp=0;
                }
                if (temp==D){
                    res++;
                    temp=0;
                }
                temp++;
            }
            System.out.println("#"+t+" "+res);
        }
        
    }
}
