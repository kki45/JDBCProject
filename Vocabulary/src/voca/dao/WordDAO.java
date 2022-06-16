package voca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import voca.dbutil.DBUtil;
import voca.dto.Word;

public class WordDAO {
	
	
	/*
	 * 모든 단어값 알파벳 a부터 검색
	 * 
	 */
	public static ArrayList<Word> getAllVoca() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Word> list = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from word order by english_word ");
			rset = pstmt.executeQuery();

			list = new ArrayList<Word>();
			while (rset.next()) {
				list.add(new Word(rset.getInt(1), rset.getString(2), rset.getString(3)));
			}
		}
		
		
		finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	
	
}
