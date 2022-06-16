package voca.service;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.dao.WordDAO;
import voca.dto.Word;

public class WordService implements WordInterface{
	
	
	private static WordService instance = new WordService();
	
	private WordService() {}
	
	public static WordService getInstance(){
		return instance;
	}
	
	@Override
	public ArrayList<Word> getAllVoca() throws SQLException {
		ArrayList<Word> allVoca = WordDAO.getAllVoca(); 
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

}
