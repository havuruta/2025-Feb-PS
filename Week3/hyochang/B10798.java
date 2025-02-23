package hyochang;

import java.util.Scanner;

public class B10798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] arr = new char[5][];//글자열 길이가 다름
		int longest = 0;//최대 길이 

		for (int i = 0; i < 5; i++) {
			String temp = sc.nextLine();
			arr[i] = new char[temp.length()];//해당 문자열 길이에 맞추어
			longest = Math.max(longest, temp.length());//최댓값 갱신
			for (int j = 0; j < temp.length(); j++) {
				arr[i][j] = temp.charAt(j);//순서대로 넣기
			}
		}

		StringBuilder sb = new StringBuilder();//세로로 합칠 stringbuilder생성

		for (int j = 0; j < longest; j++) {//가장 긴 길이까지
			for (int i = 0; i < 5; i++) {
				if (arr[i].length > j) {//현재 있는 행의 길이보다 낮은 j만(x좌표만) 
					sb.append(arr[i][j]);
				}
			}
		}
		System.out.println(sb.toString());
	}
}