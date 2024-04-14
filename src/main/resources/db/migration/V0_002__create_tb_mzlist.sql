CREATE TABLE tb_mzlist (
    mzlist_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '맛집리스트 ID',
    mzlist_owner_id BIGINT NOT NULL COMMENT '맛집리스트 소유자 ID',
    mzlist_name VARCHAR(40) NOT NULL COMMENT '맛집리스트 이름',
    mzlist_description VARCHAR(100) COMMENT '맛집리스트에 대한 설명',
    mzlist_icon VARCHAR(40) COMMENT '맛집리스트 아이콘',
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    create_user BIGINT NOT NULL DEFAULT -1 COMMENT '생성자',
    update_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
    update_user BIGINT NOT NULL DEFAULT -1 COMMENT '수정자',
    PRIMARY KEY (mzlist_id),
    FOREIGN KEY (mzlist_owner_id) REFERENCES tb_user (user_id)
) COMMENT = '맛집리스트 테이블';