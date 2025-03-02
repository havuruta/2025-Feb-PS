package Week4.Youngjae;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class B3040 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[9];

		int notP = 0;
		int notP2 = 0;
		int sum = 0;

		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if ((sum - arr[i] - arr[j]) == 100) {
					notP = i;
					notP2 = j;
				}
			}
		}

//		for (int value : arr) {
//			System.out.println(value);
//		}

		for (int i = 0; i < arr.length; i++) {
			if (i != notP && i != notP2) {
				System.out.println(arr[i]);
			}
		}
	}
}
