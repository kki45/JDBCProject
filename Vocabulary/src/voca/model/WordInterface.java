package voca.model;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.vo.WordFormVO;

public interface WordInterface {

	public ArrayList<WordFormVO> getAllVoca() throws SQLException;
	
	public WordFormVO searchVoca(String koreanWord) throws SQLException;
	
	public boolean addVoca(WordFormVO word) throws SQLException;
	
	public boolean updateVoca(WordFormVO wordFormVo) throws SQLException;
	
	public boolean deleteVoca(WordFormVO wordFormVO) throws SQLException;
}
