package hyochang;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class B2470 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		int[] liquid = new int[n];
		String[] temp = (br.readLine()).split(" ");
		for (int i = 0; i < n; i++) {
			liquid[i] = Integer.parseInt(temp[i]);
		}
//정렬 하고 결과가 음수라면 left를 올리고 양수라면 right를 낮추어 찾을 것
		Arrays.sort(liquid);
		int right = n - 1;
		int left = 0;
		int ans = Integer.MAX_VALUE;
		int an_r=0;//해당하는 용액의 위치를 저장
		int an_l=0;
		while (left <right) {
			int sum = liquid[left] + liquid[right];
			if (Math.abs(sum) < Math.abs(ans)) {//0에 가까운 값을 찾으므로 절대값으로 비교
				ans = sum;
				an_l=left;
				an_r=right;
			}
			if (sum == 0) {//0이면 탐색종료
				break;
			} else if (sum < 0) {//음수면 left를 가운데로 댕겨서 0에 가는 방법밖에 없음
				left++;
			} else {
				right--;
			}
		}
		bw.write(String.valueOf(liquid[an_l])+" "+String.valueOf(liquid[an_r]));
		bw.flush();
		bw.close();
	}
}