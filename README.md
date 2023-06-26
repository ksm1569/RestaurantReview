# 맛집리뷰 API
### ✨ 개발 목적 및 개요
맛집관리, 리뷰 및 별점 관리를 통한 토이 프로젝트로 공부목적

- REST API 이해
- SPRING BOOT 공부 - 어노테이션, H2 Database 등 이해
- JPA 공부 - Repository, QueryDSL, Pageable, Slice 등 이해 
- Docker 및 AWS 배포를 통한 공부 및 기록


### 🔨 사용한 프레임웍, 라이브러리 및 툴
- IntelliJ Ultimate
- Postman
- Docker
- JAVA 17
- Lombok
- Spring Boot
- AWS EC2


### ✍ Flow
- 맛집을 조회, 등록, 수정, 삭제 할 수 있다.
- 맛집에 등록된 리뷰를 조회, 등록, 삭제 할 수 있다.
- 맛집에 등록된 평균 별점을 조회 할 수 있다.


### 📜 ERD
<p align="center">
  <img width="600" src = "https://github.com/ksm1569/RestaurantReview/assets/34292113/809bf957-d2e8-46ff-a6f4-f3f9a8691eca">
</p>


### 👨‍💻 Entity Code
<details>
<summary>접기/펼치기 버튼</summary>
<div markdown="1">

- restaurant

  <img width="600" src="https://github.com/ksm1569/DevBlog/assets/34292113/7bf7d0d9-50be-4497-baf8-7e2f1ae0ae4e">

- menu

  <img width="600" src="https://github.com/ksm1569/DevBlog/assets/34292113/c50be997-ce77-4bb1-96bb-90e9a47bc534">

- review

  <img width="600" src="https://github.com/ksm1569/DevBlog/assets/34292113/9b8c05b6-18eb-410f-9800-3914f2dba8bc">

</div>
</details>


### 🧑‍💻 Mapping spec

<details>
<summary>접기/펼치기 버튼</summary>
<div markdown="2">

<br></br>
- 맛집 리스트 전체 조회

GET /restaurants
```JSON
[
  {
    "id": Long,
    "name": string,
    "address": string,
    "createdAt": string,
    "updatedAt": string
  },
]
```
<br></br>
- 해당 맛집 정보 조회 

GET /restaurant/{restaurantId}
```JSON
{
  "id": Long,
  "name": string,
  "address": string,
  "createdAt": string,
  "updatedAt": string,
  "menus": [
    {"id": Long, "name": string, "price": int, "createdAt": string, "updatedAt": string},
    {"id": Long, "name": string, "price": int, "createdAt": string, "updatedAt": string},
  ]
}
```
<br></br>
- 맛집 등록
 
POST /restaurant
```JSON
{
  "name": string,
  "address": string,
  "menus": [
    {"name": string, "price": int},
  ]
}
```
<br></br>
- 맛집 수정

PUT /restaurant/{restaurantId}
```JSON
{
  "name": string,
  "address": string,
  "menus": [
    {"name": string, "price": int},
  ]
}
```
<br></br>
- 맛집 삭제

DELETE /restaurant/{restaurantId}

<br></br>
- 리뷰 등록

POST /review
```JSON
{
  "restaurantId": int,
  "content": string,
  "score": float
}
```
<br></br>
- 리뷰 삭제

DELETE /review/{reviewId}
<br></br>
- 맛집에 등록된 전체 리뷰 조회

GET /restaurant/{restaurantId}/reviews
```JSON
{
  "avgScore": float, // 평균 별점
  "reviews": [
    {"id": int, "content": string, "score": float, "createdAt": string},
    {"id": int, "content": string, "score": float, "createdAt": string},
    {"id": int, "content": string, "score": float, "createdAt": string}
  ],
  "page": {
    "offset": int,
    "limit": int
  }
}
```
<br></br>

</div>
</details>


### ☑ API 통신 테스트, 데이터베이스 확인
<details>
<summary>접기/펼치기 버튼</summary>
<div markdown="3">

- API테스트
  
  <img width="600" src="https://github.com/ksm1569/RestaurantReview/assets/34292113/c75f7f3d-f652-4e18-b6e0-94be7a0e7596">


- 맛집 테이블 조회

  <img width="600" src="https://github.com/ksm1569/RestaurantReview/assets/34292113/54c86c82-8343-4ec3-9d9c-f99e899a4ac4">


- 리뷰 테이블 조회

  <img width="600" src="https://github.com/ksm1569/RestaurantReview/assets/34292113/75e5405a-0964-45bc-8ef2-ad9d784de14e">


</div>
</details>


### ⚙ Docker, AWS 설정
```Java
// application.properties
spring.h2.console.settings.web-allow-others=true
```

```Shell
# Dockerfile

FROM amazoncorretto:17

WORKDIR /app

COPY ./build/libs/review-0.0.1-SNAPSHOT.jar /app/review.jar
COPY ./entry-point.sh /app/entry-point.sh
RUN chmod +x /app/entry-point.sh

ENTRYPOINT ["./entry-point.sh"]
```

```Shell
# entry-point.sh

#!/bin/bash

java -jar /app/review.jar
```

```Shell
# docker-compose.yml

version: "3.8"

services:
  review-api:
    build:
      context: .
      dockerfile: Dockerfile
    ports:
      - 8080:8080
```

```Shell
# Docker Contianer Image 빌드하기
$ docker build -t review-api ./

# Docker Container 실행하기
$ docker run -it -p 8080:8080 review-api

# Docker Compose 실행하기
$ docker-compose up --build

```

AWS EC2 인스턴스 만들고 -> 인바운드 규칙에 포트 설정 후 -> git 설치끝나면 clone 해준다음에 설정 사항들

```Shell
# git, docker, jdk 설치
$ sudo yum install -y git docker java-17-amazon-corretto

# docker-compose 설치
$ sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose
$ sudo chmod +x /usr/local/bin/docker-compose

# 도커 실행
$ sudo service docker start

# 자바 애플리케이션 빌드
$ ./gradlew bootJar

# 서버 실행
$ sudo docker-compose up --build

# 서버 백그라운드 실행
$ sudo docker-compose up -d --build

```

<img width="600" src="https://github.com/ksm1569/RestaurantReview/assets/34292113/7d56b245-d7ed-4cc2-8054-99a07423627c">

### ✌ 마치며
스프링 프레임워크와 JPA라는 기술들로 RESTAPI 통신을 하여,

백엔드단의 기본기를 다지고 복습을 해보는 과정이였다.

까먹은 내용도 있고, AWS 배포부분까지는 해본 적이 없어서 괜찮은 시간이였다고 생각이 든다.

앞으로는 토이프로젝트들을 깃허브에 넣어두고 기록도 해두어서 틈틈히 들여다봐야겠다.
