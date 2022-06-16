package voca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import voca.dbutil.DBUtil;
import voca.dto.MywordDTO;
import voca.dto.WordForm;
import voca.dto.WordMyword;

public class MywordDAO {
	
	// word테이블과 form테이블 조인
		public static ArrayList<WordMyword> join2Voca() throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			ArrayList<WordMyword> list1 = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("select m.my_number, w.english_word, f.form_name, w.korean_word " + 
						" from myword m, word w, form f" + 
						" where m.word_id = w.word_id and w.form_id = f.form_id" + 
						" order by m.my_number");
				
				rset = pstmt.executeQuery();

				list1 = new ArrayList<WordMyword>();
				while (rset.next()) {
					list1.add(new WordMyword(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4)));
				}
			}
			finally {
				DBUtil.close(con, pstmt, rset);
			}
			return list1;
		}
		
		// 즐겨찾기에 영단어 추가
		public static boolean addWord(MywordDTO myword) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("insert into myword values(?, ?)");
				pstmt.setInt(1, myword.getMyNumber());
				pstmt.setInt(2, myword.getWordId());
				
				int result = pstmt.executeUpdate();
				
				while (result == 1) {
					return true;
				}
			}
			finally {
				DBUtil.close(con, pstmt);
			}
			return false;
			
		}
		
		//즐겨찾기에 영단어 삭제
		public static boolean deleteWord(int word_id) throws SQLException {
			Connection con = null;
			PreparedStatement pstmt = null;

			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement("delete from myword where word_id = ?");
				pstmt.setInt(1, word_id);
				
				int result = pstmt.executeUpdate();
				
				while (result == 1) {
					return true;
				}
			}
			finally {
				DBUtil.close(con, pstmt);
			}
			return false;
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}
