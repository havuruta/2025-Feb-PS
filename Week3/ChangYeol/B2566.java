
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
        //9X9 배열 생성
		int[][] arr = new int[9][9];
		
		int max = Integer.MIN_VALUE; //최댓값 초기화. 0으로 하니까 안됨..
		int row = 0; //최댓값인 위치의 행 idx
		int col = 0; //최댓값인 위치의 열 idx
		
        //최댓값과 해당 위치 찾기
        //행 탐색하고 열 읽음
		for(int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > max) { //현재 위치가 최댓값보다 크면
					max = arr[i][j]; //최댓값 갱신
					row = i + 1; //갱신된 최댓값의 행 idx(문제에서 1행부터 시작했기 때문에 +1)
					col = j + 1; //갱신된 최댓값의 열 idx(문제에서 1열부터 시작했기 때문에 +1)
				}
			}
		}
		
		sb.append(max).append("\n").append(row).append(" ").append(col);
		
		System.out.println(sb);
	}
}
