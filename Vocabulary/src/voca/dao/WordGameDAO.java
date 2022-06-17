package voca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import voca.dbutil.DBUtil;
import voca.dto.WordGameDTO;

public class WordGameDAO {
	static int sameCheck = -1;

	// 정답 확인 메소드
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

	// 영어 정답 가져오기
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

	// WordGame DB 추가
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

	// WordGame DB에서 user_name과 score로 정보 가져오기
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
