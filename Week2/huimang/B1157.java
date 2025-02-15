import java.util.Scanner;

public class B1157 {
    public static void main(String[] args) {

        
		Scanner sc = new Scanner(System.in);
		
        //입력 받고 걍 다 대문자로 바꿔버령
		String str1 = sc.next();
		String str = str1.toUpperCase();

        // 그 다음 카운트 배열 하나 맹글어서 시작할꺼임.
		int count[] = new int[26];


        // 가장 많이 등장한게 몇 번인지를 담을 변수
		int max = -10000;

        //그렇게 했을 때 가장 많이 등장한 수가 몇번째에 있는지 체크할 변수!
		int index = 0;

        //카운트 배열 값 증가 시켜주고
		for(int i = 0; i<str.length(); i++) {
			for(char alpha = 'A'; alpha<'Z'+1; alpha++) {
				if(str.charAt(i) == alpha) {
					count[alpha-65] += 1;
				}
			}
		}
        
        // 그 중에 가장 큰거 찾아냄.
		for(int i = 0; i<count.length;i++) {
			if(count[i]>max) {
				max=count[i];
				index = i;
                
			} 
		}

        // 가장 큰걸 찾았는데, 이 값과 같은게 여러개인지 검사. (1까지는 ㄱㅊ 어차피 만나거든 ㅎㅎ)
        int cnt = 0;
        for(int i = 0; i<count.length; i++) {
            if(count[i] == max) {
                cnt++;
            }
        }

        //그래서 1이 아니다? 그럼 잘못된거임 ㅡ..ㅡ 아니며눈 출력.
		if(cnt == 1) {
			System.out.println((char)(index+65));
		} else {
			System.out.println("?");
		}
	}

}
