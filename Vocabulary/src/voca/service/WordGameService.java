package voca.service;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.dao.WordGameDAO;
import voca.dto.Word;
import voca.model.WordGameInterface;

public class WordGameService implements WordGameInterface{

	private static WordGameService instance = new WordGameService();
	
	private WordGameService() {}
	
	public static WordGameService getInstance() {
		return instance;
	}
	
	@Override
	public void selectWordGame() {
		
	}

	@Override
	public void insertWordGame(String name, int score) throws SQLException {
		WordGameDAO.insertWordgame(name, score);
	}

	@Override
	public void updateWordGame() {
		
	}

	@Override
	public void deleteWordGame() {
		
	}
	
	@Override
	public ArrayList<Word> wordGameStart() throws SQLException {
		return WordGameDAO.wordgameList();
	}

	@Override
	public int calcScore(String[] qna) throws SQLException {
		return WordGameDAO.caculateScore(qna);
	}


}
