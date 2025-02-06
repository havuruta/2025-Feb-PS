import java.util.Scanner;
// B1978.java
// 문제 1978: 소수 찾기 - 주어진 숫자 중 소수의 개수를 계산.
public class B1978 {
	// 문제 1978 해결을 위한 코드를 작성하세요.
	public static void main(String[] args) {
		
    
		Scanner sc = new Scanner(System.in);
		
        // 숫자의 개수 n개 받아줌.
		int n = sc.nextInt();

        // 몇개인지 세서 출력할 변수
		int count  = 0;
        
        //n보다 작을 때 까지 반복
		for(int i = 0 ; i<n; i++) {

            // 판별할 숫자 a를 입력 받음.
			int a = sc.nextInt();

            //나누어 떨어지는 수가 몇 개 인지 체크할 temp 선언 및 초기화
			int temp = 0;
            
            // 소수는 1과 자기 자신을 약수로 가지는 수 그러므로, 1부터 n까지 반복을 돌면서 나누어 떨어지는 수가 더 있는지 체크하는거임.
			for(int j = 1; j <=a; j++) {

                // 나누어 떨어지면 temp 증가.
				if(a % j == 0) {
					temp++;
				}
			}

            // 위의 반복이 끝난 시점에 temp가 2이다? 그럼 약수임 ㅎㅎ
			if(temp == 2) {

                //카운트 증가.
				count ++;
			}
		}

        // 출력 \^_^/
		System.out.println(count);
		
	}
}
