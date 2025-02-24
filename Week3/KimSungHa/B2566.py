# 문제: 2566번 최댓값
# 설명: 2차원 배열에서 최댓값과 그 값의 인덱스 추출

num_plate = [list(map(int,input().split())) for _ in range(9)]

max_num = 0 # 최댓값의 0일 수밖에 없다.

for i in range(9):  # 리스트를 돌며
    for j in range(9):
        if max_num<=num_plate[i][j]:    # 최댓값보다 크거나 같다면
            max_num=num_plate[i][j]     # 값 대체
            max_index = [i+1,j+1]       # 인덱스 저장

print(max_num)
print(*max_index)   # join없이 언패킹하여 출력 가능