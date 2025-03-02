package hyochang;

import java.util.Arrays;
import java.util.Scanner;
public class B3040 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dwarf = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			dwarf[i] = sc.nextInt();
			sum += dwarf[i];
		}
		Loop:
		for(int i=0;i<9;i++) {//2명을 빼보고 100이 되면 0으로 만들고 루프 종료
			for(int j=i+1;j<9;j++) {
				if(sum-dwarf[i]-dwarf[j]==100) {
					dwarf[i]=0;
					dwarf[j]=0;
					break Loop;
				}
			}
		}
		Arrays.sort(dwarf);//정렬
		for(int i=2;i<9;i++) {//앞에 2개는 0일테니 2부터 출력
			System.out.println(dwarf[i]);
		}
	}
}