
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        //행렬 생성 5X15
		char[][] arr = new char[5][15];
        
        //행렬에 공백 입력
        //Arrays.fill()이 있군...
		for(char[] row : arr) {
			Arrays.fill(row, ' ');
		}
		
        // 5줄의 입력을 받아서 배열에 저장
		for(int i = 0; i < 5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String word = st.nextToken(); //입력 받아서 문자열로 저장
			for(int j = 0; j < word.length(); j++) { //문자열의 길이(해당 줄의 길이)만큼 반복
				arr[i][j] = word.charAt(j); //배열에 저장
			}
		}
		
        //세로 방향으로 읽기
        //열 먼저 탐색하고, 각 열에서 행 순으로 읽는다
		for (int j = 0; j < 15; j++) {
            for (int i = 0; i < 5; i++) {
                if (arr[i][j] != ' ') { //공백이 아니면 출력할거니까
                    sb.append(arr[i][j]); //sb에 저장
                }
            }
        }
		
		System.out.println(sb);
	}
}
