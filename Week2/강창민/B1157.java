package 강창민;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class B1157 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String word = br.readLine();
		
		//알파벳 나온 횟수 배열
		int[] count = new int[26];
		
		//전부 대문자로 변환
		word = word.toUpperCase();
		
		//단어길이만큼 순회
		for(int i = 0; i < word.length(); i++) {
			count[word.charAt(i)- 'A']++;
		}
		
		//최대로 나온 횟수, 알파벳 
		int maxAlphaCount = 0;
		char alpha = '?';
		
		//배열을 순회하며 비교
		for(int i = 0; i < 26; i++) {
			if(count[i] > maxAlphaCount) {
				maxAlphaCount = count[i];
				alpha = (char) (i + 'A');
			} else if (count[i] == maxAlphaCount) {
				alpha = '?';
			}
		}

		bw.write(String.valueOf(alpha));
		bw.flush();
		bw.close();
		br.close();
		
	}
}