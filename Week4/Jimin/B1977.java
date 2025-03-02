import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1977 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());

		int min = -1;
		int sum = 0;
		
		for (int i = N; i >= M; i--) {
			int a = (int) Math.sqrt(i);
			if(a*a == i) {
				min = i;
				sum += i;
			}
		}
		
		if (min == -1) bw.write(String.valueOf(min));
		else bw.write(sum + "\n" + min);
		
		br.close();
		bw.flush();
		bw.close();
	}
}
