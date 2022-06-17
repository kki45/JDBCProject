package voca.service;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.dao.WordDAO;
import voca.dto.Form;
import voca.dto.Word;
import voca.dto.WordFormVO;
import voca.model.WordInterface;

public class WordService implements WordInterface {

	private static WordService instance = new WordService();

	private WordService() {
	}

	public static WordService getInstance() {
		return instance;
	}

	@Override
	public ArrayList<WordFormVO> getAllVoca() throws SQLException {
		ArrayList<WordFormVO> allVoca = WordDAO.getAllVoca();
		return allVoca;
	}

	public WordFormVO searchVoca(String koreanWord) throws SQLException {

		return WordDAO.searchVoca(koreanWord);
	}

	public boolean addVoca(WordFormVO word) throws SQLException {
		return WordDAO.addVoca(word);
	}

	public boolean updateVoca(WordFormVO wordFormVo) throws SQLException {
		return WordDAO.updateVoca(wordFormVo);
	}

	public boolean deleteVoca(WordFormVO wordFormVO) throws SQLException {
		return WordDAO.deleteVoca(wordFormVO);
	}

}
