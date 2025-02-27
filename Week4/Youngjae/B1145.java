package Week4.Youngjae;

import java.io.IOException;
import java.util.Scanner;
import java.util.Scanner;

public class B1145 {
    public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int [] arr= new int [5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int num = 1; // num은 1로 초기화
//		int count = 0; -> 
		while(true) {
			
			int count = 0; // 매 루프마다 초기화 필요
			
			for (int i = 0; i < arr.length; i++) {
				if (num % arr[i] == 0) {
					count++;
				}
			}
			
			if (count >= 3) {
				break;
			}
			num++;
			
		}
		System.out.println(num);
    }
}
