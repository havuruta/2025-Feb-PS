import java.util.Scanner;
// B1546.java
// 문제 1546: 평균 - 점수를 조작하여 새로운 평균 계산.
public class B1546 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        
        // 일단 몇 과목인지 받아줌. 이게 곧 배열의 길이
		int len = sc.nextInt();

        // 최대값이랑, 합한 값 저장을 위한 변수 두개 선언 및 초기화
		double max = 0;
		double sum = 0;


        // 배열 초기화
		double arr[] = new double[len];

        //길이만큼 반복 돌면서 값 넣으면서 동시에 그냥 맥스값까지 조 1 져 버 림.
		for(int i = 0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] >= max) {
				max = arr[i];
			}
		}


        // 문제에 나와있는 공식대로 값을 바꿔준 후 sum에 더햄.
		for(int i = 0; i<arr.length; i++) {
			arr[i] = arr[i] / max * 100;
			sum = arr[i] + sum;
		}

        // 길이로 나눠주면 그ㅑ냐아아아아아아아아앙 조작 점수의 평균.
		System.out.println(sum/len);
        
	}

	
	
}

