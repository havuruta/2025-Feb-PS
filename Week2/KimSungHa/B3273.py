# 문제: 3273번 두 수의 합
# 설명: 서로 다른 양의 정수들로 이뤄진 수열에서 두 수의 합이 주어진 x와 일치하는 쌍의 갯수 찾기

n = int(input()) # n, arr, x 입력
arr = list(map(int,input().split()))
x = int(input())
cnt = 0 # 만족하는 쌍의 수를 셀 정수 할당

for i in range(n-1):  # 각각의 수를 돌며 (두 쌍을 만들 것이므로 맨 끝은 시작점으로 잡지 않아도 된다.)
    for j in range(i+1,n):  # 이 수 다음 자리부터 끝까지 (이번엔 끝까지)
        if arr[i]+arr[j] == x:  # 두 수의 합이 x와 일치하면 cnt에 1을 더한다.
            cnt += 1

print(cnt)