CREATE TABLE tb_user_mzlist_mapping (
    user_id BIGINT NOT NULL COMMENT '사용자 ID',
    mzlist_id BIGINT NOT NULL COMMENT '맛집리스트 ID',
    mzlist_management_role VARCHAR(20) NOT NULL COMMENT '맛집리스트 관리 역할 (WRITE, READ, ADMIN)',
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    create_user BIGINT NOT NULL DEFAULT -1 COMMENT '생성자',
    update_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
    update_user BIGINT NOT NULL DEFAULT -1 COMMENT '수정자',
    PRIMARY KEY (user_id, mzlist_id),
    FOREIGN KEY (user_id) REFERENCES tb_user (user_id),
    FOREIGN KEY (mzlist_id) REFERENCES tb_mzlist (mzlist_id)
) COMMENT = '사용자 맛집리스트 관계 테이블';