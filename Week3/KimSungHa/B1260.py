# 문제: 1260번 DFS와 BFS
# 설명: 그래프를 DFS와 BFS로 탐색한 결과를 출력

from collections import deque # dounble ended queue : 양쪽 어디로든 들어가고 나갈 수 있다.
                                # 파이썬에서 deque이 정말 빨라 BFS 사용을 위해 import

N,M,V=map(int,input().split())  # 그래프의 정점의 갯수 N, 간선의 갯수 M, 탐색 시작 번호 V 등록

adj_matrix = [[0]*(N+1) for _ in range(N+1)] # 한 층 더미데이터를 만들어주는게 낫다 # 인덱스 통일!

visited = [0]*(N+1) # 탐색 중 방문 여부를 체크할 배열 생성. 길이는 방문 노드와 인덱스 번호를 통일하기 위해 패딩.

for i in range(M):  # 배열 그래프 등록
    a, b = map(int,input().split())
    adj_matrix[a][b] = adj_matrix[b][a] = 1

def dfs(v):         #dfs 함수 : 시작 노드를 v로 받아준다.
    visited[v] = 1  # 방문 체크
    print(v, end=" ")   # 방문 지점 프린트
    for i in range(1, N+1): # 해당 하는 부분만 돌면서 다음 갈 곳 탐색 ( 자연스럽게 작은 곳부터 )
        if not visited[i] and adj_matrix[v][i] == 1: # 방문 X + 연결 되어 있음?
            dfs(i)  # 해당 지점으로 진행하여 재귀

dfs(V)

visited = [0]*(N+1) # visited가 dfs로 메챠쿠챠 되어있으니 한 번 초기화

def bfs(v):
    q = deque()

    visited[v] = 1 # 무조건 여기서 방문 처리.
    print(v, end=" ")       # 출력하고,
    q.append(v)             # 해당 지점을 큐에 추가

    while q:            # q가 비어있지 않다면,
        # 여기서 방문처리 하면 안됨. 중복 등록 가능성 있음
        cur_pos = q.popleft()   # popleft해 첫 원소를 
        for i in range(1, N+1):
            if not visited[i] and adj_matrix[cur_pos][i] ==1:
                print(i, end=" ")
                visited[i] = 1
                q.append(i)

bfs(V)

# 간선만 주어졌을 때 사용하면 되지, 맵 자체가 주어지면 굳이 이용할 필요 없음.
# 암묵적으로 델타로 연결관계가 설명됨