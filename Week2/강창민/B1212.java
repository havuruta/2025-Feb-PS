package 강창민;

import java.util.Scanner;

public class B1212 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String oct = sc.nextLine();
		
		// 2진수 0~7 까지
		String[] binary = { "000", "001", "010", "011", "100", "101", "110", "111"};
		
		StringBuilder sb = new StringBuilder();
		
		//입력받은 8진수 길이만큼, 8진수의 각 자리는 2진수의 3자리
		for(int i = 0; i < oct.length(); i++) {
			int num = oct.charAt(i) - '0';
			
			//제일 앞자리에는 0이 들어가지 않게
			if(i == 0) {
				sb.append(Integer.toBinaryString(num));
			} else {
				sb.append(binary[num]);
			}
			

		}
		
		System.out.println(sb);
		

		
		
		
		
	}
}
