package Week4.problem;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1977 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine()); //10000이하
		
		int N = Integer.parseInt(br.readLine()); //10000이하
		
		int sqrtM = (int) Math.ceil(Math.sqrt(M));
		
		int sqrtN = (int) Math.floor(Math.sqrt(N));
		
		int sum = 0;
		int min = Integer.MAX_VALUE;
		boolean found = false;
		
		for(int i = sqrtM; i <= sqrtN; i++) {
			int square = i * i;
			sum += square;
			
			if(!found) { //처음 찾은 값이 최솟값
				min = square;
				found = true;
			}
		}
		
		if(!found) { //완전제곱수가 없으면
			System.out.println(-1);
        } else { //완전제곱수가 있으면
            System.out.println(sum);
            System.out.println(min);
        }
	}
}
