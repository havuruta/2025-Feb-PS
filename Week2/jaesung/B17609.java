package jaesung;

/*
 문제 : 17609(회문)
 시간 : 404ms
 풀이 : 문자열의 양 끝을 초기 두 포인터로 지정하고 중앙으로 인덱스를 증감시키며 회문, 유사회문을 판단.
 유사회문인 경우를 3가지로 구분하여 풀이
 1. 왼쪽 포인터 문자를 제거할때만 유사회문이 예상되는 경우 : 왼쪽 포인터를 증가(=왼쪽 문자 하나 제거) 후 다음 루프 수행.
 2. 오른쪽 포인터 문자를 제거할때만 유사회문이 예상되는 경우 : 오른쪽 포인터를 감소(=오른쪽 문자 하나 제거) 후 다음 루프 수행.
 3. 양쪽 포인터 모두 문자를 제거해도 유사회문이 예상되는 경우 : 각 경우에서 회문 판단을 계속했을 때 유사회문이 되는지 중첩 루프 수행.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B17609 {
    public static void main(String[] args) throws IOException {
        // 빠른 입출력 사용.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
						
			int left = 0;
			int right = str.length()-1;
			
			int ans = 0;
			boolean pseudo = false;
			
			outLoop:
			while (left < right) {
				if (str.charAt(left) != str.charAt(right)) { // 두 포인터의 문자가 다를 경우
					if (!pseudo) { // 유사회문 체크
						ans = 1;
						if (str.charAt(left) == str.charAt(right-1) && str.charAt(left+1) == str.charAt(right)) { // 양쪽 문자 모두 제거 가능성이 있는 경우
							pseudo = true;
							
							// 왼쪽 문자 제거 가정 회문 판별
							int tmpLeft = left+1;
							int tmpRight = right;
							while (tmpLeft < tmpRight) {
								// 유사 회문이 아닌 경우
								if (str.charAt(tmpLeft) != str.charAt(tmpRight)) {
									break;
								}
								
								++tmpLeft;
								--tmpRight;
								
								// 유사 회문인 경우
								if (tmpLeft >= tmpRight) 
									break outLoop;
							}
							
							// 오른쪽 문자 제거 가정 회문 판별
							tmpLeft = left;
							tmpRight = right - 1;
							while (tmpLeft < tmpRight) {
								// 유사 회문이 아닌 경우
								if (str.charAt(tmpLeft) != str.charAt(tmpRight)) {
									ans = 2;
									break outLoop;
								}
								
								++tmpLeft;
								--tmpRight;
								
								// 유사 회문인 경우
								if (tmpLeft >= tmpRight) 
									break outLoop;
							}
						}
						else if (str.charAt(left+1) == str.charAt(right)) { // 왼쪽 문자 하나 제거 가정
							pseudo = true; // 더이상 제거할 수 없도록 체크
							++left; // 왼쪽 문자 제거
						}
						else if (str.charAt(left) == str.charAt(right-1)) { // 오른쪽 문자 하나 제거 가정
							pseudo = true; // 더이상 제거할 수 없도록 체크
							--right; // 오른쪽 문자 제거
						}
						else { // 제거해도 불일치인 경우
							ans = 2;
							break;
						}
					}
					else { // 유사회문 체크 이후 불일치인 경우
						ans = 2;
						break;
					}
				}
				
				// 두 포인터 이동
				++left;
				--right;
			}
			
			bw.write(Integer.toString(ans) + "\n");
			bw.flush();
		}
		bw.close();
    }
}
