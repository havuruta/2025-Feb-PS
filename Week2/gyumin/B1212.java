package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1212 {

	/*
	 * n진수 간 교환식을 쓸 수도 있지만 8진수면 0~7까지만 들어오니까 switch문으로 처리해서 연산과정 삭제
	 * 
	 * 부록1: 10진수로 변환 de += code % 10 * Math.pow(n, 0 to code.length - 1)
	 * 
	 * 부록2: n진수로 변환 nCode += de % n * Math.pow(10, 0 to code.length - 1)
	 * 
	 * 부록3: 10진수를 거치지 않는 변환 8 = 2^3 -> 각 자리수를 세자리의 2진수로, 단 첫자리 빼고 << 이건 스위치문 작성 근거임
	 * 16 = 2^4 -> 각 자리수를 네자리의 2진수로, 역시 첫자린 빼고
	 */
	static String first(char c) {
		switch (c) {
		case '0':
			return "0";
		case '1':
			return "1";
		case '2':
			return "10";
		case '3':
			return "11";
		case '4':
			return "100";
		case '5':
			return "101";
		case '6':
			return "110";
		}
		// 여기 닿은 건 입력이 잘못되지 않은 이상 7
		// default로 쓰면 스위치문 밖에서 리턴이 없어서 고장남
		return "111";
	}

	static String change(char c) {
		switch (c) {
		case '0':
			return "000";
		case '1':
			return "001";
		case '2':
			return "010";
		case '3':
			return "011";
		case '4':
			return "100";
		case '5':
			return "101";
		case '6':
			return "110";
		}
		// 여기 닿은 건 입력이 잘못되지 않은 이상 7
		// default로 쓰면 스위치문 밖에서 리턴이 없어서 고장남
		return "111";
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		String octa = br.readLine();

		int i = 0;
		// 만약 무슨 수를 써도 시간이 안 줄어든다면 StringBuffer 때문
		// 백준 채점 서버는 단일 스레드 환경일 가능성이 높기 때문에
		// 스레드 처리를 하느라 느려지는 StringBuffer를 쓸 이요가 없음
		// 근거: "1개의 채점 서버는 한 번에 최대 1개의 제출만 채점합니다. 이전 채점의 채점이 모두 끝난 이후에만 새로운 채점을 시작합니다." (https://help.acmicpc.net/judge/info)
		while (i < octa.length()) {

			if (i == 0) {
				String returnIs = first(octa.charAt(0));
				sb.append(returnIs);

				if (returnIs.equals("0")) {
					break;
				}

				i++;
				continue;
			}

			sb.append(change(octa.charAt(i)));
			i++;
		}

		
		
		// 출력하기
		bw.write(sb.toString());
		bw.flush();

		br.close();
		bw.close();
	}
}
