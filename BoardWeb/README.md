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