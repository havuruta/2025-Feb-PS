package hyochang;

import java.util.Scanner;

public class B10448 {
	static int[] ureka;//삼각수 배열
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ureka=new int[44];//1000이 n=45에 넘어감
		for(int i=0;i<44;i++) {//배열 채우기
			ureka[i]=((i+1)*(i+2))/2;
		}
		int t = sc.nextInt();
		
		for(int tc=0;tc<t;tc++) {
			int k = sc.nextInt();
			boolean isureka=false;
			Loop:
			for(int i=0;i<44;i++) {
				for(int j=0;j<44;j++) {
					for(int o=0;o<44;o++) {//반복문 돌면서 찾으면 종료
						if(ureka[i]+ureka[j]+ureka[o]==k) {
							isureka=true;
							break Loop;
						}
					}
				}
			}
			if(isureka)
				System.out.println(1);
			else
				System.out.println(0);
		}
		
		
	}
}