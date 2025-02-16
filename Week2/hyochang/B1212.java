package hyochang;

import java.util.Scanner;

public class B1212 {
    public static void main(String[] args) {
    // 가능하면 500ms 이내로 풀어봅시다. 실행시간: 500ms
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		if (str.equals("0")) {//0이면 0출력하고 종료
			System.out.println(0);
			return;
		}

		int[] arr = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {//숫자 분리해서 배열에
			arr[i] = str.charAt(i) - '0';
		}

		StringBuilder sb = new StringBuilder();
		sb.append(exchange1(arr[0]));//처음 수에는 0이 들어가면 안되니 다른 메서드 
		for (int i = 1; i < str.length(); i++) {
			sb.append(exchange(arr[i]));//이후 수들은 규칙에 따라서
		}

		System.out.println(sb);
	}

	static String exchange(int a) {
		switch (a) {//각 자리수를 2진수로 변환(8->2이기 때문에 3자리)
		case 0:
			return "000";
		case 1:
			return "001";
		case 2:
			return "010";
		case 3:
			return "011";
		case 4:
			return "100";
		case 5:
			return "101";
		case 6:
			return "110";
		case 7:
			return "111";
		default:
			return "error";
		}
	}

	static String exchange1(int a) {
		switch (a) {//0이 없는 버전
		case 0:
			return "0";
		case 1:
			return "1";
		case 2:
			return "10";
		case 3:
			return "11";
		case 4:
			return "100";
		case 5:
			return "101";
		case 6:
			return "110";
		case 7:
			return "111";
		default:
			return "error";
		}
	}
}
