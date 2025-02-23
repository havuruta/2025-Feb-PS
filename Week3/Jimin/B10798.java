import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B10798 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = new String[5];
		int strMaxLength = 0;
		for(int i=0; i<5; i++) {
			str[i] = br.readLine();
			strMaxLength = Math.max(strMaxLength, str[i].length());
		}
		
		for(int i=0; i<strMaxLength; i++) {
			for(int j=0; j<5; j++) {
				if(str[j].length() <= i) continue;
				bw.write(str[j].charAt(i));
			}
		}
		br.close();
		bw.flush();
		bw.close();
	}
}
