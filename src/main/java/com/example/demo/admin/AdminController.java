package com.example.demo.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.chat.Chat;
import com.example.demo.dao.ChatDao;
import com.example.demo.entity.EntForm;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final ChatDao chatdao;

    public AdminController(ChatDao chatdao) {
        this.chatdao = chatdao;
    }

    // 管理画面一覧表示
    @GetMapping("/chatlist")
    public String showComments(Model model) {
        List<EntForm> chatList = chatdao.findAll();
        model.addAttribute("chatList", chatList);
        model.addAttribute("title", "コメント管理画面");
        return "admin/chatlist"; // 後述のThymeleafテンプレートを表示
    }

    // 削除処理
    @PostMapping("/chatlist/delete")
    public String deleteComment(int id) {
        chatdao.deleteById(id);
        return "redirect:/admin/chatlist";
    }
    
  //更新画面の表示(SELECT)
  	@RequestMapping("/edit/{id}")
  	public String editView(@PathVariable Long id, Model model) {
  		//DBからデータを1件取ってくる(リストの形)
  		List<EntForm> list = chatdao.selectOne(id);
  		//リストから、オブジェクトだけをピックアップ
  		EntForm entformdb = list.get(0);
  		//スタンバイしているViewに向かって、データを投げる
  		model.addAttribute("chatList", entformdb);
  		model.addAttribute("title", "編集ページ");
  		return "admin/edit";
  	}
    
    @PostMapping("/edit")
    public String editComment(int id, Chat chat) {
    	//フォームの値をエンティティに入れ直し
    			EntForm entform = new EntForm();
    			entform.setName(chat.getName());
    			entform.setComment(chat.getComment());
    			//更新の実行
    	chatdao.updateDb(id,entform);
    	return "redirect:/admin/chatlist";
    }
    
}
