package Week4.nayoung; //백준 제출시 삭제 필수

import java.io.*;
import java.util.ArrayList;

//시간: 216ms
//메모리: 16564kb
public class B10448 {
    public static void main(String[] args) throws IOException {
        //유레카 이론
        // for문이 세 개여서 시간초과 삘...이었는데 안남. 왤까? 반복문 범위가 적어서인가?
        // 모든 경우를 다 봐야 해서 완전탐색인건가?
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); //tc 개수
        for(int tc=0;tc<t;tc++){
            int k = Integer.parseInt(br.readLine()); //3이상 1000이하
            boolean hasThree = isHasThree(k);

            if(hasThree){
                bw.write(1+"\n");
            }else{
                bw.write(0+"\n");
            }

        }//tc순회 끝

        bw.flush();
        bw.close();
        br.close();
    }//main

    //3개의 삼각수 합으로 표현될 수 있는 수인지 판단하는 메서드
    private static boolean isHasThree(int k) {
        ArrayList<Integer> arrList = new ArrayList<>();
        int n = 1;
        while((n*(n+1))/2 <= k){  //자연수 k보다 작은 삼각수를 빈 arrList에 다 넣기
            arrList.add((n*(n+1)/2));
            n++;
        }
//            System.out.println(arrList); //확인용 - 이후 주석 처리

        int sum = 0; //세 삼각수의 합
        boolean hasThree = false; //세 삼각수의 합으로 표현될 수 있는지 여부
        //arrList에서 뽑은 세 개의 수의 합이 k와 같은 경우 hasThree를 true로 바꾼 후 break. (이때 중복 허용이므로 반복문 시작점 겹침!!!)
        for(int i=0;i<arrList.size();i++){
            for(int j=0;j<arrList.size();j++){
                for(int m=0;m<arrList.size();m++){
                    sum = arrList.get(i) + arrList.get(j) + arrList.get(m); //세 삼각수의 합
                    if(sum== k){
                        hasThree = true;
                        break;
                    }
                }
            }
        }
        return hasThree;
    }
}
