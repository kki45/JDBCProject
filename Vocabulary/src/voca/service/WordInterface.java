package voca.service;

import java.sql.SQLException;
import java.util.ArrayList;

import voca.dto.Word;

public interface WordInterface {

	public ArrayList<Word> getAllVoca() throws SQLException;
	
	public void wordInsert();

	public void wordUpdate();

	public void wordDelete();

}
