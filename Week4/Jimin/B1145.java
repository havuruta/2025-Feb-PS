import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B1145 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		for(int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int num = 2;
		while(true) {
			int count = 0;
			for(int i=0; i<5; i++) {
				if(num % arr[i] == 0) count++;
			}
			if(count >= 3) break;
			num++;
		}
		bw.write(String.valueOf(num));
		br.close();
		bw.flush();
		bw.close();
	}
}
