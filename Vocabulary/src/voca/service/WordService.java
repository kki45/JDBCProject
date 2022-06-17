package voca.service;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.dao.WordDAO;
import voca.dto.Form;
import voca.dto.Word;
import voca.vo.WordFormVO;
import voca.model.WordInterface;

public class WordService implements WordInterface{

	private static WordService instance = new WordService();

	private WordService() {}

	public static WordService getInstance(){
		return instance;
	}

	@Override
	public ArrayList<WordFormVO> getAllVoca() throws SQLException {
		ArrayList<WordFormVO> allVoca = WordDAO.getAllVoca(); 
		return allVoca;
	}

	@Override
	public void wordInsert() {
		// TODO Auto-generated method stub

	}

	@Override
	public void wordUpdate() {
		// TODO Auto-generated method stub

	}

	@Override
	public void wordDelete() {
		// TODO Auto-generated method stub

	}

	public WordFormVO searchVoca(String koreanWord) throws SQLException {

		WordFormVO wordFormVO = WordDAO.searchVoca(koreanWord);
		return wordFormVO;
	}

	//   public boolean addWord(Word word) {
	//      
	//   }
	//   
	//   public boolean addForm(Word word) {
	//      
	//   }


}