package 이창열;

import java.util.Scanner;

// 단어 공부
public class B1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			
			// 카운팅 배열
			int[] cnt = new int[26];
			
			boolean isOk = true;
			
			char maxChar = '?';
			
			int max = Integer.MIN_VALUE;
			
			for(int i = 0; i < str.length(); i++) {
				
				char c = str.charAt(i);
				
				// 나오는 문자 개수 세기
				if(Character.isLetter(c)) {
					c = Character.toUpperCase(c);
					cnt[c - 'A']++; 
				}
			}
				
			// 가장 많이 나온 것 세기
			for(int j =0; j < cnt.length; j++) {
				if(cnt[j] > max) {
					max = cnt[j];
					maxChar = (char)(j + 'A');
					isOk = true;
				}
				else if(cnt[j] == max) {
					isOk = false;
				}
			}
			if(!isOk) {
				System.out.println("?");
			}
			else {
				System.out.println(maxChar);
			}
		}
	} //end of main
} // end of class
