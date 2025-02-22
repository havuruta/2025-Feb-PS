import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B2566 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int[][] arr = new int[9][9];
		int maxNum = -1;
		int maxRow = -1;
		int maxCol = -1;
		
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] > maxNum) {
					maxNum = arr[i][j];
					maxRow = i+1;
					maxCol = j+1;
				}
			}
		}
		bw.write(String.valueOf(maxNum));
		bw.newLine();
		bw.write(maxRow + " " + maxCol);
		
		br.close();
		bw.flush();
		bw.close();
	}
}
