# 문제: 10824번
# 설명: 네 자연수가 주어질 때 A,B를 이어 붙인 수, C,D를 이어 붙인 수의 합을 구하시오

# 입력 받아 문자열로 각각 언패킹
A,B,C,D = input().split()

# 받은 입력 값을 이어 붙인 수를 각각 int화
num1 = int(A+B)
num2 = int(C+D)

# 두 수의 합 출력
print(num1+num2)