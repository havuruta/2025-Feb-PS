package hyochang;

import java.util.Scanner;

public class B9663 {
	static int n;
	static int[][] chess;
	static int ans;

	// 각 행에서 위에서 아래로 내려오며 들어갈 수 있는지 확인
	// 들어갈 수 있다면 넣기
	// 좌우 대각선위만 체크
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		chess = new int[n][n];
		queen(0);

		System.out.println(ans);
	}

	static void queen(int row) { // 올린 횟수 (행 이동)
		if (row == n) { // n개 배치가 끝나면 종료
			ans++;
			return;
		}

		for (int i = 0; i < n; i++) { // chess[row][col] 위치에 퀸을 놓을 수 있는지 확인
			boolean possible = true;

			// 같은 열검사
			for (int j = 0; j < row; j++) {
				if (chess[j][i] == 1) {
					possible = false;
					break;
				}
			}

			// 왼쪽 위 대각선
			int sero = row-1;
			int garo = i-1;
			while (sero >= 0 && garo >= 0) {//왼쪽이니 0이상이고 위로 가니까 0이상
				if (chess[sero][garo] == 1) {
					possible = false;
					break;
				}
				sero--;
				garo--; // 위쪽 대각선으로 이동
			}
			
			// 오른쪽 위 대각선
			sero = row - 1;
			garo = i + 1;
			while (sero >= 0 && garo < n) {
			    if (chess[sero][garo] == 1) {
			        possible = false;
			        break;
			    }
			    sero--;
			    garo++;
			}

			
			if (possible) {//놓을 수 있으면 놓음(백트래킹)
				chess[row][i] = 1;
				queen(row + 1);
				chess[row][i] = 0;
			}
		}
	}
}
