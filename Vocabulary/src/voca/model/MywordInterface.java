package voca.model;

import java.sql.SQLException;

import voca.exception.Notwordexception;

public interface MywordInterface {
	
	public boolean mywordInsert(int wordId) throws SQLException, Notwordexception;
//	public boolean mywordInsert(Word word) throws SQLException, Notwordexception;


	public boolean mywordDelete(int wordId) throws SQLException;







	
}
