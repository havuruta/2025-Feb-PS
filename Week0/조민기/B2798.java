package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2798 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
        
        int best = 0;
        // 1개 잡고 2개 투포인트 O(N^2)
        for (int i = 0; i < N - 2; i++) {
            int left = i+1, right = N-1;
            
            while (left<right) {
                int sum = cards[i]+cards[left]+cards[right];

                if (sum<=M){
                    best = Math.max(sum, best);
                    left++;
                } else {
                    right--;
                }

                if (best == M) break;
            }
            if (best == M) break;
        }


        // 2개 O(N^2)으로 잡고 나머지 이분 O(N^2logN)
        // for (int i = 0; i < N - 2; i++) {
        //     for (int j = i + 1; j < N - 1; j++) {
        //         int sumTwo = cards[i]+cards[j];
        //         if (sumTwo>M) continue;
        //         int left = j+1, right = N-1;
        //         while (left<=right) {
        //             int mid = (left+right)/2;
        //             int now = sumTwo+cards[mid];
        //             if (now<=M){
        //                 best = Math.max(mid, now);
        //                 left = mid+1;
        //             } else {
        //                 right = mid-1;
        //             }
        //         }
        //         if (best == M) break;
        //     }
        //     if (best == M) break;
        // }

        // 완전탐색 O(N^3)
        // for (int i = 0; i < N - 2; i++) {
        //     for (int j = i + 1; j < N - 1; j++) {
        //         for (int k = j + 1; k < N; k++) {
        //             int sum = cards[i] + cards[j] + cards[k];
        //             if (sum <= M) {
        //                 best = Math.max(best, sum);
        //             }
        //         }
        //     }
        // }
        
        System.out.println(best);
    }
}
