CREATE TABLE tags (
    tag_id INT AUTO_INCREMENT PRIMARY KEY,
    tag_name VARCHAR(50) NOT NULL,
    color VARCHAR(20),
    created_user_id INT NOT NULL,
    created_by INT,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INT,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (created_user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    INDEX idx_tags_tag_name (tag_name),
    INDEX idx_tags_created_user_id (created_user_id),
    UNIQUE KEY uk_tags_name_user (tag_name, created_user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;