CREATE TABLE mat_zip_list_histories (
    list_history_id INT AUTO_INCREMENT PRIMARY KEY,
    list_id INT NOT NULL,
    list_name VARCHAR(100),
    description TEXT,
    owner_id INT,
    ownership_transferred_by INT,
    change_type ENUM('INFO_UPDATED', 'OWNERSHIP_TRANSFERRED', 'LIST_CREATED') NOT NULL,
    created_by INT,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INT,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    
    FOREIGN KEY (list_id) REFERENCES mat_zip_lists(list_id) ON DELETE CASCADE,
    INDEX idx_mat_zip_list_histories_list_id (list_id),
    INDEX idx_mat_zip_list_histories_change_type (change_type),
    INDEX idx_mat_zip_list_histories_created_at (created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;