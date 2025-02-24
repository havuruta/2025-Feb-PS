# 문제: 2667번 단지번호 붙이기
# 그래프의 델타 인접을 상정하고 dfs및 bfs로 결과 도출
# 연습을 위해 두 방법 모두 적용하였음

# bfs를 위한 설치
from collections import deque

#네 지점을 순회할 델타값
#우, 하, 좌, 상
di = [0, 1, 0, -1]
dj = [1, 0, -1, 0]

#dfs 함수 재귀
def dfs(r, c, matrix, visited):
    visited[r][c] = 1 # 방문했음
    global apt_num
    apt_num += 1
    # 네 방향 탐색
    for k in range(4):
        if 0 <= r+di[k] < N and 0 <= c+dj[k] < N and matrix[r+di[k]][c+dj[k]] == 1 and visited[r+di[k]][c+dj[k]] == 0:
            dfs(r+di[k], c+dj[k], matrix, visited)

#bfs 함수 Queue
def bfs(r, c, matrix, visited):
    q = deque()
    global apt_num
    apt_num = 1
    visited[r][c] = 1 #방문했음
    q.append([r,c])
    while q:
        cur_pos = q.popleft()
        #네 방향 탐색
        for k in range(4):
            if 0 <= cur_pos[0]+di[k] < N and 0 <= cur_pos[1]+dj[k] < N and matrix[cur_pos[0]+di[k]][cur_pos[1]+dj[k]] == 1 and visited[cur_pos[0]+di[k]][cur_pos[1]+dj[k]] == 0:
                visited[cur_pos[0]+di[k]][cur_pos[1]+dj[k]] = 1
                apt_num += 1
                q.append([cur_pos[0]+di[k], cur_pos[1]+dj[k]])


N = int(input())
matrix = [list(map(int,input())) for _ in range(N)]
visited = [[0] * N for _ in range(N)] #방문여부
result = [] #단지 내 아파트의 개수(apt_num)를 결과적으로 넣을 리스트

# 전체 matrix를 돌면서(dfs)
for r in range(N):
    for c in range(N):
        if matrix[r][c] == 1 and visited[r][c] == 0:
            apt_num = 0
            dfs(r, c, matrix, visited)
            result.append(apt_num)

#출력 형태
print(len(result))
result.sort()
for num in result:
    print(num)

# 전체 matrix를 돌면서(bfs)
for r in range(N):
    for c in range(N):
        if matrix[r][c] == 1 and visited[r][c] == 0:
            apt_num = 0
            bfs(r, c, matrix, visited)
            result.append(apt_num)

#출력 형태에 맞추기
print(len(result))
result.sort()
for num in result:
    print(num)