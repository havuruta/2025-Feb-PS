# 2025년 2월 알고리즘 스터디 - README

## 주제
- **알고리즘 풀이 in 백준**

## 개요
- 매주 동일한 개념의 문제를 풉니다.
  - **브론즈 5개 / 실버 3개 / 골드 2개**
- 최소 **5개 이상의 문제**를 풀어야 합니다.
  - 난이도 순으로 풀어야 하며, 실버를 다 해결하지 않고 골드를 제출할 수는 없습니다.
- **5개 이상 풀지 않은 주**가 연속될 경우, 스터디에서 제외됩니다.

## 진행 방식
1. **온라인 업로드**: 각자 풀이한 코드를 GitHub에 업로드합니다.
2. **인사이트 공유**: GitHub 댓글 기능을 활용하여 다른 스터디원의 코드를 보고 의견과 인사이트를 공유합니다.
3. **리뷰 세션**: 매주 1시간 동안 정해진 시간에 온라인으로 리뷰를 진행합니다. (필요 시 난이도 순으로 진행)

## 일정
- 매주 **월요일**에 새로운 차수가 시작됩니다.
- **일요일 오후 1시** 이전까지 Pull Request (PR)를 업로드해야 합니다.

---

## 깃허브 사용 가이드

### 1. 프로젝트 구조
```plaintext
2025-Feb-PS
├── Week1/
│   ├── problem/       # 문제 템플릿 폴더
│   └── your_name/     # 본인의 폴더 (문제 풀이 코드 작성)
│       ├── 문제1.java
│       ├── 문제2.java
│       ├── 문제3.java
│       └── ...
└── README.md          # 스터디 리드미 파일
```

### 2. 스터디 참여 방법

#### 1. 레포지토리 클론
```bash
$ git clone https://github.com/{repository_url}
$ cd algorithm-study-1st-team
```

#### 2. 브랜치 생성
```bash
$ git checkout -b your_name-week1
```

#### 3. 폴더 복제 및 이름 변경
- `Week1/problem` 폴더를 복제하여 자신의 이름으로 변경합니다.
```bash
$ cp -r Week1/problem Week1/your_name
```

#### 4. 문제 풀이 작성
- 자신의 폴더 내부에 문제 풀이 코드를 작성합니다.

#### 5. 커밋 및 푸시
```bash
$ git add .
$ git commit -m "[Week1] Add solutions"
$ git push origin your_name-week1
```

#### 6. PR 생성
- GitHub에서 자신의 브랜치를 `main` 브랜치로 Pull Request를 생성합니다.

#### 7. 리뷰 및 머지
- 다른 스터디원의 코드를 리뷰하고, 자신의 PR에 대한 피드백을 확인 후 수정합니다.
- 최종적으로 PR이 승인되면 `main` 브랜치에 병합합니다.

---

## 문제 제출 규칙
1. **폴더 이름**: 본인의 이름으로 된 폴더에서 작업합니다.
2. **파일 이름**: 각 문제 번호 또는 제목으로 명확하게 작성합니다.
3. **코드 내부 주석**: 풀이 과정과 주요 로직에 대한 설명을 주석으로 작성합니다.

예시:
```java
// 문제: 1000번 - A+B
// 설명: 두 정수를 입력받아 더한 값을 출력

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println(a + b);
        scanner.close();
    }
}
```

---

## 주의사항
- **리뷰에 성실히 참여**해주세요. 건설적인 피드백을 주고받으며 함께 성장합시다.
- **정해진 마감 기한**을 준수합시다. PR은 반드시 일요일 오후 1시 이전에 올려야 합니다.
