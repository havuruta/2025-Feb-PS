# 문제: 1259번
# 설명: 문자를 입력받아 그 단어가 팰린드롬이면 yes, 아니면 no를 출력하시오
# 테스트 케이스로 볼 때, 0을 입력하면 반복 중단으로 보여 while로 구상

# word = input() 

# if word == '0': 
#     pass
# elif word == word[::-1]: 
#     print('yes')
# else:
#     print('no')

while True: # 이후 0을 받지 않았다면 반복
    word = input()  # 입력받은 단어 및 정수를 문자열로 할당

    if word == '0': # 0을 입력하면 중단이므로 첫 번째로 따져주고,
        break
    elif word == word[::-1]:    # 팰린드롬 여부 판단하여 조건 별 출력
        print('yes')
    else:
        print('no')


# 동일하게 두 문단을 쓰지 않고도 0이면 중단하는 루프를 만들 수 있을까? 해결!