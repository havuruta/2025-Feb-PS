package mini9922g;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

// B1920.java
// 문제 1920: 수 찾기 - 배열 내 특정 정수의 존재 여부 확인.
public class B1920 {
    public static void main(String[] args) throws IOException {
        // 문제 1920 해결을 위한 코드를 작성하세요.
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	
    	//자연수 개수
    	int arrCount = Integer.parseInt(br.readLine());
    	
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	//자연수 배열
    	int[] numbers = new int[arrCount];
    	
    	//자연수 입력받기
    	for(int i = 0; i < arrCount; i++) {
    		numbers[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	//자연수 배열 정렬
    	Arrays.sort(numbers);
    	
    	//찾아볼 숫자의 개수
    	int findNumCount = Integer.parseInt(br.readLine());
    	
    	//찾아볼 숫자 배열
    	int[] findNumbers = new int[findNumCount];
    	
    	//찾아볼 숫자 입력받기
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < findNumCount; i++) {
    		findNumbers[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	//findNumber 메서드를 통해서 숫자 찾고 결과 저장하기
    	for(int i = 0; i < findNumCount; i++) {
    		if(findNumber(numbers, findNumbers[i])) {
    			System.out.println(1);
    		} else {
    			System.out.println(0);
    		}
    	}
    	
    	
    }
    
    //숫자 찾기 메서드 (숫자배열, 찾아야할 수)
    public static boolean findNumber(int[] numbers, int x) {
    	
    	//배열의 길이가 0 이면 숫자 없음
    	if(numbers.length == 0) {
    		return false;
    	}
    	
    	//배열의 중간값찾기
    	int midIdx = numbers.length / 2;
    	
    	//중간이 찾는 숫자일 경우 true반환
    	if(numbers[midIdx] == x) {
    		return true;
    		//중간이 찾아야할 숫자보다 작을경우 배열의 중간값 기준 오른쪽만 새로 복제
    	} else if (numbers[midIdx] < x) {
    		int[] newNumbers = new int[numbers.length - midIdx-1];
    		for(int i = 0; i < numbers.length - midIdx-1; i++) {
    			newNumbers[i] = numbers[midIdx+1+i];
    		}
    		//새로만든 배열과 찾아야할 수로 다시 메서드 호출
    		return findNumber(newNumbers, x);
    		
    		//if (numbers[midIdx] > x) 배열의 중간이 찾아야할 수보다 클 경우 중간값 기준 왼쪽만 복제
    	} else {
    		int[] newNumbers = new int[midIdx];
    		for(int i = 0; i < midIdx; i++) {
    			newNumbers[i] = numbers[i];	
    		}
    		//새로만든 배열과 찾아야할 수로 다시 메서드 호출
    		return findNumber(newNumbers, x);
    	}
    }
}
