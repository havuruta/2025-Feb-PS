package 진효창;
// B2609.java
// 문제 2609: 최대공약수와 최소공배수 - 두 자연수의 GCD와 LCM 계산.
import java.util.Scanner;

public class B2609 {
	public static void main(String[] args) {
		// 문제 2609 해결을 위한 코드를 작성하세요.
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if (n < k) {// k가 더크면 아래 유클리드 호제법을 사용할 수 없으므로 위치를 바꿔주는 과정
			int temp = n;// 임시 변수 temp(n값을 저장하고 있기 위해)를 사용해 교환 파이썬에서 a,b =b,a의 과정임
			n = k;
			k = temp;
		}
		int large = Ucl(n, k);// 최대공약수
		int Small = n * k / large;// 최소공배수
		System.out.println(large);
		System.out.println(Small);

	}

	public static int Ucl(int a, int b) {// 유클리드 호제법-> 큰 수에 작은 수를 나누어 0이 될 떄까지 나누어 나온 몫이 최대공약수
		while (b != 0) {// 나머지가 0이 될때까지 나누어 나온 수
			int c = a % b;// 이번엔 나머지가 필요하므로 temp가 아닌 새로운 변수 c를 생성
			a = b;
			b = c;
		}
		return a;
	}

}
