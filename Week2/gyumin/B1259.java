package gyumin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class B1259 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		List<String> nums = new ArrayList<>();
		// 일단 입력을 받아보자
		// 근데 String으로
		String s;
		int idx = 0;
		while(!(s = br.readLine()).equals("0")) {
			nums.add(s);
		}
		
		for(int i = 0; i < nums.size(); i++) {
			// 값 뽑고
			String num = nums.get(i);
			
			// 포인터를 만들고
			int start = 0;
			int end = num.length() - 1;

			// 검사를 해
			boolean isntRight = false;

			while (start <= end) {
				if (num.charAt(start) == num.charAt(end)) {
					start++;
					end--;
				} else {
					isntRight = true;
					break;
				}
			}
			
			// ***조건***에 맞춰서 "yes" 와 "no"를 출력한다
			if(!isntRight) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}

		}
		
		bw.flush();

		br.close();
		bw.close();
	}
}

