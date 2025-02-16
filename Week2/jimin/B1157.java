// 문제 : 백준 1157 단어 공부 (브론즈1)
// 해석 : 알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램(대,소문자 구분 X)
// 링크 : https://www.acmicpc.net/problem/1157

package jimin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class B1157 {
    public static void main(String[] args) throws IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine().toUpperCase(); // 대소문자 구분 X -> 다 대문자로 변환
		Map<Character, Integer> map = new HashMap<>();
		
		for(char ch : str.toCharArray()) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		
		int max = 0; // 최대값
		char maxChar = '?'; // 최빈 문자
		boolean isDuplicated = false; // 중복 여부
		
		for(Map.Entry<Character, Integer> entry : map.entrySet()) {
			if(entry.getValue() > max) {
				max = entry.getValue(); // 현재 최댓값 업데이트
				maxChar = entry.getKey(); // 현재 최빈 문자 업데이트
				isDuplicated = false; // 새로운 최댓값이 등장했으므로 중복 초기화
			} else if(entry.getValue() == max) {
				isDuplicated = true; // 최빈 문자가 여러 개일 경우 중복 체크
			}
		}
		bw.write(isDuplicated ? '?' : maxChar);
		
		br.close();
		bw.flush();
		bw.close();
    }
}
