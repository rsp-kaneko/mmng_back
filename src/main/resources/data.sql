
-- roles
INSERT IGNORE INTO roles(role_id, role_name) VALUES
	(1, 'ROLE_ADMIN'),
	(2, 'ROLE_GENERAL');
	
-- users
INSERT IGNORE INTO users(user_id, role_id, user_name, password) VALUES
	(1, 1, 'admin', '$2a$10$ZjkKtlzxPo4WWiWqwC1/9eooXgzcfWl03fYYmc0NCsAnTyKY4BX7q'),
	(2, 2, 'test', '$2a$10$011GzB01loHZnRll.Kyh4ek2Ebm.3Of66Um4XYKo6k4kWEBys7QUe');
	
-- parts_categories
INSERT IGNORE INTO parts_categories(parts_category_id, category_name, icon_url) VALUES
	(1, 'ボトムブラケット', null),
	(2, 'クランク', null),
	(3, 'スプロケット', null),
	(4, 'フロントディレイラー', null),
	(5, 'リアディレイラー', null),
	(6, 'ホイール', null),
	(7, 'タイヤ', null),
	(8, 'タイヤチューブ', null),
	(9, 'ブレーキ', null),
	(10, 'シフター', null),
	(11, 'チェーン', null),
	(12, 'ケーブル', null),
	(13, 'ペダル', null),
	(14, 'サドル', null),
	(15, '附属品', null);
