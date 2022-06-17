package voca.controller;

import java.sql.SQLException;

import voca.service.WordGameService;
import voca.view.RunningEndView;

public class WordGameController {
	private static WordGameController instance = new WordGameController();
	private static WordGameService service = WordGameService.getInstance();
	
	private WordGameController() {}
	
	public static WordGameController getInstance() {
		return instance;
	}
	
	
	// 단어 게임 리스트 출력
	public static String wordGameList() {
		String korean = "";
		try {
			korean = RunningEndView.getWordGameList(service.wordGameStart());
			return korean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return korean;
	}
	
	public int calcScore(String[] qna) {
		int correct = 0;
		try {
			return correct = service.calcScore(qna);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return correct;
	}
	
	public void insertWordGame(String name, int score ) {
		try {
			service.insertWordGame(name, score);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	
}
