package jaesung;

/*
 문제 : 10824(네 수)
 시간 : 172ms
 풀이 : 한 줄을 입력 받은 뒤 각 split 메서드를 통해 공백 단위로 구분 후, 연속된 두 문자열을 이은 뒤 long으로 형변환하여 합산
 입력 범위를 고려하였을 때, int 표현 범위를 벗어날 수 있으므로 long을 사용
 */

import java.util.Scanner;

public class B10824 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] nums = sc.nextLine().split(" ");
		
		System.out.println(Long.parseLong(nums[0] + nums[1]) + Long.parseLong(nums[2] + nums[3]));
	}
}
