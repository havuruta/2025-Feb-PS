package Week4.nayoung; //백준 제출시 삭제 필수

import java.io.*;

//시간: 424ms
//메모리: 225388kb (225mb) - 백준에 메모리 제한이 192kb로 적혀있었는데 통과되었다. HOW COME???!! 0o0
public class B2231 {
    public static void main(String[] args) throws IOException {
       //분해합
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int sum = 0; //분해합 선언 및 초기화
        int m = 1; //자연수 m의 분해합이 n인 경우, m을 n의 생성자라 한다. (245의 분해합은 245+2+4+5=256이므로 245는 256의 생성자)
        boolean hasConstructor = false; //생성자 유무를 판단
        while(m<=n){
            String strM = Integer.toString(m);
            sum = m; //분해합 초기화. m에서 시작해서 아래 for문 돌리면서 각 자리수 더할 것.
            for(int i=0;i<strM.length();i++){
                String subStr = String.valueOf(strM.charAt(i));
                sum += Integer.parseInt(subStr);
            }
            if(sum==n) {
                hasConstructor = true;
                break; //이거 해야지 가장 작은 생성자 구함
            }
            m++;
        }

        //결과 출력
        if(hasConstructor){
            bw.write(m+"");
        }else{ //생성자가 없다면 0 출력
            bw.write(0+"");
        }




        bw.flush();
        bw.close();
        br.close();

    }//main
}
