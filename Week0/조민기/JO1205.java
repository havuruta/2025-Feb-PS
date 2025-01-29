package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JO1205 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .sorted()
                        .toArray();
        int zero = 0;
        for (int i : arr){
            if (i == 0) zero++;
        }

        if (zero == arr.length){
            System.out.println(zero);
            return;
        }
        
        int[] distinct = Arrays.stream(arr)
                        .filter(x -> x!=0)
                        .distinct()
                        .toArray();

        int left = 0;
        int maxLen = 1;

        // 슬라이딩 윈도우 O(N)
        for (int right = 0; right < distinct.length; right++) {
            // 필요한 조커 계산
            //   gap = distinct[right] - distinct[left] + 1 : 실제로 연속 만들려면 필요한 길이
            //   have = (right - left + 1) : 현재 구간에 실제로 있는 카드 개수
            //   needed = gap - have : 이 구간을 메우기 위해 필요한 조커 수
            while (true) {
                int gap = distinct[right] - distinct[left] + 1;
                int have = (right - left + 1);
                int needed = gap - have;
                
                if (needed <= zero) {
                    // 조커로 채울 수 있으면 break -> 현재 구간 유지 가능
                    break;
                } else {
                    // needed가 더 크면 left를 이동해서 스킵
                    left++;
                }
            }
            
            // 구간 [left..right]가 valid하므로 길이를 계산
            int gap = distinct[right] - distinct[left] + 1;
            int have = (right - left + 1);
            int needed = gap - have;
            int leftover = zero - needed;
            
            // 구간 내부를 모두 메운 뒤 leftover만큼 양끝 확장 가능
            // 각 1칸 확장할 때마다 조커 1개 소모
            int currentLen = gap + leftover;
            
            maxLen = Math.max(maxLen, currentLen);
        }
        
        System.out.println(maxLen);


        // 직관 구현 O(N^2)
        // int res = 1;
        // N =  arr.length;
        // for (int i = 0; i<N; i++){
        //     int joker = zero;
        //     int next = i+1;
        //     while (next<N) {
        //         int diff = arr[next]-arr[next-1];
        //         if (diff == 1) {
        //             next++;
        //             continue;
        //         } else{
        //             if (diff-1>joker) {
        //                 break;
        //             } else {
        //                 joker-=(diff-1);
        //             }
        //             next++;
        //         }
        //     }
        //     res = Math.max(arr[next-1]-arr[i]+1+joker, res);
        // }
        // System.out.println(res);
    }
}
