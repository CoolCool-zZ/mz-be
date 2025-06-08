CREATE TABLE mat_zips (
    mat_zip_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    address VARCHAR(500),
    description TEXT,
    added_user_id INT NOT NULL,
    created_by INT,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INT,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (added_user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    INDEX idx_mat_zips_added_user_id (added_user_id),
    INDEX idx_mat_zips_name (name),
    INDEX idx_mat_zips_created_at (created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;