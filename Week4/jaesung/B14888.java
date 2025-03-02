package Week4.problem;

/*
 문제 : 14888(연산자 끼워넣기)
 시간 : 188ms
 풀이 : 백트래킹을 통해 숫자 사이에 연산자를 배치하는 모든 경우의 수를 확인하며 최대, 최소값을 도출
 
 ※ 값의 최소 범위를 생각하지 않고 초기 maxVal을 0으로 지정해 다수 틀림.
 문제 풀이 시 출력 가능한 수의 범위를 반드시 고려.
 */

import java.util.Scanner;

public class B14888 {
	static int N;
	// 숫자 입력 배열
	static int[] nums;
	// 연산자 입력 배열
	static int[] operators = new int[4];
	// 연산자 배치 배열
	static int[] inputOps;
	
	static int minVal = Integer.MAX_VALUE;
	static int maxVal = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
				
		N = sc.nextInt();
		nums = new int[N];
		inputOps = new int[N-1];
				
		for (int i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		
		for (int i = 0; i < operators.length; i++) {
			operators[i] = sc.nextInt();
		}
		
		func(0);
		
		System.out.println(maxVal);
		System.out.println(minVal);
	}
	
	// 백트래킹 수행 재귀함수
	static void func(int depth) {
		if (depth == N-1) {
			int val = nums[0];
			
			// 연산자 배치에 따른 연산 수행
			for (int i = 0; i < inputOps.length; i++) {
				if (inputOps[i] == 0) val += nums[i+1];
				else if (inputOps[i] == 1) val -= nums[i+1];
				else if (inputOps[i] == 2) val *= nums[i+1];
				else val /= nums[i+1];
			}
			
			minVal = Math.min(val, minVal);
			maxVal = Math.max(val, maxVal);
			
			return;
		}
		
		// 연산자 입력 배열을 순회하며 연산자를 배치
		for (int i = 0; i < operators.length; i++) {
			if (operators[i] == 0) continue;
			
			// 연산자 배치
			--operators[i];
			inputOps[depth] = i;
			
			func(depth + 1);
			
			// 배치 이후 복구
			++operators[i];
		}
	}
}
