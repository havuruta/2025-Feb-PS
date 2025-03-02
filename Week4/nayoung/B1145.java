package Week4.nayoung; //백준 제출시 삭제 필수

import java.io.*;
import java.util.StringTokenizer;

//시간:200ms
//메모리:	17528kb
public class B1145 {
    public static void main(String[] args) throws IOException {
        //적어도 대부분의 배수
        //주어지는 자연수가 100 이하의 자연수이므로 세 개의 곱은 최대 10^6
        //1~10^6의 각각의 수에 대해 5개 순회 돌면서 나눠지는지 확인해야하므로 10^6 * 5 : 1초 안에 충분할듯...!! 아마..?
        //1초에 1억번의 연산으로 어림잡으면 된다고 들음...!! 아마...? (@민기쌤 보신다면 확인 pls...)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //다섯 개의 자연수 입력
        int[] arr = new int[5];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<5;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        //적어도 세개 이상 나누어 떨어지는 수 중 가장 작은 자연수 찾기
        int min = Integer.MAX_VALUE; //적어도 대부분의 배수
        int cnt; //나누어 떨어지는 개수
        Loop:
        for(int i=1;i<=1000000;i++){
            cnt = 0; //수를 찾을 때마다 0으로 초기화
            for(int j=0;j<5;j++){    //자연수 배열 순회
                if(i/arr[j]>0 && i%arr[j]==0){
                    cnt++;
                }
            }
            //적어도 대부분의 배수 찾기
            if(cnt>=3 && min>i){
                min = i;
            }
        }

        bw.write(min+""); //결과 출력
        bw.flush();
        br.close();
        bw.close();


    }//main
}
