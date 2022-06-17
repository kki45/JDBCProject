package voca.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import voca.dao.WordGameDAO;
import voca.dto.Word;
import voca.dto.WordGameDTO;
import voca.model.WordGameInterface;
import voca.vo.WordFormVO;

public class WordGameService implements WordGameInterface{

	private static WordGameService instance = new WordGameService();
	
	public WordService wordService = WordService.getInstance();
	static ArrayList<Integer> quizNumber = null;
	
	private WordGameService() {}

	public static WordGameService getInstance() {
		return instance;
	}

	@Override
	public WordGameDTO selectWordGame(String name, int score) throws SQLException {
		return WordGameDAO.selectWordGame(name, score);
	}
	@Override
	public void selectAllWordGame() {

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
		
		ArrayList<WordFormVO> allList = wordService.getAllVoca();
		ArrayList<Word> gameList = new ArrayList<Word>();;
		Random rand = new Random();
		int randValue = -1;
		quizNumber = new ArrayList<Integer>(allList.size());
		while(true) {
			randValue = rand.nextInt(allList.size());
			boolean ans = quizNumber.contains(randValue);
			if(ans == false) {
				quizNumber.add(randValue);
				gameList.add(new Word(allList.get(randValue).getWordId(),
						allList.get(randValue).getEnglishWord(),
						allList.get(randValue).getKoreanWord()));

			}
			if(quizNumber.size() == 10) {
				break;
			}
		}
		
		return gameList;
	}

	@Override
	public String getEnglishAnswer(String quiz) throws SQLException{
		String answer = "";
		
		answer = WordGameDAO.getEnglishAnswer(quiz);
		
		return answer;
	}
	
	@Override
	public int calcScore(String[] qna) throws SQLException {
		return WordGameDAO.caculateScore(qna);
	}


}
