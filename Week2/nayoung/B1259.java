package nayoung;

import java.io.IOException;
import java.util.Scanner;

//팰린드롬수
public class B1259 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) { // 무한반복
            String str = sc.next(); // 문자열 입력
            if (str.equals("0"))
                break; // (무한반복종료조건) 0 입력받으면 반복문 break;
            else {
                int len = str.length(); // 문자열 길이
                boolean isPal = true; // 팰린드롬수인지 저장하는 변수

                //팰린드롬 체크
                for (int i = 0; i < len / 2; i++) { //중앙값 전까지만 탐색 -> 반복문 최적화
                    if (str.charAt(i) != str.charAt(len - 1 - i)) { //중앙값 전과 후의 값이 동일하지 않다면
                        isPal = false; //팰린드롬수가 아니므로 false 저장 후 break
                        break;
                    }
                }

                //결과 출력
                if (isPal) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
        }
    }
}
