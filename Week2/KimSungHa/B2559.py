# 문제: 2559번 수열
# 설명: 매일 측정한 온도가 정수 수열로 주어질 때, 연속된 K일의 온도 합 중 최댓값을 출력하라라

N, K = map(int,input().split()) # 공백으로 구분된 두 정수 입력

temps = list(map(int,input().split())) # 공백으로 구분된 온도들 리스트 화

daytemps = [] # 연속된 K일 간의 온도 합을 담을 빈 리스트

for i in range(N-K+1): # K일 연속 측정이 가능한 for문
    temp = 0    # 온도합 변수 초기화
    for j in range(K):  # K일간 각각의 온도를 더해,
        temp += temps[i+j]
    daytemps.append(temp)  # 온도 합 리스트에 추가

max_temp = 0

for j in daytemps:  # 온도 합 리스트 중 최댓값 갱신 루프프
    if max_temp<j:
        max_temp = j

print(max_temp)