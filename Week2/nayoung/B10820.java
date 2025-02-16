package nayoung;

import java.io.IOException;
import java.util.Scanner;

//문자열 분석
public class B10820 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) { //자바 스캐너 다음줄 있을 때까지
            String str = sc.nextLine(); // 공백 포함 문자열 출력
            int[] count = new int[4]; // 소문자, 대문자, 숫자, 공백 순으로 빈도수 담은 카운팅 배열

            for(int i=0;i<str.length();i++) {
                if(str.charAt(i)>='a' && str.charAt(i)<='z') { //해당 캐릭터가 소문자에 해당 시
                    count[0]++;
                }else if(str.charAt(i)>='A' && str.charAt(i)<='Z') { //해당 캐릭터가 대문자에 해당 시
                    count[1]++;
                }else if(str.charAt(i)>='0' && str.charAt(i)<='9') { //해당 캐릭터가 숫자에 해당 시
                    count[2]++;
                }else if(str.charAt(i)==' ') { //해당 캐릭터가 공백에 해당 시
                    count[3]++;
                }
            }

            for(int i=0;i<count.length;i++) { //카운트 배열 출력
                System.out.print(count[i]+" ");
            }
            System.out.println();
        }


    }
}
