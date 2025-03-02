package Week4.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int res = 0;
		
		// 자리수는 최대 6이므로 각 자리수의 최댓값 9를 곱해서 N에서 빼면 불필요한 범위를 제외할 수 있다..
		// N - 54가 0보다 작을 수 있으니 최소 1부터 탐색할 수 있도록 해야 한다..
		for(int i = Math.max(1, N - 54); i < N; i++) {
			if(i + digitSum(i) == N) {
				res = i;
				break;
			}
		}
		
		System.out.println(res);
	}
	
	static int digitSum(int num) {
		//자릿수의 합을 저장할 변수
		int sum = 0;
		
		while(num > 0) {
			sum += num % 10; //일의 자리 숫자를 더함
			num /= 10; //10으로 나눠서 다음 자리수로 이동
		}
		return sum;
	}
}
