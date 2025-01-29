package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B14696 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 카운팅 O(N)
        for (int i = 0; i < N; i++) {
            int[] aCount = new int[5];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aCards = Integer.parseInt(st.nextToken());
            for (int j = 0; j < aCards; j++) {
                aCount[Integer.parseInt(st.nextToken())]++;
            }

            int[] bCount = new int[5];
            st = new StringTokenizer(br.readLine());
            int bCards = Integer.parseInt(st.nextToken());
            for (int j = 0; j < bCards; j++) {
                bCount[Integer.parseInt(st.nextToken())]++;
            }

            String result = "D";
            for (int j = 4; j >= 1; j--) {
                if (aCount[j] > bCount[j]) {
                    result = "A";
                    break;
                } else if (aCount[j] < bCount[j]) {
                    result = "B";
                    break;
                }
            }

            System.out.println(result);
        }

        // Sort O(NlogN)
        // for (int i = 0; i<N; i++){
        //     Integer[] a = Arrays.stream(br.readLine().split(" "))
        //                     .skip(1)
        //                     .map(Integer::parseInt)
        //                     .toArray(Integer[]::new);
        //     Arrays.sort(a,Collections.reverseOrder());
        //     Integer[] b = Arrays.stream(br.readLine().split(" "))
        //                     .skip(1)
        //                     .map(Integer::parseInt)
        //                     .toArray(Integer[]::new);
        //     Arrays.sort(b,Collections.reverseOrder());

        //     String res = "D";
        //     if (a.length>b.length) res = "A";
        //     else if (a.length<b.length) res = "B";

        //     for (int j = 0; j<Math.min(a.length, b.length);j++){
        //         if (a[j]>b[j]){
        //             res = "A";
        //             break;
        //         } else if (a[j]<b[j]) {
        //             res = "B";
        //             break;
        //         }
        //     }
        //     System.out.println(res);
        // }


    }
}
