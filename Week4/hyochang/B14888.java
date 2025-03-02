package hyochang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B14888 {

    public class Main {
        static int n;
        static int[] arr;
        static int[] calcu = new int[4];// 0->더하기 1->빼기 2-> 곱셈 3->나누기
        static List<int[]> permute;
        // 입력받은 연산자의 순열 조합을 구함

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            n = sc.nextInt();
            arr = new int[n];
            permute = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < 4; i++) {
                calcu[i] = sc.nextInt();
            }
            combi(0, new int[n - 1]);
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int[] p : permute) {
                max = Math.max(max, cal(p));
                min = Math.min(min, cal(p));
            }
            System.out.println(max);
            System.out.println(min);
        }

        static int cal(int[] perm) {//연산자에 해당하는 계산하기
            int ans = arr[0];
            for (int i = 0; i < perm.length; i++) {
                if (perm[i] == 0) {
                    ans += arr[i + 1];
                } else if (perm[i] == 1) {
                    ans -= arr[i + 1];
                } else if (perm[i] == 2) {
                    ans *= arr[i + 1];
                } else {
                    ans /= arr[i + 1];
                }
            }
            return ans;
        }

        static void combi(int cur, int[] perm) {//연산자 경우의 수 찾기
            if (cur == n - 1) {// 연산자는 n보다 1개 낮은 길이니까
                permute.add(perm.clone());
                return;
            }
            for (int i = 0; i < 4; i++) {
                if (calcu[i] > 0) {//0이면 해당 연산자를 쓸 수 없음
                    calcu[i]--;
                    perm[cur] = i;
                    combi(cur + 1, perm);
                    calcu[i]++;
                }
            }
        }

    }
}