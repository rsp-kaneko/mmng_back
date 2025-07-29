
-- roles
INSERT IGNORE INTO roles(role_id, role_name) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_GENERAL');
	
-- users
INSERT IGNORE INTO users(user_id, role_id, user_name, password) VALUES
	(1, 1, 'admin', '$2a$10$ZjkKtlzxPo4WWiWqwC1/9eooXgzcfWl03fYYmc0NCsAnTyKY4BX7q'),
	(2, 2, 'test', '$2a$10$011GzB01loHZnRll.Kyh4ek2Ebm.3Of66Um4XYKo6k4kWEBys7QUe');