# 문제: 1157번
# 설명: 단어에서 가장 많이 사용된 알파벳을 대문자로 출력합니다. 여러 개라면 ?를 출력합니다.

word = input()

word = word.upper()     # 전체 대문자화

used_words = {}     # 나오는 단어 갯수 카운트를 하기 위해 빈 딕셔너리 선언

for i in word:      # 대문자화한 단어 각각을 돌며,
    if i in used_words: # 이미 체크한 단어라면,
        used_words[i] +=1   # 갯수 더하기
    elif i not in used_words:   # 체크한 적 없다면,
        used_words[i] = 1   # 키 생성 후 한개 체크

answer = 0
max_value = 0

for key, value in used_words.items():   # 만들어진 딕셔너리 전체를 돌며
    if max_value == value and answer != key:    # 하지만 빈도가 같은 상태에서 알파벳이 다르다면?
        answer = '?'            # 정답에 '?' 할당
    elif max_value <= value:  # 최댓값 갱신
        max_value = value
        answer = key        # 최댓값에 해당하는 알파벳 answer에 할당


print(answer)

# 분명 더 줄일 수 있었을 거야.