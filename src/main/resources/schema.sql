CREATE TABLE chat(
	--`id` NULL禁止、自動増加
	id INT NOT NULL AUTO_INCREMENT,
	--`name` 100文字まで,NULL禁止
	name VARCHAR(100) NOT NULL,
	--`comment`500文字まで,NULL禁止
	comment VARCHAR(500) NOT NULL,
	--`created_at` 現在の時間
	created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	--`id`をprimarykeyに設定
	PRIMARY KEY(id)
);