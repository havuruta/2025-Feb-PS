package hyochang;

import java.util.Scanner;

public class B17609 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		sc.nextLine();
		for (int tc = 1; tc <= t; tc++) {
			String str = sc.nextLine();
			System.out.println(felin(str));
		}
	}

	static int felin(String str) {

		int start = 0;
		int finish = str.length() - 1;
		while (start < finish) {
			if (str.charAt(start) != str.charAt(finish)) {//좌우에서 탐색하다 아니면(0,5)/(1,4)/(2,3)
				if (palin(str, start+1, finish) || palin(str, start, finish-1)) {//앞뒤로 한글자씩 제거햇을때 회문인지 확인
					return 1;//해당하면 유사회문
				}
				return 2;//그냥 아닌경우
			}
			start++;
			finish--;
		}

		return 0;
	}

	static boolean palin(String str, int start, int finish) {
		while (start < finish) {
			if (str.charAt(start) != str.charAt(finish)) {
				return false;
			}
			start++;
			finish--;
		}
		return true;
	}
}