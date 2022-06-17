package voca.service;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.dao.FormDAO;
import voca.dao.MywordDAO;
import voca.dao.WordDAO;
import voca.dto.MywordDTO;
import voca.dto.Word;
import voca.dto.WordMyword;
import voca.exception.Notwordexception;
import voca.model.MywordInterface;

public class MywordService implements MywordInterface{
	
	private static MywordService instance = new MywordService();
	
	public MywordService() {};
	
	public static MywordService getInstance() {
		return instance;
	}
	
	//CRUD
//	public void errorMyword(ArrayList<WordMyword> join2Voca) throws SQLException, Notwordexception {
//		ArrayList<WordMyword> checkword = MywordDAO.join2Voca();
//		if(checkword == null) {
//			throw new Notwordexception("이미있는 단어입니다");
//		}
//	}
	
	//조인된 myword
	public ArrayList<WordMyword> join2Voca() throws SQLException{
		ArrayList<WordMyword> join2Voca = MywordDAO.join2Voca();
		return join2Voca;
	}
	
	//myword
	public ArrayList<MywordDTO> myWordto() throws SQLException{
		ArrayList<MywordDTO> myWordto = MywordDAO.myWordto();
		return myWordto;
	}
	
	//즐겨찾기 추가
	@Override
	public boolean mywordInsert(int wordId) throws SQLException, Notwordexception {		
//	public boolean mywordInsert(Word word) throws SQLException, Notwordexception {
		
//		if(WordDAO.getWord(word.getWordId()) == MywordDAO.addWord(wordId) {
//		
//		
//		
//		
//		
//		
//		
//		
//		return false;
//	}
		// 영어 단어명이 이미 myword에 있으면 추가 불가능
		// myword에 wordId가 있는지 확인
		
////		if(WordDAO.getWord(word.getWordId()) == MywordDAO.addWord(neword.getWordId())) {
////			
////		}
////		WordDAO.getWord(wordId);
////		MywordDAO.addWord(myNumber, wordId);
//		// 비교결과 값이 있다고 하는  return이 되면 -> throw new 
//		// 없다고 하면 그때 insert!! -> MywordDAO.addWord(wordId)
////		if(MywordDAO.addWord(wordId)
//		
////		return false;
		
		
		

//			Word existWord = WordDAO.getWord(word.getWordId())
//			Form form = FormDAO.getForm(word.getFormId())
//		boolean check =  MywordDAO.addWord(myword);
//		if (check == true) {
//			return check;
//		}else {
//			try {
//				errorMyword(join2Voca());
//			} catch (SQLException | Notwordexception e) {
//				e.printStackTrace();
//			}
//		}
//		return false;
		
		// 기존의 영어 단어가 있을경우 새로 추가 불가능
		// 새롭게 넣어줄 영어단어 = 기존 영어 단어(WordMyWord)
		
//		ArrayList<WordMyword> oldword = new ArrayList<WordMyword>();
//		ArrayList<MywordDTO> neword = new ArrayList<MywordDTO>();
//		
//		MywordDTO mydto = null;
//		boolean check = MywordDAO.addWord(wordId);
//		
//		for(int i = 0; i < oldword.size(); i++) {
//			for( int j = 0; j < neword.size(); j++) {
//			if(oldword.get(i).getMyNumber() != neword.get(j).getMyNumber()) {
//					return check;
//				}else{
//						throw new Notwordexception("이미 단어가 존재합니다");
//					}
//			}
//		}
//		return false;
//	}
		
		
//		if(check) {
//			return check;
//			if(oldword.get(i).getMyNumber() == neword.get(j).getMyNumber())
//		}
//		return false;
//}
		
		MywordDTO mydto = null;
		boolean check =  MywordDAO.addWord(wordId);
		if (check) {
			return check;
		}else {
			if(mydto == null) {
			throw new Notwordexception("이미 단어가 존재합니다");
			}
		}
		return false;
		
		}
	


	@Override
	public boolean mywordDelete(int wordId) throws SQLException {
		return MywordDAO.deleteWord(wordId);
	}

	

	

}
