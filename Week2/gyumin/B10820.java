package gyumin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class B10820 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<>();
        String s;
        
        // 개수가 정해지지 않은 n개의 문자열을 입력받으려면 BufferedReader 에 null이 담기지 않을 때까지만 담으면 됨
        // 이클립스 환경 상에서 정상적으로 테스트가 되지 않아 문자열이 비었는지를 따로 확인하고 엔터 입력해서 테스트
        while((s=br.readLine()) != null && !s.isEmpty()) {
        	list.add(s);
        }
        
        for(int i = 0; i < list.size(); i++) {
        	int lower = 0;
        	int upper = 0;
        	int digit = 0;
        	int space = 0;
        	char[] temp = list.get(i).toCharArray();
        	for(int j = 0; j < temp.length; j++) {
        		// 아스키 코드를 이용해서 조건 확인
        		// Character.isLowerCase()
        		if('a' <= temp[j] && temp[j] <= 'z') {
        			lower++;
        		// Character.isUpperCase()
        		} else if('A' <= temp[j] && temp[j] <= 'Z') {
        			upper++;
        		// Character.isDigit
        		} else if('0' <= temp[j] && temp[j] <= '9') {
        			digit++;
        		// 공백 확인
        		} else if(temp[j] == ' ') {
        			space++;
        		}
        	}
        	
        	System.out.printf("%d %d %d %d\n", lower, upper, digit, space);
        }
        
        br.close();
    }
}
