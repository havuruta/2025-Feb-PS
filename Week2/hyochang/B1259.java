package hyochang;

import java.util.Scanner;

public class B1259 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        
        while (!str.equals("0")) {//0이 종료조건 

            boolean felindron = true;//펠린드롬확인
            
            for (int i = 0; i < (str.length() / 2); i++) {//양 끝에서 오니까 절반만
                if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                    felindron = false;
                    break;
                }
            }
            
            if (felindron)
                System.out.println("yes");
            else
                System.out.println("no");
            
            str = sc.nextLine(); 
        }

    }
}
