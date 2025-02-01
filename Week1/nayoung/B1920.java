package nayoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// B1920.java
// 문제 1920: 수 찾기 - 배열 내 특정 정수의 존재 여부 확인.
public class B1920 {
    public static void main(String[] args) throws IOException {  //입출력 예외 처리
        // 문제 1920 해결을 위한 코드를 작성하세요.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 모든 정수의 범위가 2^(-31) ~ 2^(31)이므로 정수 타입을 int(4byte=32bit)로 지정
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 빠른 검색을 위해 HashSet으로 배열 생성
        // HashSet은 자바에서 제공하는 Set 인터페이스의 구현체 중 하나로, 중복을 허용하지 않는 자료구조이다.
        // 순서를 보장하지 않는다. 순서가 중요한 경우에는 LinkedHashSet을 사용해야 한다.
        // HashSet을 사용하면 평균 O(1) 시간 복잡도로 contains 연산을 수행할 수 있다.
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine()); // 모든 정수의 범위가 2^(-31) ~ 2^(31)이므로 정수 타입을 int(4byte=32bit)로 지정
        st = new StringTokenizer(br.readLine()); // st를 초기화

        // m개의 각 원소에 대해 set에서 존재 여부를 확인
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (set.contains(num)) {  // HashSet의 contains() 메서드는 평균적으로 O(1) 시간 복잡도를 가진다.
                System.out.println(1);  // 존재하면 1 출력
            } else {
                System.out.println(0);  // 존재하지 않으면 0 출력
            }
        }
    }
}