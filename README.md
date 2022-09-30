# :computer: Community Employees Page - Team P.P

### 



### Contents

0. [Team P.P Members](#team-p.p-members)
1. [프로젝트 개요](#프로젝트-개요)
2. [프로젝트 내용](#프로젝트-내용)
3. [문제점](#문제점)
4. [향후 계획 및 발전 가능성](#향후-계획-및-발전-가능성)
5. [참고자료](#참고자료)

<br/><br/>

## Team P.P Members
[Bora]:https://github.com/Bora0k
[Hyunmin]:https://github.com/hyunminini
[Minuk]:https://github.com/poviea

:smile:[Bora] : :blush:[Hyunmin] : :laughing:[Minuk] 

<br/><br/>

## 프로젝트 개요
 ### 1. 프로젝트 개요
  - 사원 커뮤니티 게시판 개발

 ### 2. 프로젝트 일정
| Schedule | 9/22 | 9/23 | 9/24 | 9/25 | 9/26 | 9/27 | 9/28 |  9/29 |  9/30 |
| ----- | ----- | ----- | ----- | ----- | ----- | ----- | ----- | ----- |  ----- | 
| 주제 선정 | :white_check_mark: |  |  |  |  |  |  |  |
| 프로젝트 진행 | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:  | :white_check_mark:  | :white_check_mark:  |  |
| 코드 병합 |  |  |  |  |  |  | :white_check_mark: | :white_check_mark: |  |
| 발표 준비 |  |  |  |  |  |  | | :white_check_mark: |  |
| 발표 |  |  |  |  |  |  |  |  |  :white_check_mark:  |


<br/><br/>

## 프로젝트 내용
 ### 1.개발환경

| JSP | Java |  Apache   |  MySQL   |
| :--------: | :--------: | :------: | :-----: |
|   ![jsp]    |   ![Java]    | ![Apache] | ![MySQL] |

### 2. 프로젝트 레이아웃 및 기본 기능
 [피그마 사용]:https://www.figma.com/file/NSYJHmggBXPuJKYLswrBOM/Java-MiniProject?node-id=0%3A1
- 레이아웃 >> [피그마 사용]
- 기능
  - 사원 게시판(CRUD) >> 카테고리별 등록
  - 댓글
  - 페이지네이션
  - 관리자페이지
  - 로그인 필터 / 로그아웃 
  - 공지사항
  

- 데이터베이스 구조

![Image](https://user-images.githubusercontent.com/109777144/192930104-521b9b3d-f18f-40fd-ab72-9533f52e0f70.png)
![Image](https://user-images.githubusercontent.com/109777144/192930840-96ec80cb-fe55-437c-8231-548b646300cf.png)
![Image](https://user-images.githubusercontent.com/109777144/192931015-68fcdc38-da59-4cd0-941a-e5eaf165869f.png)
![Image](https://user-images.githubusercontent.com/109777144/192931338-ceddc402-413c-43fe-b7a1-6fae4574afe5.png)
![Image](https://user-images.githubusercontent.com/109777144/192931257-aa6e2ada-dd1a-4295-bace-da07eaf03b70.png)
![Image](https://user-images.githubusercontent.com/109777144/192931428-b87f40e7-5f49-4913-93e3-98ff7e3e6785.png)
![Image](https://user-images.githubusercontent.com/109777144/192931466-3ccee591-3028-4ba3-aced-a3fcba8e0ef7.png)
![Image](https://user-images.githubusercontent.com/109777144/192942340-3045a025-93c3-4398-a667-98d1dcbe0ac7.png)

<br/><br/>

## 문제점
 ### 1. 프로젝트 진행
  + 초기 개발 시 우선 순위 파악 실패로 코드 구조가 깔끔하지 않음(session 및 MVC)
  + 변수 및 객체 등 기존에 통일한 사소한 변경이 소통되지 않아 코드 병합 시 혼동
  + git 사용 미숙
 
 ### 2. 프로젝트 내부 오류
 [DB 초기 설정]:https://github.com/hyunminini/CommunityPage/issues/41
 [잘못된 sendRedirect 주소로 데이터 무한 루프]:https://github.com/hyunminini/CommunityPage/issues/39
 [AWS my-sql 사용 시 대소문자 구분]:https://github.com/hyunminini/CommunityPage/issues/11
 [초기 구조에러로 게시글 수정 삭제시 필요 정보와 session에 포함된 정보 불일치]:https://github.com/hyunminini/CommunityPage/issues/40
 
 + [DB 초기 설정]
 + [잘못된 sendRedirect 주소로 데이터 무한 루프] >> AWS 사용 시 주의!
 + [AWS my-sql 사용 시 대소문자 구분]
   * 대문자로 통일하여 해결
   * 처음 DB를 생성 할 때 부터 lower_case_table_names = 1으로 설정된 파라미터 그룹을 사용하면 MySQL 8 RDS에서도 테이블 조회시 대소문자 상관 없이 조회 가능!
 + [게시글 수정 삭제시 필요한 정보가 session 정보에 포함되어 있지 않음]
   * 현재 세션은 사원이름만 포함 , 게시글 수정, 작성 시 사원 번호로 구분
   * session에 사원번호 추가

   

<br/><br/>

## 향후 계획 및 발전 가능성
 ### 1. 구조 변경
 - 코드리뷰를 통해 효율적인 구조 변경 및 중복 코드 통합,삭제
 - Spring Framewrok 사용
 
 <br/>
  
  ### 2. 추가 기능
  [부산 맛집정보 서비스]:https://www.data.go.kr/data/15063472/openapi.do
  
  - 파일업로드(확장자 필터링)
  - 좋아요, 신고기능
  - 관리자 페이지 >> 사원 계정 정지
  - Session timeout, security
  - 맛집 API 추가 >> [부산 맛집정보 서비스]
  - AWS 배포

  

------------------
## [참고자료]
|



[jsp]: https://cdn-icons-png.flaticon.com/128/29/29540.png
[Java]: https://cdn-icons-png.flaticon.com/128/226/226777.png
[Apache]: https://tomcat.apache.org/res/images/tomcat.png
[MySQL]: https://cdn-icons-png.flaticon.com/128/919/919836.png
