package Week4.nayoung; //백준 제출시 삭제 필수

import java.io.*;

//시간:116ms
//메모리:15880kb
public class B1977 {
    public static void main(String[] args) throws IOException {
        //완전제곱수
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //M과 N은 10000이하의 자연수, M<=N
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        int cnt = 0; //완전제곱수의 개수
        int sum = 0; //완전제곱수의 합
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=100;i++){  // i*i가 1부터 10000사이
            if(M<=i*i && i*i<=N){ // i^2이 M과 N사이인 경우
                cnt++;            // 완전제곱수의 개수 +1
                sum += i*i;       // 완전제곱수의 합 누적
                if(min>i*i){      // 완전제곱수의 최솟값 갱신
                    min = i*i;
                }
            }
        }

        //완전제곱수가 없다면 -1 출력, 아니면 합과 최솟값 출력
        if(cnt==0){
            bw.write(-1+"");
        }else{
            bw.write(sum+"\n");
            bw.write(min+"\n");
        }

        br.close();
        bw.close();

    }//main 끝!
}
