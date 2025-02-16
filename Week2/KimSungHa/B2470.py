# 문제: 2470번 두 용액
# 설명: 양과 음의 정수로 이뤄진 값들 중 두 값의 합이 0과 가장 가까운 경우를 찾아라

N = int(input())
solutions = list(map(int,input().split()))

solutions.sort() # 크기 순으로 정렬

min1 = 0
min2 = 0
min_gap = abs(solutions[0]+solutions[1]) # 초기값 설정

for i in range(N):
    for j in range(i+1,N):  # 조합 찾기
        if min_gap>abs(solutions[i]+solutions[j]): # 초기값보다 현재의 두 쌍으로 만든 조합이 0과 더 가까우면
            min_gap = abs(solutions[i]+solutions[j])    # 대체 후 각 변수에 등록
            min1 = solutions[i]
            min2 = solutions[j]

print(min1, min2)

# 자꾸 시간 초과... 좀 더 효율적인 방법을 찾아야 하나