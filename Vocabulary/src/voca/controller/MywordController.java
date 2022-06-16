package voca.controller;

import java.sql.SQLException;

import voca.dto.MywordDTO;
import voca.service.MywordService;
import voca.view.RunningEndView;

public class MywordController {
	private static MywordController instance = new MywordController();
	private MywordService myservice = MywordService.getInstance();
	
	public static MywordController getInstance() {
		return instance;
	}
	
	// word, form, myword 테이블 조인하기
	public void join2Voca() {
		try {
			RunningEndView.join2Voca(myservice.join2Voca());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// myword테이블에 word_id로 즐겨찾기하기
	public void bookmark(MywordDTO myword) {
		try {
			myservice.mywordInsert(myword);
			System.out.println("즐겨찾기 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("즐겨찾기 실패");
		}
	}
	
	//myword테이블에서 word_id로 삭제하기
	public void deleteBmark(int word_id) {
		try {
			myservice.mywordDelete(word_id);
			System.out.println("즐겨찾기 삭제성공");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("즐겨찾기 삭제 실패");
		}
	}

	
}
