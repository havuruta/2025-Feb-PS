package problem;

/*
 문제 : 1259(펠린드롬수)
 시간 : 160ms
 풀이 : 입력 문자열의 양 끝으로부터 중앙으로 인덱스를 증감시키며 두 문자의 동일 여부를 판단하여 펠린드롬수 판별
 */

import java.util.Scanner;

public class B1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		while (true) {
			String str = sc.next();
			
			if(str.equals("0")) break;
			
			// 문자열의 팰린드롬 판단 시작 인덱스 지정
			int left = 0;
			int right = str.length()-1;
			
			String ans = "yes";
			
			while (left < right) { // 두 인덱스를 안쪽으로 증감시키며 동일 여부 판단
				if (str.charAt(left++) != str.charAt(right--)) { // 다를 경우
					ans = "no";
					break;
				}
			}
			
			System.out.println(ans);
		}
    }
}
