# 문제: 11725번 트리의 부모 찾기
# 설명: 트리를 입력받고 각 노드의 부모를 출력한다.
# 트리를 안 배워서 dfs 뚜드려박고 테케만 맞고 메모리 초과 떴습니다 ㅠ
# 배워서 다시 풀어보겠습니다.

def dfs(s, d):  # dfs 함수, 시작점과 끝점을 받는다.
    global parent
    visited[s]=1
    for i in range(N+1):    # 인접이며 방문하지 않은데 대하여여
        if tree[s][i]==1 and visited[i]==0:
            if i==d:
                parent=s    # 도착점에 도달했다면, 시작점 반환하여 부모 체크
            else:
                dfs(i,d)    # 아니라면 그 지점에서 재귀 탐색

N = int(input())

tree = [[0]*(N+1) for _ in range(N+1)]

for _ in range(N-1):        # 인접 행렬로 트리 비슷하게 구성
    i,j = map(int,input().split())
    tree[i][j] = tree[j][i] = 1

for i in range(2,N+1):  # 2부터 매번 dfs돌리며 부모찾기(욕아님)
    visited = [0]*(N+1)
    parent = 0
    dfs(1,i)
    print(parent)