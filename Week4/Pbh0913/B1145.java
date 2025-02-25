package Week4.Pbh0913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int[] nums = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums); //작은수 부터 정렬
        int N = nums[4] * nums[3] * nums[2]; //적어도 대부분의 배수는 배열의 가장 큰 수, 두 번째 수, 세번째 수를 곱한값까지만 구하면 됨
        int n = nums[2]; //가장 작은 1,2번째 수는 절대 나머지 세 수의 배수가 될수 없으니 시작 값을 3번째 수 부터로 정함
        int answer = 0;
        for (int i = n; i <= N; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {  //반복문을 돌려서 배수면 카운트
                if (i % nums[j] == 0) {
                    cnt++;
                }
            }
            if (cnt >= 3) {  //키운드가 3이상일때 출력후 탈출
                sb.append(i);
                break; 
            }
        }
        System.out.println(sb);
    }
}
