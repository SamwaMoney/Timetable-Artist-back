# 이대생을 위한 시간표 채점&공유 서비스, 시간표 아티스트
>전 수강신청 망한 대학생이 아니라 시간표 아티스트에요

## ✨ 프로젝트 소개  
많은 대학생들이 자신의 ‘망한’ 시간표를 친구들과 공유하는 문화에서 착안한, 대학(원)생들을 위한 시간표 공유 서비스입니다. 시간표를 설정한 후 점수를 다른 사람들과 공유하며 랭킹에 올릴 수 있습니다. 또한 아침형/저녁형, 건물 간의 거리 등을 파악해 시간표가 얼마나 자신의 성향에 잘 맞는 시간표인지 알 수 있습니다.  

본 프로젝트는 이화여대 커리어 클럽 웹개발 동아리 EFUB의 여름 프로젝트 🏖SWS(Summer Web Surf)에서 진행되었습니다.  
<br/> <br/>


## 📅 개발 일정  
(2023.03.14 ~ 2022.08.01)  

기획 및 디자인 : 2022.03.14 ~ 2022.08.01  
개발 : 2022.06.25 ~ 2022.08.01  
<br/> <br/>


## 👩🏻‍💻 팀원 소개
| 차소연 | 김혜빈 | 조민서 | 노하은 | 이소정 |
| ------ | ----- | ------- |------ | --------|
|API 문서 작성, 댓글 API, 배포|RDS 세팅, 시간표 좋아요 API, 시간표-수업 객체 연결|엔티티 생성, 시간표 API, 채점 API, 시간표-수업 객체 연결, 랭킹보드 API|유저 인증 API, 회원 관리 API, 기능 테스트|아키텍처 작성, 수업 API, 기능 테스트| 
|[@Soyeon-Cha](https://github.com/Soyeon-Cha)|[@aoqls](https://github.com/aoqlsdl)|[@rovemin](https://github.com/rovemin)|[@00blowup](https://github.com/00blowup)|[@doleebest](https://github.com/doleebest)|
<br/> <br/>


## 🔨 개발

### ⚙ 실행
```
git clone
Run 'TimeTableArtistApplication.java'
```
<br/>

### ⚙ 기술 스택   
BackEnd : <img src="https://img.shields.io/badge/JAVA-007396?style=for-the-badge&logo=java&logoColor=white">
<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=Spring&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><img src="https://img.shields.io/badge/gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white">
<img src="https://img.shields.io/badge/docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">  

ETC : <img src="https://img.shields.io/badge/aws-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white">
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
<img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
<br/> <br/>


### 📁 디렉토리 구조
📂 main.java  
└─ 📂 SamwaMoney.TimeTableArtist  
    ├─ 📂 Class  
    ├─ 📂 Comment  
    ├─ 📂 configuration  
    ├─ 📂 Member  
    ├─ 📂 Reply  
    ├─ 📂 ReplyLike  
    ├─ 📂 tablecommentmap.domain  
    ├─ 📂 TableLike  
    ├─ 📂 Timetable  
    └─ 📂 utils  
└─ 📂 Global  
    ├─ 📂 entity  
    ├─ 📂 exception  
    └─ 📂 service    
<br/>

### 📁 API 명세서
[API 명세서 보러가기](https://www.notion.so/efub/7e4579a752c644a9be9d06e87eb8f1fc?v=451697bb988e49d884664e23687ff2f6&pvs=4)  
<br/> <br/>


## ✨ 주요기능 소개 
![image](https://github.com/SamwaMoney/Timetable-Artist-back/assets/90204371/189dcc83-47a6-4393-b1c1-f266a8e1f50d)    
직접 시간표를 만든 뒤,  

![image](https://github.com/SamwaMoney/Timetable-Artist-back/assets/90204371/72461b1f-13ca-4a42-b222-10370afc3d64)  
나의 시간표는 얼마나 좋은 시간표인지 확인할 수 있습니다. (재미있는 코멘트는 덤!)  

![image](https://github.com/SamwaMoney/Timetable-Artist-back/assets/90204371/9729b44d-d0a8-488f-828b-d67ccea9b8c3)  
나의 시간표를 랭킹보드에 공유할 수 있습니다. 다른 유저들의 시간표와 재미있는 코멘트도 확인해보세요!     
<br/> <br/>


## 📲 와이어프레임    
![sws와이어프레임](https://github.com/SamwaMoney/Timetable-Artist-back/assets/90204371/47b0a2cb-b9bf-435c-bbb2-308a49924a86)
