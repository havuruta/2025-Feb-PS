# 문제: 10798번 세로읽기
# 설명: 주어진 단어들을 세로로 읽어 새로운 문자열을 생성합니다.

words = [input() for _ in range(5)] # 5줄에 걸쳐 문자열 입력 할당
max_len = len(words[0])             # 각 문자열의 최대 길이를 얻기 위해 초기값 설정

for i in words:                     # words를 돌며
    if max_len<len(i):              # 최댓값 갱신
        max_len=len(i)

plate = [['*']*max_len for _ in range(max_len)] # 특수문자는 포함하지 않으니 특수문자로 이뤄진 베이스 게임판

for i in range(5):      # 문자열을 돌며
    for j in range(len(words[i])):  # 각 문자열의 길이 만큼 돌며
        plate[i][j] = words[i][j]      # 게임판에 등록하기

lines = ''

for j in range(max_len):    # 세로로 탐색
    for i in range(max_len):
        if plate[i][j]!='*':    # 비어 있는 걸 의미하는 *가 아니면
            lines+=plate[i][j]  # lines에 더해 세로로 읽은 문자열 만들기

print(lines)