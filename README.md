# 2024 MZ Project
## Postman Script
src/main/resources/postman 하위에 있는 postman script로 테스트 가능

## swagger
http://localhost:8525/mz/swagger-ui/index.html

# Docker
## MySQL만 실행
```bash
docker-compose --profile dev up mysql-dev -d
```

## Redis만 실행
```bash
docker-compose --profile dev up redis-dev -d
```

## 모든 개발 서비스 실행 (MySQL + Redis + Redis GUI)
```bash
docker-compose --profile full up -d
```

## 종료
```bash
docker-compose down
```

## 서버 접속
```bash
docker exec -it coolcool-mysql bash
mysql -u root -p
```

# Spring Boot 애플리케이션 실행
## dev profile
```bash
./gradlew bootRun --args='--spring.profiles.active=dev'
```

# TO-DO
- jpa 관련 공부 후 entity, dto 폴더 구조 다시 정리하기
