import java.util.Scanner;
public class B2738 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        // 행렬의 크기 N and M
		int N = sc.nextInt();
		int M = sc.nextInt();
		

        // 행렬 선언 및 초기화
		int[][] aArr = new int[N][M];
		int[][] bArr = new int[N][M];
		
		int[][] result = new int[N][M];
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				aArr[i][j] = sc.nextInt();
				
				
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				bArr[i][j] = sc.nextInt();
				
			}
		}
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				result[i][j] = aArr[i][j] +  bArr[i][j];
			}
		}
		
		for(int i = 0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				System.out.print(result[i][j]+" ");
			}
			System.out.println();
		}
	}

}
