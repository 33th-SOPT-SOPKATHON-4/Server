![1024_500](https://github.com/33th-SOPT-SOPKATHON-4/Android/assets/103172971/7c2b7c3e-4160-4b5b-af68-164c3ef5b42b)

## 💢서비스 이름 및 간단한 소개
주변 눈치를 보며 겸손해야 하는 이들에게는 자랑의 창구를, 다른 이들의 자랑을 보며 부정적 마음을 가지는 이들에게는 마음껏 부러움을 표출할 수 있는 공간을 마련해주는 서비스, 흥!

## 😠주요기능
1) 오늘 하루 자랑할만한 일을 익명으로 공유
2) 타 유저는 반응을 ‘좋아요’ 대신 ‘질투나요’ 버튼을 통해 감정 표출
3) 타 유저가 공유한 자랑에 질투하기를 3번 반응 → 유저가 자랑할 수 있는 티켓 1개 생성
4) 유저가 공유한 자랑들, 각 자랑거리 당 ‘질투나요’ 횟수 모아보기.
<br><br>

## ⚒️ 기술 스택
**언어**
- Java

**프레임워크**
- Spring Boot

**데이터베이스**
- MySQL

**툴**
- intellij, datagrip, postman
<br><br>

## 아키텍처 구조도
![image](https://github.com/33th-SOPT-SOPKATHON-4/Server/assets/109871579/75a56fb1-dabe-413d-8f11-26cacf898e15)

### 서버 배포 Base URL
http://54.180.48.16:8080

## ✏️ 팀원 역할 분담

<h2> 😱개발자들 </h2>

<table align="center">
    <tr align="center">
        <td style="min-width: 150px;">
            <a href="https://github.com/mmihye">
              <img src="https://avatars.githubusercontent.com/u/92644651?v=4" width="200" alt="깃허브계정-프로필사진">
              <br />
              <b>mmihye</b>
            </a>
        </td>
      <td style="min-width: 150px;">
            <a href="https://github.com/ChaeAg">
              <img src="https://avatars.githubusercontent.com/u/109871579?v=4" width="200" alt="깃허브계정-프로필사진">
              <br />
              <b>ChaeAg</b>
            </a>
        </td>
    </tr>
    <tr align="center">
        <td>
            석미혜 <br/>
      </td>
       <td>
            이채은 <br/>
      </td>
    </tr>
    <tr align="center">
        <td>
            로그인 및 회원가입 API<br/>질투나요 누르기 API<br/>유저 정보 조회API<br/>
      </td>
       <td>
            메인 게시물 조회 API<br/>게시물 작성 API<br/>
      </td>
    </tr>
</table>
<br><br>

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
├── ProjectApplication.java
├── common
│   ├── ApiResponse.java
│   ├── dto
│   │   ├── Error.java
│   │   └── Success.java
│   └── exception
│       ├── CustomException.java
│       └── NotFoundException.java
├── config
│   ├── AWSConfig.java
│   └── JpaAuditingConfig.java
├── controller
│   ├── HealthCheckController.java
│   ├── PostController.java
│   └── UserController.java
├── domain
│   ├── NicknameGeneration.java
│   ├── Post.java
│   ├── User.java
│   └── UserPostInteractions.java
├── dto
│   ├── request
│   │   └── DIslikePostRequest.java
│   └── response
│       ├── PostGetResponse.java
│       ├── UserGetResponse.java
│       └── UserPostGetResponse.java
├── external
│   └── S3Service.java
├── repository
│   ├── NicknameGenerationJpaRepository.java
│   ├── PostRepository.java
│   ├── UserJpaRepository.java
│   ├── UserPostInteractionsRepository.java
│   └── UserRepository.java
└── service
    ├── PostService.java
    └── UserService.java
```

## 로컬 실행 방법
1. 깃허브에서 프로젝트를 클론 받는다.
   ```
   git clone https://github.com/33th-SOPT-SOPKATHON-4/Server.git
   ```
2. 프로젝트를 빌드한다.
   ```
   ./gradlew clean build -x test
   ```
3. /build/libs 경로로 이동해서 빌드파일을 실행한다.
   ```
   nohup java -jar Project-0.0.1-SNAPSHOT.jar &
   ```
