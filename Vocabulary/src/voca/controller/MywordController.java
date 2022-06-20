package voca.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.exception.Notwordexception;
import voca.dto.MywordDTO;
import voca.dto.Word;
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
	public void bookmark(int wordId) {
		try {
			myservice.mywordInsert(wordId);
			RunningEndView.showError("즐겨찾기 성공");
		}catch (Notwordexception e) {
				RunningEndView.showError("즐겨찾기 실패2");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("즐겨찾기 실패1");
		} 
	}

	//myword테이블에서 word_id로 삭제하기
	public void deleteBmark(int myNumber) {
		try {
			myservice.mywordDelete(myNumber);
			RunningEndView.showError("즐겨찾기 삭제 성공");
		} catch (SQLException e) {
			e.printStackTrace();
			RunningEndView.showError("즐겨찾기 삭제 실패1");
		} catch (Notwordexception e) {
			RunningEndView.showError("즐겨찾기 삭제 실패2");
		}
	}
	
		// 하나만 출력
	public void oneWord(int myNumber) {
		try {
			RunningEndView.oneWord(myservice.oneWord(myNumber));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 여러개 출력
	public void join3Voca(int num) {
		try {
			RunningEndView.join3Voca(myservice.join3Voca(num));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
