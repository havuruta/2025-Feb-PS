package 진효창;
// B1546.java
// 문제 1546: 평균 - 점수를 조작하여 새로운 평균 계산.
import java.util.Scanner;

public class B1546 {
	public static void main(String[] args) {
		// 문제 1546 해결을 위한 코드를 작성하세요.

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		double[] arr = new double[a];//출력에 소숫점이 나오므로 실수 자료형 double
		double max = 0;// 최댓값 선언
		for (int i = 0; i < a; i++) {
			arr[i] = sc.nextInt();//배열에 입력받은 값 넣기
			if (arr[i] > max)//최댓값 갱신
				max = arr[i];
		}
		double sum = 0;//합
		for (int i = 0; i < a; i++) {
			arr[i] = (arr[i] / max) * 100;//문제에서 말하는 변경값 만큼 더해주고 다시 배열에 넣음
			sum += arr[i];//배열의 합
		}

		double ans = (sum / a);
		System.out.print(ans);
	}

}