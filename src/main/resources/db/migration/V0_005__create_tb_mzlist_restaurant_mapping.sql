CREATE TABLE tb_mzlist_restaurant_mapping (
    mzlist_id BIGINT NOT NULL COMMENT '맛집리스트 ID',
    restaurant_id BIGINT NOT NULL COMMENT '음식점 ID',
    restaurant_nickname VARCHAR(40) COMMENT '음식점 별명',
    restaurant_memo TEXT COMMENT '맛집리스트 내의 음식점에 대한 사용자의 메모',
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    create_user BIGINT NOT NULL DEFAULT -1 COMMENT '생성자',
    update_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
    update_user BIGINT NOT NULL DEFAULT -1 COMMENT '수정자',
    PRIMARY KEY (mzlist_id, restaurant_id),
    FOREIGN KEY (mzlist_id) REFERENCES tb_mzlist (mzlist_id),
    FOREIGN KEY (restaurant_id) REFERENCES tb_restaurant (restaurant_id)
) COMMENT = '맛집리스트 음식점 관계 테이블';