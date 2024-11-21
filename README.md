# Jari-Otte 티켓 예매 플랫폼
## 목차
[1. 프로젝트 소개](#-프로젝트-소개)

[2. 팀원](#팀원)

[3. 프론트 엔드](#프론트-엔드)

[4. API](#-api)

[5. 기술스택](#-기술-스택)

[6. 인프라 구성도](#-인프라-구성도)

[7. 주요 기술 및 특징](#-주요-기술-및-특징)

[8. 시스템 설계의 장점](#-시스템-설계의-장점)

[9. 트러블 슈팅](#-트러블-슈팅)

[10. 성능 개선](#-성능-개선)

# 프로젝트 소개
Jari-Otte는 **마이크로서비스 아키텍처(MSA)**를 통해 특정 서비스의 장애가 발생하더라도

전체 서비스에는 영향을 미치지 않도록 설계된 안정적이고 확장 가능한 티켓 예매 플랫폼입니다.

이 플랫폼은 대규모 데이터를 효율적으로 처리하고, 사용자에게 빠르고 직관적인 검색 및 예매 경험을 제공하는 것을 목표로 합니다.

# 팀원
<div align=center> 
<img src="https://github.com/user-attachments/assets/fc09bfec-299e-48ec-8a26-65dd89abdbfd">
</div>

<div align=center> 
  
| 주소       | 오강욱 (팀장)                 | 정이삭 (부팀장)                 | 김 현 (팀원)                  | 김우진 (팀원)                 |
|:------------:|:-----------------------------:|:-----------------------------:|:-----------------------------:|:-----------------------------:|
| 블로그 주소      | [블로그](https://velog.io/@kanguk_o/posts) | [블로그](https://velog.io/@isdev7057/posts) | [블로그](https://hyun-my-it-blog.tistory.com/) | [블로그](https://velog.io/@boom3652/posts) |
| GitHub 주소     | [GitHub](https://github.com/KangWookOh) | [GitHub](https://github.com/golden-hamster) | [GitHub](https://github.com/ican0422) | [GitHub](https://github.com/Woojin1123) |

</div>

# 프론트 엔드
![image](https://github.com/user-attachments/assets/bb76cd95-b906-4bed-a0f4-b80de55b663c)

# 💡 API
[API 문서 보기](https://documenter.getpostman.com/view/37572363/2sAYBSjDDo)

# ⚙ 기술 스택

<div align=center> 


  <br>
  <img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"> 
  <img src="https://img.shields.io/badge/redis-FF4438?style=for-the-badge&logo=redis&logoColor=white"> 
  <br>



  <img src="https://img.shields.io/badge/elasticsearch-005571?style=for-the-badge&logo=elasticsearch&logoColor=white">
  <img src="https://img.shields.io/badge/ELK-005571?style=for-the-badge&logo=elasticstack&logoColor=white">
  <img src="https://img.shields.io/badge/KAFKA-231F20?style=for-the-badge&logo=apachekafka&logoColor=white">
  <br>

  <img src="https://img.shields.io/badge/amazon s3-569A31?style=for-the-badge&logo=amazons3&logoColor=black"> 
  <img src="https://img.shields.io/badge/amazonaws-232F3E?style=for-the-badge&logo=amazonaws&logoColor=white"> 
  <img src="https://img.shields.io/badge/amazon ecs-FF9900?style=for-the-badge&logo=amazonecs&logoColor=white">
  <br>

  <img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
  <br>
</div>

# 🏗 인프라 구성도
![인프라 구성도](https://github.com/user-attachments/assets/a90ce3a1-2b68-4c86-bdf6-3b7c2558fbf6)


# 🚀 주요 기술 및 특징
1. __마이크로서비스 아키텍처 (MSA)__
   - 서비스 간의 독립성을 확보하여 특정 서비스에 장애가 발생하더라도 나머지 서비스에 영향을 주지 않음.
   - 유연한 확장성과 유지 보수성 향상.

2. __Kafka 기반 대용량 데이터 처리__
   - Kafka를 활용해 실시간으로 대량의 데이터를 처리하고, 빠른 이벤트 드라이븐 환경을 제공.
   - 트래픽이 폭주하는 상황에서도 안정적인 데이터 처리.

3. __Elasticsearch 검색 엔진__
   - 다중 조건 검색 및 고속 데이터 처리를 통해 사용자에게 더 나은 검색 경험을 제공.
   - 방대한 데이터에서도 실시간으로 정확한 검색 결과를 반환.

5. __ELK Stack & Prometheus를 활용한 로그 관리 및 모니터링__
   - ELK Stack (Elasticsearch, Logstash, Kibana)을 통해 로그를 중앙에서 관리하며 고급 필터링과 로그 분석 기능 제공.
   - Prometheus를 활용하여 시스템 상태를 실시간으로 모니터링하고 장애를 빠르게 탐지 및 대응.

# 🌟 시스템 설계의 장점
- __서비스 연속성:__ 장애 발생 시에도 독립적인 서비스 유지.
- __확장성:__ 트래픽 변화에 따라 개별 서비스나 데이터 처리 시스템을 유연하게 확장.
- __사용자 경험 개선:__ 고속 검색 및 예매 처리로 편리하고 신속한 서비스를 제공.
- __운영 효율성:__ 중앙 집중화된 로그 관리와 모니터링으로 시스템 유지보수 시간 단축.

# 👩‍💻 트러블 슈팅
[트러블 슈팅 & 기술 선택 문서](https://abalone-kicker-cfb.notion.site/bb89be9bc05b4618b46725fb2addce71?pvs=4)

# 📉 성능 개선
[성능 개선 문서](https://abalone-kicker-cfb.notion.site/131aebc7cf8780e9a5c7d85b79c93ffc?pvs=4)
