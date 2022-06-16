package voca.model;

import java.sql.SQLException;

import voca.dto.MywordDTO;

public interface MywordInterface {
	
	public void mywordSelect();

	public boolean mywordInsert(MywordDTO myword) throws SQLException;

	public void mywordUpdate();

	public boolean mywordDelete(int word_id) throws SQLException;



	
}
