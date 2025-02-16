package nayoung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//8진수 2진수
public class B1212 {
    public static void main(String[] args) throws IOException {
        // 가능하면 500ms 이내로 풀어봅시다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // BufferedReader 사용

        StringBuilder res = new StringBuilder(); // StringBuilder 선언

        // 8진수 입력 받기
        String octal = br.readLine(); // 8진수 문자열을 입력받고, 공백 제거

        // 8진수에서 각 자리를 이진수로 변환하여 StringBuilder에 추가
        for (int i = 0; i < octal.length(); i++) {
            int subNum = Integer.parseInt(String.valueOf(octal.charAt(i))); // 8진수 문자 -> 숫자

            // 각 자리를 이진수로 변환해서 StringBuilder에 추가
            res.append(subNum / 4 == 1 ? "1" : "0");  // 첫째 자리
            res.append((subNum % 4) / 2 == 1 ? "1" : "0"); // 둘째 자리
            res.append((subNum % 4) % 2 == 1 ? "1" : "0"); // 셋째 자리
        }

        // 최종 이진수 값 출력
        // "011"을 parseInt해주면 11로 바뀌는 방식, 매개변수는 String이어야 하므로 StringBuilder -> String으로 바꿔줌.
//        System.out.println(Integer.parseInt(res.toString())); // 이진수를 정수로 변환하여 출력 -> 이 경우 int 자리수를 훨씬 벗어나는 수에 대한 런타임오류남

        // 결과 문자열의 선행 0 제거
        String binaryResult = res.toString().replaceAll("^0+", "");

        // 이진수가 비어있다면 "0"을 출력
        if (binaryResult.isEmpty()) {
            System.out.println(0);
        } else {
            // 이진수 결과 그대로 출력 (문자열로)
            System.out.println(binaryResult);
        }
        br.close();
    }
}

