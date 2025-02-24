# 문제: 2606번 바이러스
# 설명: 비방향성 그래프를 입력받고 지점 기준 완전탐색을 통해 정답 도출

def dfs(v):     # dfs 함수. v는 시작점
    visited[v]=1    # 함수 시작과 함께 방문지점 체크
    for i in range(1,N+1):  # N의 길이만큼 돌며 (패딩 되어 있으므로 1부터)
        if adj_matrix[v][i]==1 and visited[i]==0:   # 연결 + 방문x 라면
            dfs(i)  # 해당 지점으로 재귀

N = int(input()) 
edge = int(input())
adj_matrix = [[0]*(N+1) for _ in range(N+1)]    # 패딩 씌워 가독성 up

for _ in range(edge):   # edge만큼 반복하며
    i,j = map(int,input().split())  # 두 수 입력, 인접 여부 양방향 입력
    adj_matrix[i][j] = 1
    adj_matrix[j][i] = 1

visited = [0] * (N+1)   # 방문 체크 배열 생성

dfs(1)  # 1을 기점으로 dfs

print(visited.count(1)-1)   # 전파한 컴퓨터 갯수 체크