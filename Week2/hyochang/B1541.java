package hyochang;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class B1541 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();

		List<Object> list = new ArrayList<>();//문자(char)와 숫자(integer)를 담음
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {//숫자면
				int k = 1;
				String temp = String.valueOf(str.charAt(i));
                //숫자형이면 뒤에 붙어있는 숫자를 모두 받고
                //범위 내에서 모든 숫자를 합침| -,+를 만나면 종료
				while (i + k < str.length() && str.charAt(i + k) != '+' && str.charAt(i + k) != '-') {
					temp += String.valueOf(str.charAt(i + k));
					k++;
				}
				list.add(Integer.parseInt(temp));
				i += k - 1;//0~k-1까지 확인하였으므로 +
			} else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
				list.add(str.charAt(i));
			}
		}
		
		int result = (int) list.get(0);
        //처음은 숫자이니까 넣음 object라 캐스팅(int)이 없으면 넣을 수 없음

		boolean check = true;
        //-이후의 수들을 더해서 빼야 최솟값이 나옴 그걸 판단하기 위한 boolean

		for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals('-')) { // '-'를 만나면 이후 숫자들은 모두 빼야하니 false
                check = false;
            } else if (list.get(i).equals('+')) {//'+'는 연산에 영향이 없음->다음 숫자로 이동
                continue;
            } else {
                int num = (int) list.get(i);
                if (check) { // '-'를 만나기 전까지는 숫자를 계속 더함
                    result += num;
                } else { // '-'를 만난 이후의 모든 숫자를 뺌
                    result -= num;
                }
            }
        }
        
		System.out.println(result);
	}
}