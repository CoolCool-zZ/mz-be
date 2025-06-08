CREATE TABLE mat_zip_lists (
    list_id INT AUTO_INCREMENT PRIMARY KEY,
    list_name VARCHAR(100) NOT NULL,
    description TEXT,
    owner_id INT NOT NULL,
    created_by INT,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INT,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (owner_id) REFERENCES users(user_id) ON DELETE CASCADE,
    INDEX idx_mat_zip_lists_owner_id (owner_id),
    INDEX idx_mat_zip_lists_list_name (list_name),
    INDEX idx_mat_zip_lists_created_at (created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;