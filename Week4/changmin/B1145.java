package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
/* B1145 적어도 대부분의 배수
 * 다섯 개의 자연수가 있다. 이 수의 적어도 대부분의 배수는 위의 수 중 적어도 세 개로 나누어 지는 가장 작은 자연수이다.
 * 서로 다른 다섯 개의 자연수가 주어질 때, 적어도 대부분의 배수를 출력하는 프로그램을 작성하시오.
 */
public class B1145 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] numbers = new int[5];
		
		for(int i = 0; i < 5; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int multiple = 0;
		int num = 1;
		while(true) {
			int count = 0;
			for(int i = 0; i < 5; i++) {
				if(num % numbers[i] == 0) {
					count++;
				}
			}
			if(count>= 3) {
				multiple = num;
				break;
			}
			num++;
		}
		
		bw.write(multiple + "");
		bw.flush();
		bw.close();
		br.close();
		
	}
}
