# WEB APPLICATION - BOARD  
## 1. 비즈니스 레이어 개발
<b>비즈니스 컴포넌트 구성</b>  
Service Interface <-(implements)-- ServiceImpl --(use)-> Repository, Entity
### 1.1 비즈니스 컴포넌트 개발
#### 1.1.1 엔티티 클래스 만들기
    1) 게시판 엔티티 작성(Board.java)
    2) 회원 엔티티 작성(Member.java)
    3) 게시판 - 회원 견관 매핑 설정 추가
#### 1.1.2 리포지토리 인터페이스 작성하기
    1) MemberRepository.java 작성  
    2) BoardRepository.java 작성
#### 1.1.3 JPA 테스트하기
    1) 등록 기능 테스트(BoardRepositoryTest.java - testInsert)
    2) 상세 조회 테스트(BoardRepositoryTest.java - testGetBoard)
    3) 목록 검색 테스트(BoardRepositoryTest.java - testGetBoardList)
#### 1.1.4 서비스 인터페이스와 클래스 만들기
    1) BoardService.java 작성
    2) BoardServiceImpl.java 작성

## 2. 프레젠테이션 레이어 개발
### 2.1 프레젠테이션 개발 준비
#### 2.1.1 프레젠테이션 설정 및 기본 화면 만들기
    1) 프레젠테이션 설정 추가
        application.properties에 타임리프와 로깅 관련 설정 추가
    2) 인덱스 페이지 추가(index.html)
    3) 파비콘 변경(favion.ico)
#### 2.1.2 글 목록 기능 구현하기
    1) 컨트롤러 작성(BoardController.java)
    2) 글 목록 화면 작성(getBoardList.html)

### 2.2 게시판 기능 구현하기
#### 2.2.1 글 상세 기능 구현하기
    1) 컨트롤러 수정(BoardController.java)
    2) 글 상세 화면 작성(getBoard.html)
#### 2.2.2 글 등록 기능 구현하기
    1) 글 등록 화면(insertBoard.html)
    2) 컨트롤러 수정(BoardController.java)
#### 2.2.3 글 수정과 글 삭제 기능 구현하기
    1) 컨트롤러 수정(BoardController.java)

### 2.3 스프링 시큐리티 적용하기
#### 2.3.1 시큐리티 커스터마이징하기
    1) 시큐리티 스타터 추가
    2) UserDetails 클래스 생성
    3) UserDetailService 클래스 만들기
    4) 시큐리티 설정 클래스 만들기(SecurityConfig.java)
#### 2.3.2 시큐리티 화면 개발하기
    1) 컨트롤러 작성(SecurityController.java)
    2) 로그인 화면 추가(login.html)
    3) 접근 권한 없음 화면 추가(accessDenied.html)
    4) 관리자 전용 화면 추가(adminPage.html)
#### 2.3.3 비밀번호 암호화하기
    1) 패스워드 인코더를 사용하기 위해 시큐리티 설정에 패스워드 인코더 빈 등록 추가(SecurityConfig.java)
    2) SecurityUser에서 패스워드 인코딩 하기 전 {noop}을 붙인 것을 제거
#### 2.3.4 글 등록 기능 구현하기
    1) BoardController의 insertBoard() 수정

### 2.4 기타기능 추가하기
#### 2.4.1 타임리프에서 로그인 정보 이용하기
    1) thymeleaf-extras-springsecurity5 의존성 추가
    2) 글 목록 화면에 사용자 이름 출력(getBoardList.html)
    3) 상세 화면에서 권한 체크(ADMIN 권한만 글 삭제 가능)
    4) 글 등록 화면에 사용자 이름 출력
#### 2.4.2 검색 기능 추가하기
    1) 검색화면 추가(getBoardList.html)
    2) 검색 전용 클래스 추가(Search.java)
    3) 컨트롤러 수정(getBoardList(Model model, Search search) 추가
    4) 리포지토리 수정하기(BoardRepository.java)
    5) 서비스 컴포넌트 수정(BoardService.java)