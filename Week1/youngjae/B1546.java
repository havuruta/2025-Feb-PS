package youngjae;

import java.util.Scanner;

// B1546.java
// 문제 1546: 평균 - 점수를 조작하여 새로운 평균 계산.
public class B1546 {
    public static void main(String[] args) {
        // 문제 1546 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);

		float max = -1f;
		int majorNum = sc.nextInt();
		float sum = 0;
		float result = 0f;
		int[] arr = new int[majorNum];

		for (int i = 0; i < majorNum; i++) {
			int score = sc.nextInt();
			arr[i] = score;
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		for (int k = 0; k < arr.length; k++) {
			sum +=  (float)arr[k] / max * 100;
		}
		result = sum / (float)majorNum;
		System.out.println(result);
    }
}
