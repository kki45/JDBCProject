package voca.model;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.dto.Word;
import voca.dto.WordGameDTO;

public interface WordGameInterface {

	public WordGameDTO selectWordGame(String name, int score) throws SQLException ;

	public void selectAllWordGame();

	public void insertWordGame(String name, int score) throws SQLException ;

	public void updateWordGame();

	public void deleteWordGame();

	public ArrayList<Word> wordGameStart() throws SQLException;

	public int calcScore(String[] qna) throws SQLException;


}
