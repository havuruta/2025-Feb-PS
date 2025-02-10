package nayoung;
// B1546.java
// 문제 1546: 평균 - 점수를 조작하여 새로운 평균 계산.
import java.util.Scanner;

public class B1546 {
    public static void main(String[] args) {
        // 문제 1546 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();  //과목 개수 n
        int[] arr = new int[n];  //개별 점수 저장하는 배열
        int max = 0; //최댓값 저장 위한 변수
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();  //개별 점수 입력
            if(arr[i]>max){
                max = arr[i];
            }
        }

        double sum = 0;  //총합 저장 위한 변수 선언 및 초기화
        for(int i=0;i<n;i++){
            sum += (double) arr[i]/max * 100; //실수로 형변환
        }

        // 평균 구하기
        System.out.println(sum/n);
    }
}
