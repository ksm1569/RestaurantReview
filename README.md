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
- restaurant

  <img width="600" src="https://github.com/ksm1569/DevBlog/assets/34292113/7bf7d0d9-50be-4497-baf8-7e2f1ae0ae4e">

- menu

  <img width="600" src="https://github.com/ksm1569/DevBlog/assets/34292113/c50be997-ce77-4bb1-96bb-90e9a47bc534">

- review

  <img width="600" src="https://github.com/ksm1569/DevBlog/assets/34292113/9b8c05b6-18eb-410f-9800-3914f2dba8bc">

### 🧑‍💻 Mapping spec
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


- 해당 맛집정보 조회 

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


- 맛집 생성
 
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


- 맛집 삭제

DELETE /restaurant/{restaurantId}
