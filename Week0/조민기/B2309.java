package Week0.조민기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2309 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i<9; i++){
            int now = Integer.parseInt(br.readLine());
            arr[i] = now;
            sum+=now;
        }

        Arrays.sort(arr);
        int t = sum-100;

        // 투포인터 O(N) 근데 N이 9라서 별 차이는 없음
        int left = 0, right = 8;
        while (left<right) {
            int currentSum = arr[left]+arr[right];

            if (currentSum == t){
                for (int i = 0; i<9; i++){
                    if (i!=left && i!=right) System.out.println(arr[i]);
                }
                return;
            }
            if (currentSum < t) left++; else right--;
        }

        // 브루트포스 O(N^2)
        // for (int i = 0; i<9; i++){
        //     for (int j = 0; j<9; j++){
        //         if (i==j) continue;
        //         if (arr[i]+arr[j]==t){
        //             for (int n = 0; n<9; n++){
        //                 if (n!=i && n!=j) System.out.println(arr[n]);
        //             }
        //             return;
        //         }
        //     }
        // }
    }
}
