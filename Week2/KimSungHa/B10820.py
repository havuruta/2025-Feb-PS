# 문제: 10820번
# 설명: 주어진 문자열에 포함된 소문자, 대문자, 숫자, 공백의 갯수를 각각 계산합니다.

while True:
    try:        # 종료 조건을 주지 않았으므로 try except 사용.
        word = input()      # 문자 입력과 체크해야할 갯수 0으로 할당
        lower = 0
        upper = 0
        digit = 0
        vaccancy = 0

        for i in word:          # 문자 전체를 돌며 각각을 찾으면 해당 변수에 +1
            if i.islower():
                lower +=1
            elif i.isupper():
                upper +=1
            elif i.isdigit():
                digit +=1
            elif i == ' ':
                vaccancy +=1

        print(lower, upper, digit, vaccancy)    # f-string없이도 요구 조건에 부합하도록 출력된다.
    except:
        break