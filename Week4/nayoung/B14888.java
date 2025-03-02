package Week4.nayoung; //백준 제출시 삭제 필수

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

//시간 1460ms
//메모리 543964kb
public class B14888 {
    public static int[] arr; //피연산자 배열
    public static ArrayList<ArrayList<String>> opsList;
    public static String[] ops; //연산자 배열
    public static ArrayList<String> tmp; //sub 경우의 수 저장 배열리스트
    public static boolean[] visited; //방문 배열
    public static HashMap<Integer,String> opsMap;

    public static void main(String[] args) throws IOException {
        //연산자 끼워넣기
        //같은것이 있는 순열이지만...!! 굳이 같은것이 있는 경우를 제거할 필요 x. 결국 결과는 똑같기 때문. => 이걸로 2시간을 고민했지만... 다~~ 소용없었다...
        //중복불가(순열)는 백트래킹 시 N=10까지 가능이라고 함. 여기서 수의 개수가 11이므로 연산자 개수는 10개. 따라서 백트래킹 가능!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ops = new String[n-1]; //크기를 정해두지 않았지만 무조건 n-1개여야 함에 주의
        opsList = new ArrayList<>();
        visited = new boolean[n-1];
        opsMap = new HashMap<>();

        //opsMap 설정
        opsMap.put(0,"+");
        opsMap.put(1,"-");
        opsMap.put(2,"*");
        opsMap.put(3,"/");

        StringTokenizer st = new StringTokenizer(br.readLine());
        //비연산자 배열값 입력
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
//        System.out.println(Arrays.toString(arr));

        st = new StringTokenizer(br.readLine());
        //연산자 배열값 입력
        int idx = 0;
        for(int i=0;i<4;i++){ //연산자 종류는 항상 4개
            int opsCnt = Integer.parseInt(st.nextToken());
            for(int j=0;j<opsCnt;j++){
                ops[idx++] = opsMap.get(i);
            }
        }
//        System.out.println(Arrays.toString(ops));
//        System.out.println(idx);

        //메서드 호출 통해 가능한 모든 경우의 조합 구하기
        tmp = new ArrayList<>();
        recursion(n-1,0); //실행 후에 static 변수인 opsList 갱신됨. 개수는 연산자 개수인 n-1로 설정!!!
//        System.out.println(opsList.size());
//        System.out.println(opsList);

        //결과의 최댓값, 최솟값 구하기 : 연산자 우선 순위를 무시하고 앞에서부터 진행
        int max = Integer.MIN_VALUE; //최댓값
        int min = Integer.MAX_VALUE; //최솟값
        for(ArrayList<String> e: opsList){ //모든 가능한 경우의 수에 대해
            int res = arr[0]; //연산 결과 변수를 첫번째 피연산자 값으로 초기화하고 시작
            for(int i=0;i<n-1;i++){ //연산자 순회
                switch (e.get(i)){
                    case "+":
                        res += arr[i+1];
                        break;
                    case "-":
                        res -= arr[i+1];
                        break;
                    case "*":
                        res *= arr[i+1];
                        break;
                    case "/":
                        res /= arr[i+1];
                        break;
                }
            }//연산 끝
            if(max<res){
                max = res;
            }
            if(min>res){
                min = res;
            }
        }

        //결과 출력
        bw.write(max+"\n");
        bw.write(min+"");

        bw.flush();
        br.close();
        bw.close();
    }//main

    //일반적인 순열의 백트래킹 재귀 함수. 연산자 개수는 문제에서 주어진 n보다 1 작으므로 함수 호출 시 recursion(n-1, 0)으로 호출해야 함.
    public static void recursion(int n, int depth){
        if(depth==n){ //재귀종료조건
            opsList.add(new ArrayList<>(tmp)); // ✅ 순열 조합 배열리스트의 요소로 tmp의 복사본을 추가
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(ops[i]);
                recursion(n,depth+1);
                visited[i] = false; //백트래킹
                tmp.remove(tmp.size()-1);
            }
        }

    }

}
