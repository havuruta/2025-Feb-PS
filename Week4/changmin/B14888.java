package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
/* B14888 연산자 끼워넣기
 * N개의 수와 N-1개의 연산자가 주어졌을 때, 만들 수 있는 식의 결과가 최대인 것과 최소인 것을 구하는 프로그램을 작성하시오.
 * 첫째 줄에 만들 수 있는 식의 결과의 최댓값을, 둘째 줄에는 최솟값을 출력한다. 
 * 연산자를 어떻게 끼워넣어도 항상 -10억보다 크거나 같고, 10억보다 작거나 같은 결과가 나오는 입력만 주어진다. 
 * 또한, 앞에서부터 계산했을 때, 중간에 계산되는 식의 결과도 항상 -10억보다 크거나 같고, 10억보다 작거나 같다.
 */
public class B14888 {
	
	static int N; //숫자 개수
	static int max = Integer.MIN_VALUE; //최대
	static int min = Integer.MAX_VALUE; //최소
	static int[] numbers; //숫자 배열
	static int[] operator = new int[4]; //연산자 개수 배열 + - * /
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		numbers = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) { //숫자들 입력받
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; i++) { //연산자 입력받
			operator[i] = Integer.parseInt(st.nextToken());
		}
		
		cal(numbers[0], 1);
		
		
		bw.write(max +"\n");
		bw.write(min +"\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void cal(int num, int idx) {
		if(idx == N) { //연산 마지막까지 다 했으면
			max = Math.max(num, max);
			min = Math.min(num, min);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(operator[i] > 0) { //각 연산자가 남아있는경우
				int nextNum = num;
				if(i == 0) { // i -> 인덱스, 인덱스별로 + - * / 임
					nextNum += numbers[idx];
				} else if (i == 1) {
					nextNum -= numbers[idx];
				} else if (i == 2) {
					nextNum *= numbers[idx];
				} else {
					if(nextNum < 0) { //음수를 양수로 나눌때 양수로 바꾼 뒤 몫을 다시 음수로
 						nextNum = -(-nextNum / numbers[idx]);
					} else {
						nextNum /= numbers[idx];
					}
				}
				operator[i]--; //연산자 사용했으니 한개 빼기
				cal(nextNum, idx+1); //다시 들어가
				operator[i]++; // 다시 돌려 놓기
			}
		}
	}
}
