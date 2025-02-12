package nayoung;

import java.io.IOException;
import java.util.Scanner;

//단어 공부
public class B1157 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = sc.next(); //문자열 입력
        int[] count = new int[26]; //알파벳 카운팅배열

        for(int i=0;i<str.length();i++) {
            if(str.charAt(i)>='A' && str.charAt(i)<='Z') { //대문자면
                count[str.charAt(i)-'A']++; //'A'뺀 카운팅배열 인덱스의 값 +1
            }else if(str.charAt(i)>='a' && str.charAt(i)<='z') { //소문자면
                count[str.charAt(i)-'a']++; //'a'뺀 카운팅배열 인덱스의 값 +1
            }
        }

        int max = -1;
        int maxIdx = 0;
        boolean isOnly = true;
        for(int i=0;i<count.length;i++) {
            if(max<count[i]) { //최빈값 찾기
                max = count[i];
                maxIdx = i;
            }
        }

        for(int i=0;i<count.length;i++) {
            if(count[i]==max && i!=maxIdx) { //최빈값이 여러개 존재하는 경우 판별
                isOnly = false;
                break;
            }
        }

        if(isOnly==false){
            System.out.println("?");
        }else {
            System.out.println((char)(maxIdx+'A')); //int -> char 형변환
        }
    }
}
