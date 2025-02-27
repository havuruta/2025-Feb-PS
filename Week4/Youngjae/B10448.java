package Week4.Youngjae;

import java.io.IOException;
import java.util.Scanner;

public class B10448 {
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int K = sc.nextInt();
			boolean isOk = false;
			Loop:
			for (int i = 1; i < K; i++) {
				for (int j = 1; j < K; j++) {
					for (int k = 1; k < K; k++) {
						if ((K - (func(i) + func(j) + func(k)) == 0)) {
							isOk = true;
							break Loop;
						} 
					}
				}
			}
			
			if (isOk) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
			

		}
		

	}

	static int func(int n) {
		int result = (n * (n + 1)) / 2;
		return result;
    }
}
