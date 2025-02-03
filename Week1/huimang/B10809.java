
// B10809.java
// 문제 10809: 알파벳 찾기 - 각 알파벳의 첫 등장 위치를 출력.

import java.util.Scanner;
public class B10809 {
    public static void main(String[] args) {
        // 문제 10809 해결을 위한 코드를 작성하세요.
        
        //입력을 위한 객체
        Scanner sc = new Scanner(System.in);
        
        //출력을 위한 객체.
        StringBuilder sb = new StringBuilder();
        // 문자열 입력을 받기 위한 str 변수 선언
        String str = sc.next();

        // 알파벳 등장 위치를 저장할 배열 -> a to z 까지 등장 위치 저장.
        int[] arr = new int[26];

        // 미리 -1로 값 변경
        for(int i = 0; i<arr.length; i++) {
            arr[i] = -1;
        }

        //문자열 길이만큼 반복 돌면서 해당 알파벳의 인덱스 저장.
        for(int i = 0; i<str.length(); i++) {
            // 'a' = 97; 그러니 97 뺌.
            int idx = str.charAt(i) - 97;

            // 처음 등장하는 위치를 저장해야하닝~
            if(arr[idx] == -1) {
                arr[idx] = i; 
            }
            
            
        }
        

        // sb에 담고
        for(int x : arr) {
            sb.append(x + " ");
        }


        // 출력
        System.out.println(sb.toString().trim());




    }
}
