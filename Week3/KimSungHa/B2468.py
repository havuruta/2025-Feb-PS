# 문제: 2468번 안전영역
# 설명: 2차원 배열에서 일정량의 비가 내렸을 경우들 중 안전영역의 최대 갯수 확인

import sys
sys.setrecursionlimit(10**9)        # dfs 재귀 한계점 확장

def dfs(pos):   # dfs 재귀함수 정의
    x,y = pos   # 위치 언패킹
    visited[x][y] = 1   # 방문 체크
    for di, dj in [[0,1],[1,0],[0,-1],[-1,0]]:  # 델타 방향 탐색
        ni, nj = x+di,y+dj
        if ni<0 or ni>=N or nj<0 or nj>=N:  # 인덱스 밖이거나,
            continue
        if visited[ni][nj]==1:  # 방문 지점이라면 다음 탐색으로
            continue
        dfs([ni,nj])    # 아니라면 재귀귀

N = int(input())
ground = [list(map(int,input().split())) for _ in range(N)]
heightest = 0
for i in range(N):  # 최고 높은 지점 확인인
    for j in range(N):
        if heightest < ground[i][j]:
            heightest = ground[i][j]
max_safe = 0
rain = 0                # 비가 오지 않을 경우부터 체크크
while rain<heightest:   # 비가 최고 지점까지 오기 전까지. 최고 지점까지 오면 안전구역 0으로 의미없는 값이 나온다.
    visited = [[0]*N for _ in range(N)] # 매 반복마다 방문지점 초기화
    safe = 0
    for i in range(N):      # 비가 덮은 지역은 방문처리
        for j in range(N):
            if ground[i][j]<=rain:
                visited[i][j]=1
    for i in range(N):      # 바뀐 방문처리 배열에서 방문하지 않았으면 dfs으로 전부 덮으며 안전구역 하나 체크
        for j in range(N):
            if visited[i][j]==0:
                dfs([i,j])
                safe += 1
    max_safe = max(max_safe,safe)   # 구해진 안전구역 갯수와 현재까지 최대 안전구역 갯수 비교, 갱신
    rain +=1                        # 다음 수위로 반복

print(max_safe)