CREATE TABLE tb_user (
    user_id BIGINT NOT NULL AUTO_INCREMENT COMMENT '사용자 ID',
    name VARCHAR(20) NOT NULL COMMENT '사용자 이름',
    nickname VARCHAR(20) COMMENT '사용자 별명',
    password VARCHAR(64) NOT NULL COMMENT '비밀번호',
    birthday DATE NOT NULL COMMENT '사용자 생년월일',
    gender VARCHAR(1) NOT NULL COMMENT '사용자 성별(M-남성/F-여성)',
    authority_code VARCHAR(20) NOT NULL COMMENT '사용자 권한 코드',
    use_yn VARCHAR(1) NOT NULL COMMENT '사용 여부(Y-사용중/N-휴면계정)',
    create_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
    create_user BIGINT NOT NULL DEFAULT -1 COMMENT '생성자',
    update_date DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '수정일시',
    update_user BIGINT NOT NULL DEFAULT -1 COMMENT '수정자',
    PRIMARY KEY (user_id)
) COMMENT '사용자 테이블';