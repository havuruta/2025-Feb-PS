package problem;

import java.util.Scanner;

public class B1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        while (true) {
            String str=sc.nextLine();
            if(str.equals("0"))//종료 조건
            break;
            
            boolean felindron = true;
            
            for (int i = 0; i < (str.length() / 2); i++) {//문자열의 시작과 끝에서 올 거니까 반으로만
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {//서로 다르면 false로
                    felindron = false;
                    break;//다르면 탐색 종료
                }
            }
            
            if (felindron)
                System.out.println("yes");
            else
                System.out.println("no");
            
        }

    }
}