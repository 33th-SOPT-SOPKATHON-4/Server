## Git Convention

### 🔹Commit Convention

- ✅ `[CHORE]` : 동작에 영향 없는 코드 or 변경 없는 변경사항(주석 추가 등)
- ✨ `[FEAT]` : 새로운 기능 구현
- ➕ `[ADD]` : Feat 이외의 부수적인 코드 추가, 라이브러리 추가, 새로운 파일 생성
- 🔨 `[FIX]` : 버그, 오류 해결
- ⚰️ `[DEL]` : 쓸모없는 코드 삭제
- 📝 `[DOCS]` : README나 WIKI 등의 문서 수정
- ✏️ `[CORRECT]` : 주로 문법의 오류나 타입의 변경, 이름 변경시
- ⏪️ `[RENAME]` : 파일 이름 변경시
- ♻️ `[REFACTOR]` : 전면 수정
- 🔀 `[MERGE]`: 다른 브랜치와 병합

### 커밋 예시

`ex ) git commit -m "#1 [FEAT] 회원가입 기능 완료"`

### 🔹Branch Convention

- [develop] : 최종 배포
- [feature] : 기능 추가
- [fix] : 에러 수정, 버그 수정
- [docs] : README, 문서
- [refactor] : 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [modify] : 코드 수정 (기능의 변화가 있을 때)
- [chore] : gradle 세팅, 위의 것 이외에 거의 모든 것

### 브랜치 명 예시

`ex) feature/#issue-user-api`

### 🔹Branch Strategy

### Git Flow

기본적으로 Git Flow 전략을 이용한다. Fork한 후 나의 repository에서 작업하고 구현 후 원본 repository에 pr을 날린다. 작업 시작 시 선행되어야 할 작업은 다음과 같다.

```java
1. Issue를 생성한다.
2. feature Branch를 생성한다.
3. Add - Commit - Push - Pull Request 의 과정을 거친다.
4. Pull Request가 작성되면 작성자 이외의 다른 팀원이 Code Review를 한다.
5. Code Review가 완료되면 Pull Request 작성자가 develop Branch로 merge 한다.
6. merge된 작업이 있을 경우, 다른 브랜치에서 작업을 진행 중이던 개발자는 본인의 브랜치로 merge된 작업을 Pull 받아온다.
7. 종료된 Issue와 Pull Request의 Label과 Project를 관리한다.

```

- 기본적으로 git flow 전략을 사용합니다.
- main, develop, feature 3가지 branch 를 기본으로 합니다.
- main → develop → feature. feature 브랜치는 feat/기능명으로 사용합니다.
- 이슈를 사용하는 경우 브랜치명을 feature/[issue num]-[feature name]로 합니다.

### 🔹Issue Convention

- [feat] : 기능 추가
- [fix] : 에러 수정, 버그 수정
- [docs] : README, 문서
- [refactor] : 코드 리펙토링 (기능 변경 없이 코드만 수정할 때)
- [modify] : 코드 수정 (기능의 변화가 있을 때)
- [chore] : gradle 세팅, 위의 것 이외에 거의 모든 것

`ex) [feat] user api 구현`

<br>

## Code convention

**✓ File Naming**

- 파일 이름 및 클래스, 인터페이스 이름: **파스칼 케이스(Pascal Case)**
- Entity에서 사용되는 속성값들은 ? **카멜 케이스(camel Case)**
- 내부에서 사용되는 함수 및 기타 사용: **카멜 케이스(camelCase)**

**✓ 인터페이스 이름에 명사/형용사 사용 [interface-noun-adj]**

인터페이스(interface)의 이름은 명사/명사절로 혹은 형용사/형용사절로 짓는다.

**✓ 클래스 이름에 명사 사용 [class-noun]**

클래스 이름은 명사나 명사절로 짓는다.

**✓ 메서드 이름은 동사/전치사로 시작 [method-verb-preposition]** 

메서드명은 기본적으로 동사로 시작한다.

다른 타입으로 전환하는 메서드나 빌더 패턴을 구현한 클래스의 메서드에서는 전치사를 쓸 수 있다.

**✓ 상수는 대문자와 언더스코어로 구성[constant_uppercase]**

"static final"로 선언되어 있는 필드일 때 상수로 간주한다.

상수 이름은 대문자로 작성하며, 복합어는 언더스코어'_'를 사용하여 단어를 구분한다.

**✓ 변수에 소문자 카멜표기법 적용 [var-lower-camelcase]**

상수가 아닌 클래스의 멤버변수/지역변수/메서드 파라미터에는 소문자 카멜표기법(Lower camel case)을 사용한다.

**✓ 임시 변수 외에는 1 글자 이름 사용 금지 [avoid-1-char-var]**

메서드 블럭 범위 이상의 생명 주기를 가지는 변수에는 1글자로 된 이름을 쓰지 않는다.

**반복문의 인덱스나 람다 표현식의 파라미터 등 짧은 범위의 임시 변수**에는 관례적으로 1글자 변수명을 사용할 수 있다.

<br>

## 폴더 구조

```sql
├── 📂 common
|   ├── 📂 dto
|   └── 📂 exception
├── 📂 config
│   └──
├── 📂 controller
│   ├── 
│   └── 
├── 📂 domain
│   ├── 
│   └── 
├── 📂 dto
│   ├── 📂 request
|   │   ├── 
|   │   └── 
│   └── 📂 response
│       ├── 📂 
|       │   ├── 
|       │   └── 
│       ├── 📂 
|       │   ├── 
|       │   └── 
│       └── 
├── 📂 repository
│   ├── 
│   └── 
├── 📂 service
│   ├── 
│   └── 
└──
```
