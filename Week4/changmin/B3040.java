package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
 * B3040 백설 공주와 일곱 난쟁이
 * 백설공주는 이런 일이 생길 것을 대비해서, 난쟁이가 쓰고 다니는 모자에 100보다 작은 양의 정수를 적어 놓았다. 
 * 사실 백설 공주는 공주가 되기 전에 매우 유명한 수학자였다. 따라서, 일곱 난쟁이의 모자에 쓰여 있는 숫자의 합이 100이 되도록 적어 놓았다.
 * 아홉 난쟁이의 모자에 쓰여 있는 수가 주어졌을 때, 일곱 난쟁이를 찾는 프로그램을 작성하시오. (아홉 개의 수 중 합이 100이 되는 일곱 개의 수를 찾으시오)
 */
public class B3040 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] numbers = new int[9];
		
		int sum = 0; //키 
		int no1 = 0; //가짜 난쟁이1
		int no2 = 0; //가짜 난쟁이2
		
		for(int i = 0; i < 9; i++) { //아홉난쟁이 합
			numbers[i] = Integer.parseInt(br.readLine());
			sum += numbers[i];
		}
		
		for(int i = 0; i < 8; i++) {
			for(int j = i+1; j < 9; j++) { //두 난쟁이 골라서 뺀게 100-> 가짜 난쟁이
				if(sum - numbers[i] - numbers[j] == 100) {
					no1 = i;
					no2 = j;
				}
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(i == no1 || i == no2) { // 가짜 빼고 출력
				continue;
			}
			bw.write(numbers[i]+ "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
