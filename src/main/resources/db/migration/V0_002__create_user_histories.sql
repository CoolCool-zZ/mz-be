CREATE TABLE user_histories (
    user_history_id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    username VARCHAR(50),
    email VARCHAR(100),
    password VARCHAR(255),
    phone_number VARCHAR(20),
    full_name VARCHAR(100),
    is_active BOOLEAN,
    last_login_at DATETIME,
    email_verified_at DATETIME,
    email_verification_token VARCHAR(255),
    password_reset_token VARCHAR(255),
    password_reset_expired_at DATETIME,
    created_by INT,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_by INT,
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,

    FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
    INDEX idx_user_histories_user_id (user_id),
    INDEX idx_user_histories_created_at (created_at)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;