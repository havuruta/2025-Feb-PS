package Week4.Pbh0913;

import java.util.Scanner;

public class B1977 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int a = sc.nextInt();
        int b = sc.nextInt();
        //입력값의 범위가 10000이하라서 100까지의 제곱수만 구해준다.
        int[] num = new int[10001];
        for (int i = 1; i <= 100; i++) {
            num[i * i]++; //그 값을 카운트 배열에서 카운트 해주는데 대충 +1해줌
        }
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = a; i <= b; i++) {  //범위의 값을 탐색해서 0이 아닌경우 합과 작은 수를 구함
            if (num[i] != 0) {
                sum += i;
                min = Math.min(min, i);
            }
        }
        if (sum == 0) {  //범위를 돌 동안 제곱수가 없었으니 -1출력
            sb.append(-1);
        } else {
            sb.append(sum + "\n" + min);
        }
        System.out.println(sb);
    }
}
