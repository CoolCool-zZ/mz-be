CREATE TABLE mat_zip_list_shares (
    share_id INT AUTO_INCREMENT PRIMARY KEY,
    list_id INT NOT NULL,
    shared_user_id INT NOT NULL,
    shared_by_user_id INT NOT NULL,
    can_edit_list_info BOOLEAN NOT NULL DEFAULT FALSE,
    can_edit_list_items BOOLEAN NOT NULL DEFAULT FALSE,
    can_edit_shared_users BOOLEAN NOT NULL DEFAULT FALSE,
    shared_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    created_by INT,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INT,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (list_id) REFERENCES mat_zip_lists(list_id) ON DELETE CASCADE,
    FOREIGN KEY (shared_user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    FOREIGN KEY (shared_by_user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    UNIQUE KEY uk_list_shared_user (list_id, shared_user_id),
    INDEX idx_mat_zip_list_shares_shared_user_id (shared_user_id),
    INDEX idx_mat_zip_list_shares_shared_by_user_id (shared_by_user_id),
    INDEX idx_mat_zip_list_shares_shared_at (shared_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;