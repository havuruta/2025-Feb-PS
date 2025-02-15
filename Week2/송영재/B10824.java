package problem;

import java.io.IOException;
import java.util.Scanner;

public class B10824 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		String b = sc.next();
		String c = sc.next();
		String d = sc.next();
		
		long result1 = Long.parseLong(a+b); // int로 하니까 더 커지는 경우가 있어서 long으로
		long result2 = Long.parseLong(c+d);
		
		System.out.println(result1+result2);
    }
}
