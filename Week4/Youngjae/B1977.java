package Week4.Youngjae;

import java.io.IOException;
import java.util.Scanner;

public class B1977 {
    public static void main(String[] args) throws IOException {
    	Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int min = Integer.MAX_VALUE;
		int i = 1;
		int sum = 0;
		int count = 0;
		
		while (i <= N) {
			int num = i * i;
			
			if (num >= M && num <= N) {
				
				if (num < min) {
					min = num;
				}
				count++;
				sum += num;
			}
			
			i++;
		}
		
		// 여기 출력이 헷갈리네
		if (count == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}
    }
}
