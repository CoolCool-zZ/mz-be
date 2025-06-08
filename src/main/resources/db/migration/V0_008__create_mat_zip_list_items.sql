CREATE TABLE mat_zip_list_items (
    list_id INT NOT NULL,
    mat_zip_id INT NOT NULL,
    added_user_id INT NOT NULL,
    created_by INT,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INT,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    PRIMARY KEY (list_id, mat_zip_id),
    FOREIGN KEY (list_id) REFERENCES mat_zip_lists(list_id) ON DELETE CASCADE,
    FOREIGN KEY (mat_zip_id) REFERENCES mat_zips(mat_zip_id) ON DELETE CASCADE,
    FOREIGN KEY (added_user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    INDEX idx_mat_zip_list_items_added_user_id (added_user_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;