package 진효창;
import java.util.Scanner;

// B10809.java
// 문제 10809: 알파벳 찾기 - 각 알파벳의 첫 등장 위치를 출력.
public class B10809 {
	public static void main(String[] args) {
		// 문제 10809 해결을 위한 코드를 작성하세요.

		Scanner sc = new Scanner(System.in);
		String A = sc.next();

		int[] inputArr = new int[A.length()];//글자 길이만큼 int 배열 생성
		for (int i = 0; i < A.length(); i++) {
			inputArr[i] = A.charAt(i) - 97; //int로 적으면 알파벳에 해당하는 아스키 코드로 변환됨 (a=97)
		}

		int[] arr = new int[26];
		for (int i = 0; i < 26; i++) {//a-z까지를 표현할 배열 생성
			arr[i] = -1;//없는 경우 -1
		}
		for (int j = 0; j < A.length(); j++) {
			if (arr[inputArr[j]] == -1) {//최초로 있던 위치에 선언해야하니까(없으면 baekjoon의 경우에 두번째o인 6이 출력이 됨) 
				arr[inputArr[j]] = j;//변환된 값은 각 알파벳의 순서를 나타내므로 알파벳을 담을 배열에 인덱스가 되고, j는 해당 알파벳의 최초 선언 위치가 됨 ex) b-> input[0]=1 
			}
		}
		for (int a : arr) {
			System.out.print(a + " ");
		}

	}

}