CREATE TABLE tb_restaurant (
    restaurant_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '음식점 ID',
    restaurant_name VARCHAR(40) NOT NULL COMMENT '음식점 이름',
    restaurant_address VARCHAR(100) NOT NULL COMMENT '음식점 주소',
    restaurant_category VARCHAR(20) NOT NULL COMMENT '음식점 카테고리',
    open_status VARCHAR(10) NOT NULL COMMENT '사용 여부(OPEN-영업중/CLOSED-휴점,폐점)',
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    create_user BIGINT NOT NULL DEFAULT -1 COMMENT '생성자',
    update_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
    update_user BIGINT NOT NULL DEFAULT -1 COMMENT '수정자',
    PRIMARY KEY (restaurant_id)
) COMMENT = '음식점 테이블';