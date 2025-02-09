import java.util.Scanner;
// B11050.java
// 문제 11050: 이항 계수 1 - 주어진 N과 K로 이항 계수 계산.
public class B11050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
        //N과 K를 받아줌.
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		
        // 이항계수는 Combination의 결과 값인가봄.... 나는 그렇게 이 해 했 음.. ㅠ 
        // 그래서 일단 분자를 선언 및 초기화해 줌 0이되면 n!했을 때 0을 곱해버리면 
        // 말짱 도루묵아저씨니까 1로 초기화
		int ja = 1;
		
        // 굳이 1은 곱할 필요 없으니까 2부터 n까지 반복돌면서 곱해줌.
		for(int i =2 ; i<=n; i++) {
			ja *=i;
		}

        //이제 분모 차례 ㅠㅠ
		int mo = 1;
		
        // 분모는 (n-k)! * k! 그래서 먼저 n-1! 해준 후 k! 해줌!
		for(int i = 2; i<=n-k; i ++) {
			mo *= i;
		}
		
		for(int i = 2; i<=k; i++) {
			mo *= i;
		}
		
        // 나누면 끝 ㅠ
		System.out.println(ja/mo);
		
		
	}

}
