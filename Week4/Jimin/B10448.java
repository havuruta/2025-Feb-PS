import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10448 {
	static int num;
	static int[] arr;
	static boolean isOk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		arr = new int[45];
		for (int i = 1; i <= 44; i++) {
			arr[i] = threeNum(i);
		}

		for (int tc = 0; tc < T; tc++) {
			num = Integer.parseInt(br.readLine());
			isOk = false;
			
			Outer: for(int i=1; i<=44; i++) {
				for(int j=1; j<=44; j++) {
					for(int k=1; k<=44; k++) {
						if(arr[i] + arr[j] + arr[k] == num) {
							isOk = true;
							break Outer;
						}
					}
				}
			}
			
			if(isOk) bw.write("1\n");
			else bw.write("0\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

	static int threeNum(int n) {
		return n * (n + 1) / 2;
	}
}
