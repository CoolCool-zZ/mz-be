# 2024 MZ Project
## Postman Script
src/main/resources/postman 하위에 있는 postman script로 테스트 가능
## DB 서버
### 실행
```bash
docker-compose up -d
```
### 종료
```bash
docker-compose down
```
### 서버 접속
```bash
docker exec -it coolcool-mysql bash
mysql -u root -p
```

## TO-DO
- swagger 추가
- jpa 관련 공부 후 entity, dto 폴더 구조 다시 정리하기
