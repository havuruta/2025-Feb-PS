package problem;

import java.io.IOException;
import java.util.Scanner;

public class B1259 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
		
		while (true) {
			int input = sc.nextInt();
			String num = Integer.toString(input);
			int N = num.length();
			char[] c = num.toCharArray();
			boolean isOk = true;
			
			for (int i = 0; i < N/2; i++) {
				if (c[i] != c[N-1-i]) {
					isOk = false;
					break;
				}
			}
			if (isOk && input != 0) {
				System.out.println("yes");
			} else if (isOk == false && input != 0){
				System.out.println("no");
			}
			
			
			
			if (input == 0) {
				break;
			}
		}
    }
}
