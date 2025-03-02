package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/* B10448 유레카이론
 * 자연수가 주어졌을 때, 그 정수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 없는지를 판단해주는 프로그램을 만들어라. 
 * 단, 3개의 삼각수가 모두 달라야 할 필요는 없다.
 */
public class B10448 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		List<Integer> numbers = new ArrayList<>(); //삼각수 저장
		numbers.add(0); //0번은 0
		int num = 1;
		int rep = 2;
		while(num <= 1000) {
			numbers.add(num);
			num += rep++;
		}
		
		//테케 개수만큼
		for(int tc = 1; tc <= T; tc++) {
			
			int K = Integer.parseInt(br.readLine());
			
			boolean isOk = false; //이건 삼각수 3개로 가능?
			
			for(int i = 1 ; i < numbers.size(); i++) {
				for(int j = 1; j < numbers.size(); j++) {
					for(int n = 1; n < numbers.size(); n++) {
						
						//삼각수 3개 합쳐서 가능하냐?
						if(numbers.get(i)+numbers.get(j)+numbers.get(n) == K) {
							isOk = true;
							
							//더 커지면 사이클 멈춰
						} else if(numbers.get(i)+numbers.get(j)+numbers.get(n) > K) {
							break;
						}
						
					}
					// true면 사이클 멈춰!
					if(isOk) {
						break;
					}
				}
				// true면 사이클 멈춰!
				if(isOk) {
					break;
				}
			}
			
			if(isOk) {
				bw.write(1 + "\n");
			} else {
				bw.write(0 + "\n");
			}
			
			
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
