import java.util.Scanner;
public class B2566 {

   public static void main(String[] args) {
      
     Scanner sc = new Scanner(System.in);

     // 9x9 라니까는..
     int[][] arr = new int[9][9];
     

     // 최대값이랑, 최대값일때의 max와 row를 저장해야하니 초기화같이해줌.
     int max = 0;
     int row = 0;
     int column = 0;
     for(int i = 0; i<9; i++) {
    	 for(int j = 0; j<9; j++) {
    		 arr[i][j] = sc.nextInt();
    		 if(arr[i][j] > max) {
    			max = arr[i][j];
    			row = i;
    			column = j;
    		 }
    	 }
     }
     System.out.println(max);
     System.out.print((row+1) + " " + (column+1));
     
     
     
      
   }

}