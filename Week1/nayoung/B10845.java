package nayoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// B10845.java
// 문제 10845: 큐 - 정수를 저장하는 큐의 다양한 연산 구현.
public class B10845 {
    public static void main(String[] args) throws IOException {
        // 문제 10845 해결을 위한 코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrList = new ArrayList<>(); // 스택 배열 선언

        int n = Integer.parseInt(br.readLine()); // 명령의 수 n
        int i = 0;
        while(i<n){
            String input = br.readLine();
            String[] order = input.split(" ");  // 공백을 기준으로 명령어와 값을 분리
            switch(order[0]){
                case("push"):
                    int k = Integer.parseInt(order[1]);  // 'push' 명령어 뒤의 값을 읽어오고 int형으로 변환
                    arrList.add(k); // 스택에 값 추가
                    //System.out.println(arrList.get(arrList.size()-1));  // 확인용 출력 - 이후 주석 처리
                    break;
                case("pop"):
                    if(arrList.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(arrList.get(0)); // 비어있지 않다면 큐의 가장 앞에 있는 정수를 출력 후
                        arrList.remove(0); // 해당 값 삭제 후 뒤의 값들이 하나씩 땡겨짐
                    }
                    break;
                case("size"):
                    System.out.println(arrList.size());
                    break;
                case("empty"):
                    if(arrList.isEmpty()){
                        System.out.println(1);
                    }else{
                        System.out.println(0);
                    }
                    break;
                case("front"):
                    if(arrList.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(arrList.get(0)); // 비어있지 않다면 큐의 가장 앞에 있는 정수를 출력
                    }
                    break;
                case("back"):
                    if(arrList.isEmpty()){
                        System.out.println(-1);
                    }else{
                        System.out.println(arrList.get(arrList.size()-1)); // 비어있지 않다면 큐의 가장 뒤에 있는 정수를 출력
                    }
                    break;
            }
            i++;
        }
    }
}
