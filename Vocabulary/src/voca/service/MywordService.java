package voca.service;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.dao.MywordDAO;
import voca.dto.MywordDTO;
import voca.dto.WordMyword;
import voca.model.MywordInterface;

public class MywordService implements MywordInterface{
	
	private static MywordService instance = new MywordService();
	
	public MywordService() {};
	
	public static MywordService getInstance() {
		return instance;
	}
	
	public ArrayList<WordMyword> join2Voca() throws SQLException{
		ArrayList<WordMyword> join2Voca = MywordDAO.join2Voca();
		return join2Voca;
		
	}

	@Override
	public void mywordSelect() {
		
	}

	@Override
	public boolean mywordInsert(MywordDTO myword) throws SQLException {
		 return MywordDAO.addWord(myword);
	}

	@Override
	public void mywordUpdate() {
		
	}

	@Override
	public boolean mywordDelete(int word_id) throws SQLException {
		return MywordDAO.deleteWord(word_id);
	}

	

	

}
