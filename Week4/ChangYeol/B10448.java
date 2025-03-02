package Week4.problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B10448 {
	static List<Integer> triangleNumbers = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		triangleNumbers();
		
		int T = Integer.parseInt(br.readLine());
		
		while (T-- > 0) {
            int K = Integer.parseInt(br.readLine());
            sb.append(isOk(K) ? "1\n" : "0\n");
        }
		
		System.out.println(sb.toString());
	}
	
	static void triangleNumbers() {
		int n = 1;
		while(true) {
			int Tn = n * (n + 1) / 2; //삼각수 공식
			if(Tn > 1000) { //1000 넘으면 종료
				break;
			}
			triangleNumbers.add(Tn);
			n++;
		}
	}
	
	//K가 정확히 3개의 삼각수 합으로 표현 가능한지 확인
	static boolean isOk(int K) {
		int size = triangleNumbers.size();
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				for(int k = 0; k < size; k++) {
					if (triangleNumbers.get(i) + triangleNumbers.get(j) + triangleNumbers.get(k) == K) {
                        return true;
                    }
				}
			}
		}
		return false;
	}
}
