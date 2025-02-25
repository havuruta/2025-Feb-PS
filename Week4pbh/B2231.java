package Week4pbh;


import java.util.Scanner;

public class B2231 {
    public static void main(String[] args) {
        //몇 주전에 푼거라 기억이 가물 가물
        Scanner sc = new Scanner(System.in);

        String number = sc.next();

        int numberChange = Integer.parseInt(number);
        //이 당시에 범위를 설정할 때 생성자는 기존 수+그 수의 각 자리의 합이기 때문에 가장 작은 생성자의 범위가
        //각 자리수가 9일 때보다 작을 수는 없다고 생각해서  이렇게 한듯 ex)입력값이 3자리인 경우에 그 값보다 27 이상 작으면 생성자가 될 수 없음
        int Range = 9 * number.length();
        int result = 0;
        //입력값의 범위가 1000000까지라 탐색 범위는 최대 63
        for (int i = numberChange - Range; i < numberChange; i++) {
            int temp = i;
            int sum = 0;

            //탐색범위의 분해함을 구함
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            //입력값이 일치하면 저장 하고 아니면 0
            if (sum + i == numberChange) {
                result = i;
                break;
            } else {
                result = 0;
            }
        }
        System.out.println(result);
    }
}
