package problem;

import java.io.IOException;
import java.util.Scanner;

public class B1259 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
		
        // 입력이 0 누를때까지 이니까 while문을 반복합니다.
		while (true) {
			int input = sc.nextInt(); // 처음에 숫자로 받습니다.
			String num = Integer.toString(input); // 이게 펠롬드린수를 확인하려면 숫자를 문자열로 바꿉니다.
			int N = num.length(); // 이건 String의 길이를 변수에 저장해놓습니다.
			char[] c = num.toCharArray(); // 받은 정수를 문자열로 바꾼 것을 하나의 문자배열에 넣습니다.
			boolean isOk = true; // 이건 펠롬드린 수가 맞나? 확인하는 flag역할입니다.
			
			for (int i = 0; i < N/2; i++) { // 맨끝 처음 그리고 2번째 맨마지막-1번째 확인을 하기 위해 결국 전체길이의 반만 돌면 됩니다.
				if (c[i] != c[N-1-i]) { // 이걸로 처음과 끝을 확인합니다.
					isOk = false; // 만약 처음과 끝이 다르면 더 확인할 필요도 없으니까 isOk를 false로 만들어줍니다.
					break;    // 펠롬드린 수가 아닌 친구는 isOk를 false로 반환합니다
				}
			}
			if (isOk && input != 0) { // 결국 출력을 하려면 isOk가 true여야 펠롬드린 수이므로 true와 0이 아니면 이를 실행합니다.
				System.out.println("yes");
			} else if (isOk == false && input != 0){ // 위와 비슷한 매커니즘입니다.
				System.out.println("no");
			}
			
			
			
			if (input == 0) {
				break;
			}
		}
    }
}
