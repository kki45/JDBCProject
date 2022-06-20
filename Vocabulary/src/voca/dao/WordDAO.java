package voca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import voca.dbutil.DBUtil;
import voca.dto.Word;
import voca.dto.WordForm;
import voca.vo.WordFormVO;


public class WordDAO {
	
	// word테이블과 form테이블 조인
	public static ArrayList<WordForm> joinVoca() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<WordForm> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select w.word_id, w.english_word, f.form_name, w.korean_word " + 
					" from word w, form f" + 
					" where w.form_id = f.form_id" + 
					" order by w.word_id");
			
			rset = pstmt.executeQuery();


			list = new ArrayList<WordForm>();
			while (rset.next()) {
				list.add(new WordForm(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		}
		finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}

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
			pstmt = con.prepareStatement("select @rownum:=@rownum+1 as row_num , w.english_word, w.korean_word , f.form_name " + 
					" from word w " + 
					" left outer join form f on w.form_id = f.form_id " + 
					" WHERE (@rownum:=0)=0 " + 
					" order by english_word asc  ");
			rset = pstmt.executeQuery();

			while (rset.next()) {
				list.add(new WordFormVO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
			}
		}

		finally {
			DBUtil.close(con, pstmt, rset);
		}
		return list;
	}
	
	// word 테이블 검색
	public static Word getWord(int wordId) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Word> list = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select * from word where wordId= ?");
			
			rset = pstmt.executeQuery();

			list = new ArrayList<Word>();
			while (rset.next()) {
				list.add(new Word(rset.getInt(1), rset.getString(2), rset.getString(3)));
			}
		}
		finally {
			DBUtil.close(con, pstmt, rset);
		}
		return null;
		
	}

	// word 테이블 join 후, 출력
	public static WordFormVO searchVoca(String koreanWord) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		WordFormVO result = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("select w.word_id, w.english_word  , w.korean_word , f.form_name"
					+ " from word w " + " left outer join form f " + "	on w.form_id = f.form_id "
					+ "	where w.korean_word like ? ");
			pstmt.setString(1,  "%" + koreanWord + "%");
			rset = pstmt.executeQuery();
			while (rset.next()) {
				result = new WordFormVO(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		} finally {
			DBUtil.close(con, pstmt, rset);
		}
		return result;
	}

	// word 테이블 추가
	public static boolean addVoca(WordFormVO word) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement("insert into word(english_word , korean_word , form_id) values(?, ?, ?)");
			pstmt.setString(1, word.getEnglishWord());
			pstmt.setString(2, word.getKoreanWord());
			pstmt.setInt(3, word.getFormid());

			int result = pstmt.executeUpdate();

			if (result == 1) {
				return true;
			}
		} finally {
			DBUtil.close(con, pstmt);
		}
		return false;
	}

	// word 테이블 수정
	public static boolean updateVoca(WordFormVO wordFormVo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(
					"update word set english_word = ? , korean_word = ? , form_id = ? where word_id = ? ");

			pstmt.setString(1, wordFormVo.getEnglishWord());
			pstmt.setString(2, wordFormVo.getKoreanWord());
			pstmt.setInt(3, wordFormVo.getFormid());
			pstmt.setInt(4, wordFormVo.getWordId());

			int r = pstmt.executeUpdate();
			if (r != 0) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}

	// word 테이블 삭제
	public static boolean deleteVoca(WordFormVO wordFormVo) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(
					"delete from word where word_id = ?; ");

			pstmt.setInt(1, wordFormVo.getWordId());
			int r = pstmt.executeUpdate();
			if (r != 0) {
				return true;
			}
		} finally {
			DBUtil.close(conn, pstmt);
		}
		return false;
	}

	
}
