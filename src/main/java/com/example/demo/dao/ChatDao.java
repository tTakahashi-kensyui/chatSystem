package com.example.demo.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.EntForm;

@Repository
public class ChatDao {

	private final JdbcTemplate db;

	public ChatDao(JdbcTemplate db) {
		this.db = db;
	}
	
	public void insertDb(EntForm entform) {
		// TODO 自動生成されたメソッド・スタブ
		db.update("INSERT INTO chat (name, comment) VALUES (?, ?)",
				entform.getName(), entform.getComment());
	}

	
	public List<EntForm> findAll() {
	    String sql = "SELECT * FROM chat ORDER BY id DESC";  // ID昇順、投稿順に表示
	    return db.query(sql, new BeanPropertyRowMapper<>(EntForm.class));
	}
	
	public void deleteById(int id) {
	    String sql = "DELETE FROM chat WHERE id = ?";
	    db.update(sql, id);
	}
}
