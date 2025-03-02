package Week4.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1145 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] nums = new int[5];

		//최솟값부터 하나씩 증가하면서 탐색
		//세 개 이상으로 나누어지는지 확인
		//처음 조건을 만족하는 수를 출력
		
		int min = Integer.MAX_VALUE; //최솟값 설정
		//배열에 값을 넣으면서 최솟값 갱신
		for(int i = 0; i < 5; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
			if(nums[i] < min) {
				min = nums[i];
			}
		}
		
		int num = min;
		
		while(true) {
			int cnt = 0; //현재 숫자가 몇 개의 수로 나누어지는지 세기 위한 변수
			for(int n : nums) { //다섯 개의 수를 하나씩 확인하면서 나누어지는지 체크
				if(num % n == 0) {
					cnt++;
				}
			}
			if(cnt >= 3) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}
}
