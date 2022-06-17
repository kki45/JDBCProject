package voca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import voca.dbutil.DBUtil;
import voca.dto.Word;
import voca.dto.WordGameDTO;
import voca.vo.WordFormVO;

public class WordGameDAO {
	static int sameCheck = -1;

	public static int caculateScore(String[] qna) throws SQLException{
		int correct = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT COUNT(*) " + 
					"FROM word " + 
					"WHERE korean_word = ? " + 
					"AND english_word = ? ");
			pstmt.setString(1, qna[0]);
			pstmt.setString(2, qna[1]);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				correct = rset.getInt(1);
				return correct;
			}
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}


		return correct;
	}


	public static boolean insertWordgame(String name, int score) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO wordgame(user_name, score, date) "
					+ "VALUES(?, ?, sysdate())");
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			result = pstmt.executeUpdate();
			if(result == 1) {
				return true;
			}

		} finally {
			DBUtil.close(conn, pstmt);
		}

		return false;
	}
	
	public static String getEnglishAnswer(String quiz) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String answer = "";
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT english_word " + 
					"FROM word " + 
					"WHERE korean_word = ?");
			pstmt.setString(1, quiz);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				answer = rset.getString(1);
			}
			
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}
		return answer;
	}

	public static WordGameDTO selectWordGame(String name, int score)throws SQLException  {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		WordGameDTO result = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT user_name, score, date " + 
					"FROM wordgame " + 
					"WHERE user_name = ? " + 
					"AND score = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, score);
			rset = pstmt.executeQuery();

			while (rset.next()) {
				result = new WordGameDTO(rset.getString(1), rset.getInt(2), rset.getDate(3));
			}
		} finally {
			DBUtil.close(conn, pstmt, rset);
		}


		return result;
	}


}
