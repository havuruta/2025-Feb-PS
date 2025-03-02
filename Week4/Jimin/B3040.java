import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B3040 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] arr = new int[9];
		int sum = 0;
		
		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}
		
		for (int i = 0; i < 7; i++) {
			for (int j = 8; j > i; j--) {
				if (sum - (arr[i] + arr[j]) == 100) {
					arr[i] = -1;
					arr[j] = -1;
					break;
				}
			}
		}
		for(int i=0; i<9; i++) {
			if(arr[i] > 0) bw.write(arr[i] + "\n"); 
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
