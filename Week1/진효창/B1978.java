package 진효창;
// B1978.java
// 문제 1978: 소수 찾기 - 주어진 숫자 중 소수의 개수를 계산.
import java.util.Scanner;

public class B1978 {
	public static void main(String[] args) {
		// 문제 1978 해결을 위한 코드를 작성하세요.

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int[] arr = new int[a];
		int count = 0;
		for (int i = 0; i < a; i++) {
			arr[i] = sc.nextInt();
			if (prime(arr[i])) {//입력값이 소수인지 확인하고 true이면 count+1 
				count++;
			}
		}
		System.out.println(count);
	}

	public static boolean prime(int a) {//소수-> 1과 자기자신으로만 나눌 수 있는 수
		if (a < 2)//1은 소수가 아니므로
			return false;
		for (int i = 2; i < a; i++) {//2부터 a-1까지 나누어보며 나누어지면 false 끝까지가면 true
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}

}
