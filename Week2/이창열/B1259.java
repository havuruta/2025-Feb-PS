package 이창열;

import java.util.Scanner;

// 팰린드롬수
public class B1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			int num = sc.nextInt();
			
			if(num == 0) {
				break;
			}
			
			String str = Integer.toString(num);
			String reverseStr = new StringBuilder(str).reverse().toString();
			
			if(str.equals(reverseStr)) {
				System.out.println("yes");
			}
			else {
				System.out.println("no");
			}
		}
	}
}
