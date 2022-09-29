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
:smile:Bora : https://github.com/Bora0k<br/>
:blush:Hyunmin : https://github.com/hyunminini<br/>
:laughing:Minuk : https://github.com/poviea

<br/><br/>
## 프로젝트 개요
 ### 1. 프로젝트 개요
  - 사원 커뮤니티 게시판 개발
  
<br/>

 ### 2. 프로젝트 일정
| Schedule | 9/22 | 9/23 | 9/24 | 9/25 | 9/26 | 9/27 | 9/28 |  9/29 |  9/30 |
| ----- | ----- | ----- | ----- | ----- | ----- | ----- | ----- | ----- |  ----- | 
| 주제 선정 | :white_check_mark: |  |  |  |  |  |  |  |
| 프로젝트 진행 | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark: | :white_check_mark:  | :white_check_mark:  | :white_check_mark:  |  |
| 코드 병합 |  |  |  |  |  |  | :white_check_mark: | :white_check_mark: |  |
| 발표 준비 |  |  |  |  |  |  | | :white_check_mark: |  |
| 발표 |  |  |  |  |  |  |  |  |  :white_check_mark:  |
<br/><br/>
<br/><br/>



## 프로젝트 내용
 ### 1.개발환경

| JavaScript | Java |  Apache   |  MySQL   |
| :--------: | :--------: | :------: | :-----: |
|   ![js]    |   ![Java]    | ![Apache] | ![MySQL] |

### 2. 프로젝트 레이아웃 및 기본 기능
 [피그마 사용]:https://www.figma.com/file/NSYJHmggBXPuJKYLswrBOM/Java-MiniProject?node-id=0%3A1
- 레이아웃 >> [피그마 사용]
- 기능
  - 사원 게시판 >> 카테고리별 등록
  - 댓글
  - 페이지네이션
  - 관리자페이지

- 데이터베이스 구조
![Image](https://user-images.githubusercontent.com/109777144/192930104-521b9b3d-f18f-40fd-ab72-9533f52e0f70.png)
![Image](https://user-images.githubusercontent.com/109777144/192930840-96ec80cb-fe55-437c-8231-548b646300cf.png)
![Image](https://user-images.githubusercontent.com/109777144/192931015-68fcdc38-da59-4cd0-941a-e5eaf165869f.png)
![Image](https://user-images.githubusercontent.com/109777144/192931338-ceddc402-413c-43fe-b7a1-6fae4574afe5.png)
![Image](https://user-images.githubusercontent.com/109777144/192931257-aa6e2ada-dd1a-4295-bace-da07eaf03b70.png)
![Image](https://user-images.githubusercontent.com/109777144/192931428-b87f40e7-5f49-4913-93e3-98ff7e3e6785.png)
![Image](https://user-images.githubusercontent.com/109777144/192931466-3ccee591-3028-4ba3-aced-a3fcba8e0ef7.png)
![Image](https://user-images.githubusercontent.com/109777144/192942340-3045a025-93c3-4398-a667-98d1dcbe0ac7.png)



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
 + [초기 구조에러로 게시글 수정 삭제시 필요 정보와 session에 포함된 정보 불일치] 

## 향후 계획 및 발전 가능성
 ### 1. 구조 변경
 - 코드리뷰를 통해 효율적인 구조 변경 및 중복 코드 통합,삭제
 - Spring Framewrok 사용
 
 <br/>
  ### 2. 추가 기능
  - 파일업로드(확장자 필터링)
  - 좋아요, 신고기능
  - 관리자 페이지 >> 사원 계정 정지
  - Session timeout, security
  - 맛집 API 추가 >> [부산 맛집정보 서비스]
  - AWS 배포
  [부산 맛집정보 서비스]:https://www.data.go.kr/data/15063472/openapi.do
  <br/>
  

------------------
## [참고자료]
[https://useegod.com/2021/11/20/git_readme/
https://www.google.com/search?newwindow=1&q=README+%ED%85%9C%ED%94%8C%EB%A6%BF&sa=X&ved=2ahUKEwjVgYf0yrn6AhWIdd4KHaGEB1QQ1QJ6BAgiEAE&biw=1023&bih=936&dpr=1
https://www.google.com/search?newwindow=1&lei=elY1Y-DOK5nChwPcubC4BA&q=GitHub%20README%20%ED%85%9C%ED%94%8C%EB%A6%BF&ved=2ahUKEwjg88f2ybn6AhUZ4WEKHdwcDEcQsKwBKAB6BAhFEAE&biw=1920&bih=937&dpr=1](http://yoonbumtae.com/?p=2957
https://drsggg.tistory.com/222
https://cbts.tistory.com/m/294
https://beaniejoy.tistory.com/25)



[js]: https://cdn-icons-png.flaticon.com/128/5968/5968292.png
[Java]: https://cdn-icons-png.flaticon.com/128/226/226777.png
[Apache]: https://tomcat.apache.org/res/images/tomcat.png
[MySQL]: https://cdn-icons-png.flaticon.com/128/919/919836.png
