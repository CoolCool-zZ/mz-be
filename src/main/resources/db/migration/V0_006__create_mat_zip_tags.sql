CREATE TABLE mat_zip_tags (
    mat_zip_id INT NOT NULL,
    tag_id INT NOT NULL,
    added_user_id INT NOT NULL,
    created_by INT,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INT,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (mat_zip_id, tag_id),
    FOREIGN KEY (mat_zip_id) REFERENCES mat_zips(mat_zip_id) ON DELETE CASCADE,
    FOREIGN KEY (tag_id) REFERENCES tags(tag_id) ON DELETE CASCADE,
    FOREIGN KEY (added_user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    INDEX idx_mat_zip_tags_added_user_id (added_user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;