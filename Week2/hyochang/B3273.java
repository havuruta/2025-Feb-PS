package hyochang;
import java.util.Arrays;
import java.util.Scanner;
public class B3273 {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); 
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr); 

        int x = sc.nextInt();

        int left = 0;
        int right = n - 1;
        int cnt = 0; //해당 쌍의 갯수  

        while (left < right) {//최소가 최대를 넘길 때까지
            int sum = arr[left] + arr[right];

            if (sum == x) {//같으면 범위를 줄여서 다시 탐색
                cnt++;
                left++; 
                right--;
            } else if (sum < x) {//결과와 목표에 따른 탐색 반경 조정
                left++; 
            } else {
                right--;
            }
        }

        System.out.println(cnt);
    }
}
