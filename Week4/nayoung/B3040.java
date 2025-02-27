package Week4.nayoung; //백준 제출시 삭제 필수

import java.io.*;

//시간: 100ms
//메모리: 14068kb
public class B3040 {
    public static void main(String[] args) throws IOException {
        //백설공주와 일곱난쟁이
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //난쟁이 모자 숫자 입력 + 9명 모자 숫자의 총합 구하기
        int[] arr = new int[9];
        int nineSum = 0;
        for(int i=0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
            nineSum += arr[i];
        }

        //가짜 두명 찾기
        int subSum = 0; //가짜 두명의 모자 숫자 합
        int fake1 = -1; //가짜1번 인덱스
        int fake2 = -1; //가짜2번 인덱스

        Loop:
        for(int i=0;i<9;i++){
            for(int j=i+1;j<9;j++){
                subSum = arr[i] + arr[j];
                if(nineSum - subSum == 100){ //9명 합에서 가짜두명합 뺀 게 100이면 나머지가 진짜!!
                    fake1 = i;
                    fake2 = j;
                    break Loop; //찾으면 반복문 전체 빠져나가기(항상 답이 유일한 경우만 입력으로 주어지므로!)
                }
            }
        }
//        System.out.println(fake1+" "+fake2); //인덱스 확인용 - 이후 주석 처리

        //
        for(int i=0; i<9; i++){ //처음에 이 조건에 i!=fake1 && i!=fake2 넣었더니 해당 조건이 성립되지 않으니 반복문이 바로 실행중단됨
            if(i!=fake1 && i!=fake2){ //조건을 아래 써야한다...!!
                System.out.println(arr[i]);
            }
        }

        br.close();
        bw.close();
    }//main
}
