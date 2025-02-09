package nayoung;
// B10809.java
// 문제 10809: 알파벳 찾기 - 각 알파벳의 첫 등장 위치를 출력.
import java.util.Arrays;
import java.util.Scanner;

public class B10809 {
    public static void main(String[] args) {
        // 문제 10809 해결을 위한 코드를 작성하세요.
        Scanner sc = new Scanner(System.in);

        String my_string = sc.next();
        int[] arr = new int[26];
        Arrays.fill(arr,-1); //기본값을 -1로 초기화

        // 각각의 알파벳이 처음 등장하는 위치가 있으면 해당 인덱스는 배열에 넣은 후 내부 for문을 빠져나온다.
        for(int i=0;i<my_string.length();i++){
            for(int j=0;j<arr.length;j++){
                if(my_string.charAt(i)==j+97&&arr[j]==-1){  // 해당 알파벳이 처음 등장하는 경우만!!
                    arr[j]=i;
                    break;
                }
            }
        }

        // 배열 출력하기
        for(int j=0;j<arr.length;j++){
            System.out.print(arr[j]+" ");
        }
    }
}
