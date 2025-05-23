package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	public void updateDb(int id, EntForm entform) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("編集の実行");
		db.update("UPDATE chat SET name = ?, comment = ? WHERE id = ?",
				entform.getName(),entform.getComment(),id);
	}

	public List<EntForm> selectOne(Long id) {
		// TODO 自動生成されたメソッド・スタブ
				//コンソールに表示
				System.out.println("編集画面を出します");
				//データベースから目的の1件を取り出して、そのままresultDB1に入れる
				List<Map<String, Object>> resultDb1 = db.queryForList("SELECT * FROM chat where id=?", id);
				//画面に表示しやすい形のList(resultDB2)を用意
				List<EntForm> resultDb2 = new ArrayList<EntForm>();
				//1件ずつピックアップ
				for (Map<String, Object> result : resultDb1) {
					//データ1件分を1つのまとまりとするので、EntForm型の「entformdb」を生成
					EntForm entformdb = new EntForm();
					//id、name、phoneのデータをentformdbに移す
					entformdb.setId((int) result.get("id"));
					entformdb.setName((String) result.get("name"));
					entformdb.setComment((String) result.get("comment")); // ← 追加
					//移し替えたデータを持ったentformdbを、resultDB2に入れる
					resultDb2.add(entformdb);
				}
				//Controllerに渡す
				return resultDb2;
	}
}
