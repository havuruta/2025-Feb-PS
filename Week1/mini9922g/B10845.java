package mini9922g;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;

// B10845.java
// 문제 10845: 큐 - 정수를 저장하는 큐의 다양한 연산 구현.
public class B10845 {
	public static void main(String[] args) throws IOException {

		Deque<Integer> queue = new LinkedList<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//명령 개수 입력받기
		int count = Integer.parseInt(br.readLine());
		
		//명령 수만큼 반복
		for(int i = 0; i < count; i++) {
			
			//명령 입력받기
			String line = br.readLine();
			
			//push포함시 line에서 숫자부분만 분리해서 덱에 추가
			if(line.contains("push")) {
				int number = Integer.parseInt(line.substring(5));
				queue.add(number);
				
				//pop일경우 비어있으면 -1출력 아니면 제거후 출력
			} else if(line.equals("pop")) {
				if(queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(queue.remove() + "\n");
				}
				
				//size일 경우 크기를 출력
			} else if(line.equals("size")) {
				bw.write(queue.size() + "\n");
				
				//비어있을경우 1출력 아닐경우 0 출력
			} else if(line.equals("empty")) {
				if(queue.isEmpty()) {
					bw.write("1\n");
				} else {
					bw.write("0\n");
				}
				//가장 앞에 있는 정수를 출력, 비어있을경우 -1출력
			} else if(line.equals("front")) {
				if(queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(queue.peek() + "\n");
				}
				
				//입력이 back일 경우 가장 뒤에있는 정수 출력, 비어있을경우 -1 출력
			} else {
				if(queue.isEmpty()) {
					bw.write("-1\n");
				} else {
					bw.write(queue.getLast() + "\n");
				}
			}
 		}
		bw.flush();
		bw.close();
		
	}
}
