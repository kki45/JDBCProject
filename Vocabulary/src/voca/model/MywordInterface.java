package voca.model;

import java.sql.SQLException;

import voca.exception.Notwordexception;
import voca.dto.MywordDTO;
import voca.dto.Word;

public interface MywordInterface {
	
	public boolean mywordInsert(int wordId) throws SQLException, Notwordexception;

	public boolean mywordDelete(int myNumber) throws SQLException, Notwordexception;

}
