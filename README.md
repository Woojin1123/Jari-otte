<div align="center">
  
# Jari-Otte 티켓 예매 플랫폼
![로고 메이커 프로젝트](https://github.com/user-attachments/assets/1d90f74c-168a-4686-a5a7-553d2ea7c46c)

</div>
## 목차
[1. 프로젝트 소개](#-프로젝트-소개)

[2. 팀원](#팀원)

[3. 프론트 엔드](#프론트-엔드)

[4. Flow Chart](#FLOW-CHART)

[5. API](#-api)

[6. 기술스택](#-기술-스택)

[7. 인프라 구성도](#-인프라-구성도)

[8. 주요 기술 및 특징](#-주요-기술-및-특징)

[9. 시스템 설계의 장점](#-시스템-설계의-장점)

[10. 트러블 슈팅](#-트러블-슈팅)

[11. 성능 개선](#-성능-개선)

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
[JARI-OTTE 바로가기](https://www.jariotte.store/)
# FlOW CHART
![image](https://github.com/user-attachments/assets/c46525e9-bc86-4c46-9d31-65c3d7c4cdb8)

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
### 🍕 __마이크로서비스 아키텍처 (MSA)__
   - 서비스 간의 독립성을 확보하여 특정 서비스에 장애가 발생하더라도 나머지 서비스에 영향을 주지 않음.
   - 유연한 확장성과 유지 보수성 향상.

### 🍕 __Kafka 기반 대용량 데이터 처리__
   - Kafka를 활용해 실시간으로 대량의 데이터를 처리하고, 빠른 이벤트 드라이븐 환경을 제공.
   - 트래픽이 폭주하는 상황에서도 안정적인 데이터 처리.

### 🍕 __Elasticsearch 검색 엔진__
   - 다중 조건 검색 및 고속 데이터 처리를 통해 사용자에게 더 나은 검색 경험을 제공.
   - 방대한 데이터에서도 실시간으로 정확한 검색 결과를 반환.

### 🍕 __ELK Stack & Prometheus를 활용한 로그 관리 및 모니터링__
   - ELK Stack (Elasticsearch, Logstash, Kibana)을 통해 로그를 중앙에서 관리하며 고급 필터링과 로그 분석 기능 제공.
   - Prometheus를 활용하여 시스템 상태를 실시간으로 모니터링하고 장애를 빠르게 탐지 및 대응.
### 🍕 Spring Batch 활용 쿠폰만료 삭제 및 결제금액 정산

- 대량의 쿠폰 데이터를 효율적으로 처리하여 만료 기한을 일괄 정산
- 조건에 맞는 결제 데이터에 대한 정산 처리
- 안정적인 배치 작업으로 데이터 정확성과 성능 확보

# 🌟 시스템 설계의 장점
- __서비스 연속성:__ 장애 발생 시에도 독립적인 서비스 유지.
- __확장성:__ 트래픽 변화에 따라 개별 서비스나 데이터 처리 시스템을 유연하게 확장.
- __사용자 경험 개선:__ 고속 검색 및 예매 처리로 편리하고 신속한 서비스를 제공.
- __운영 효율성:__ 중앙 집중화된 로그 관리와 모니터링으로 시스템 유지보수 시간 단축.

# 👩‍💻 트러블 슈팅
[트러블 슈팅 & 기술 선택 문서](https://abalone-kicker-cfb.notion.site/bb89be9bc05b4618b46725fb2addce71?pvs=4)
### 🍕 Redis Lua Script 도입으로 동시성 제어 및 성능 향상
<div>
<details> 
    <summary>
      더보기
    </summary>
 🍕<strong>배경</strong>

대용량 트래픽이 몰릴 것으로 예상되는 공연 티켓팅 서비스 프로젝트의 좌석 예매를 구현하는 중에 **동시성 문제**를 신경 써야 했습니다.<br>



🍕<strong>요구사항</strong>

거의 동시에 여러 사람이 같은 좌석을 예매할 때 **한 사람만 성공**하고 나머지 요청에는 **예외를 반환**해야 합니다.<br>



🍕<strong>선택지</strong>

### DB 락

DB 자체의 락을 활용해서 동시성을 제어하는 방식입니다. 구현이 간단하고 일관성을 보장합니다. 하지만 대규모 트래픽이 발생하면 **수평적으로 확장하기 힘든 DB에 큰 부하**를 주게 됩니다. 그리고 다중 트랜잭션에서 서로가 서로의 락을 기다리는 **데드락**이 발생할 수 있습니다.

### Redis 분산락

Redis에 저장된 특정 키를 사용하여 락을 구현하는 방식입니다. 여러 인스턴스의 서비스가 동시에 특정 좌석을 예매할 때, **Redis 분산락**을 이용해 여러 인스턴스에서 동시에 같은 좌석을 예매하지 못하게 합니다.

Redis를 사용하기 때문에 여러 서버에서 동시에 동작하는 분산 환경에서 유용합니다. 하지만 **락을 얻고 해제하는 과정에서 시간이 소요되기 때문에 Lua script를 사용하는 것에 비해 느릴 수 있습니다.**

그리고 **락의 범위와 트랜잭션의 범위를 잘 조율해야 합니다.** 락의 해제 시점이 트랜잭션의 커밋 시점보다 빠를 경우 동시성 문제가 발생할 수 있습니다. 그렇다고 락의 범위를 너무 크게 하면 락 해제까지 걸리는 시간도 길어지기에 조심해야 합니다.

### 락 없이 Redis Lua script로 원자적 처리

만약 **Lua script를 사용하지 않고 그냥 Redis 각각의 명령만 락 없이 사용한다면** 동시성 문제가 발생할 수 있습니다.

예를 들어서:

1. **Redis에서 좌석 상태를 조회**
2. **Redis에서 좌석 상태를 변경**

위와 같은 작업을 할 때 Redis는 싱글 스레드로 동작하지만 이처럼 명령이 여러 개로 분리되는 경우 **동시성 문제가 발생**할 수 있습니다.

하지만 **Lua script는 싱글 스레드로 동작하는 Redis 서버 내에서 한 번에 묶여서 실행되기 때문에 원자성을 보장합니다.**

좌석의 상태를 조회하고 상태를 변경하는 행위를 스크립트로 묶어서 원자적으로 처리하기 때문에 동시성 제어를 할 수 있게 된 것입니다.

- **Redis에서 한 번에 좌석 상태 조회 & 좌석 상태 변경**

그리고 **락을 사용하지 않기 때문에 동시간대에 처리할 수 있는 트래픽의 수도 늘어납니다.** <br>




🍕 <strong>의사결정/사유</strong>

고민을 거듭한 끝에 저는 좌석 예매 기능에 **락 없이 Redis Lua script를 사용하기로 결정했습니다.**

- **원자성 보장**
- **빠른 속도**

그리고 자료형은 Redis에 `예매 가능한 좌석 id`만 들어가기 때문에 조회와 삭제의 시간복잡도가 O(1)로 매우 빠른 **`Set` 자료형**을 사용하기로 했습니다.

  </details>
      <div>
      <h4>1. Before - 분산 락</h4>
      <img src = "https://github.com/user-attachments/assets/8e3299f5-6063-463d-80e1-d98d5c1e9ae9">
      <h4>2. After - Lua Script</h4>
      <img src = https://github.com/user-attachments/assets/6afd52bc-6bc0-4c40-8708-0998667f81fe>
      <h4>성능비교</h4>
      <img src = https://github.com/user-attachments/assets/38ad2cc8-b2f7-4ab6-82d9-1371a1b9ff6f>
     응답 속도 평균 40~50% 향상 <br>
      처리량 약 55% 증가
      </div>
</div>

### 🍕 Batch No-Offset Reader를 사용한 성능 개선
<details> 
    <summary>
      더보기
    </summary>
      <h3>📌 배경</h3> 

- **27만건의 결제 데이터에 대해 CHUNK_SIZE 100 으로 수행**
- **27만건의 상대적으로 적은 데이터임에도 1시간 12분으로 오래걸림**

### 🚨문제점 

1. **ItemReader의 Offset 조회 방식**
  - Offset 기반 쿼리는 **OFFSET만큼의 데이터를 읽고 무시**한 후 결과를 반환.
  - 데이터가 많아질수록 **불필요한 읽기 작업**이 증가해 성능 저하.
2. **ItemWriter의 JPA saveAll**
  - **Chunk_size**만큼 반복적으로 **INSERT** 쿼리를 실행.
  - 개별 INSERT 쿼리가 많아 대량 쓰기 작업에서 비효율적.

**3 .  Processor의 Feign통신**

- ItemReader의 경우 read()메서드를 통해 데이터를 한건씩 반환.
- Processor에서 네트워크 통신을 진행할 경우 모든 데이터에 대해 네트워크 통신으로 인해응답시간*데이터 개수 만큼의 처리시간 발생

### 해결 방안 🔧

1. **Offset 대신 ID 기반 조회**
  - Offset 조회 대신, Primary Key (ID)를 기준으로 조건 조회.
  - 이전 페이지의 **최대 ID**를 기억하고 `WHERE id > ? LIMIT ?` 형태로 데이터를 읽음.
  - **불필요한 읽기 제거**로 조회 성능 대폭 개선.

    ```java
    //Redis에 이전에 조회한 ID 저장
    redisTemplate.opsForValue().set(OFFSET_KEY, "0", 60000, TimeUnit.MILLISECONDS);
    // QueryDsl Id를 기준으로 조회하도록 수
     List<PaymentResponseDto> results = queryFactory
                    .select(Projections.constructor(
                            PaymentResponseDto.class,
                            payment.id,
                            payment.settlementStatus,
                            payment.payStatus,
                            payment.amount,
                            payment.reservation.concertId))
                    .from(payment)
                    .where(
                            payment.settlementStatus.eq(settlementStatus),
                            payment.payStatus.eq(payStatus),
                            payment.paidAt.before(before),
                            payment.id.gt(currentOffset))
                    .orderBy(payment.id.asc())
                    .limit(chunk)
                    .fetch();
    ```

2. **JdbcTemplate로 대량 INSERT 처리**
  - JPA 대신 **JdbcTemplate**를 활용하여 **Batch Insert** 구현.
  - 하나의 쿼리로 여러 Row를 처리해 데이터 쓰기 성능 최적화.

    ```java
    
    jdbcTemplate.batchUpdate(
        "INSERT INTO table_name (col1, col2) VALUES (?, ?)",
        new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, dataList.get(i).getCol1());
                ps.setString(2, dataList.get(i).getCol2());
            }
    
            @Override
            public int getBatchSize() {
                return dataList.size();
            }
        });
    ```

3. **Processor → Writer로 이관**
  - Writer에서 아래 코드를 통해 concertId에 대한 hostId를 가져오도록 변경

    ```java
    //Writer
    ResponseEntity<ConcertHostResponseDto> concertResponse = concertClient.findHostIdsByConcertIds(requestDto);
    log.info("콘서트 feign 응답코드 : {}", concertResponse.getStatusCode());
    Map<String, Long> hostIds = concertResponse.getBody().getResult();
    ```

</details>

### 📌 요약

- 약 **30만 건**의 데이터를 처리하는 배치에서 데이터 읽기(ItemReader)와 쓰기(ItemWriter) 단계에서 **지연** 발생.
- 주요 병목은 **Offset 기반 조회**와 **JPA의 saveAll**로 인한 비효율적 작업 처리
- ItemProcessor에서 발생하는 과도한 Api 통신

#### 수행시간 1시간 12분 → 14분 5배 감소

#### 성능 개선율 약 80%
![image](https://github.com/user-attachments/assets/fd4d1b50-ff50-48e4-b698-2e6e5c14c021)
![image](https://github.com/user-attachments/assets/0273fd56-0e5e-40d1-a8c8-83cf26c040b2)

### 🍕 트러블 슈팅 템플릿
<details> 
    <summary>
      더보기
    </summary>
</details>

# 📉 성능 개선
[성능 개선 문서](https://abalone-kicker-cfb.notion.site/131aebc7cf8780e9a5c7d85b79c93ffc?pvs=4)
