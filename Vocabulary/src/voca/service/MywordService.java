package voca.service;

import java.sql.SQLException;
import java.util.ArrayList;

import exception.Notwordexception;
import voca.dao.FormDAO;
import voca.dao.MywordDAO;
import voca.dao.WordDAO;
import voca.dto.MywordDTO;
import voca.dto.Word;
import voca.dto.WordMyword;
import voca.model.MywordInterface;
import voca.vo.WordFormVO;

public class MywordService implements MywordInterface{
	
	private static MywordService instance = new MywordService();
	
	public MywordService() {};
	
	public static MywordService getInstance() {
		return instance;
	}

	//조인된 myword
	public ArrayList<WordMyword> join2Voca() throws SQLException{
		ArrayList<WordMyword> join2Voca = MywordDAO.join2Voca();
		return join2Voca;
	}
	
	//myword 하나만 출력
	public WordMyword oneWord(int myNumber) throws SQLException{
		WordMyword oneword = MywordDAO.oneWord(myNumber);
		return oneword;
	}
	
	// 여러개 출력
	public ArrayList<WordMyword> join3Voca(int num) throws SQLException {
		ArrayList<WordMyword> join3Voca = MywordDAO.join3Voca(num);
		if(join3Voca.size() == num) {
			return join3Voca;
		}
		return null;
	}
	
	//즐겨찾기 추가
	@Override
	public boolean mywordInsert(int wordId) throws SQLException, Notwordexception {	

			if(MywordDAO.myword_id(wordId) == null) {
					return MywordDAO.addWord(wordId);
				}else{
						throw new Notwordexception("이미 단어가 존재합니다");		
					}
	}

	//즐겨찾기 삭제
	@Override
	public boolean mywordDelete(int myNumber) throws SQLException, Notwordexception {
		
		if(MywordDAO.myWordto(myNumber) != null) {
			return MywordDAO.deleteWord(myNumber);
		}else{
				throw new Notwordexception("삭제할 단어가 존재하지 않습니다");
				
			}
	}
	
}
