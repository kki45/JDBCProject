package voca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import voca.dbutil.DBUtil;
import voca.dto.Word;
import voca.vo.WordFormVO;

public class WordDAO {


	/*
	 * 모든 단어값 알파벳 a부터 검색
	 * 
	 */
	public static ArrayList<WordFormVO> getAllVoca() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<WordFormVO> list = new ArrayList<WordFormVO>();
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select w.word_id, w.english_word  , w.korean_word , f.form_name"
					+ " from word w "
					+ " left outer join form f "
					+ "   on w.form_id = f.form_id "
					+ "   order by english_word asc ");
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new WordFormVO(rset.getInt(1), rset.getString(2), rset.getString(3) , rset.getString(4)));
			}
		}


		finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

	public static WordFormVO searchVoca(String koreanWord) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		WordFormVO result = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select w.word_id, w.english_word  , w.korean_word , f.form_name"
					+ " from word w "
					+ " left outer join form f "
					+ "   on w.form_id = f.form_id "
					+ "   where w.korean_word = ? "
					);
			pstmt.setString(1, koreanWord);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result = new WordFormVO(rset.getInt(1), rset.getString(2), rset.getString(3) , rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return result;
	}




}