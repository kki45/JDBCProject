package voca.model;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.dto.Word;
import voca.vo.WordFormVO;

public interface WordInterface {

	public ArrayList<WordFormVO> getAllVoca() throws SQLException;

	public void wordInsert();

	public void wordUpdate();
   
	public void wordDelete();
   
	public WordFormVO searchVoca(String koreanWord) throws SQLException;
}
