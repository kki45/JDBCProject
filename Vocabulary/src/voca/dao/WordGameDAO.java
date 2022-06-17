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
import voca.vo.WordFormVO;

public class WordGameDAO {
	static int sameCheck = -1;
	
	
	public static ArrayList<Word> wordgameList() throws SQLException{
		Connection conn = null;
		Statement stmt = null;
		ArrayList<WordFormVO> allList = null;
		Random rand = new Random();
		
		ArrayList<Word> gameList = null;
		int randValue = -1;
		gameList = new ArrayList<Word>();
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			allList = WordDAO.getAllVoca();
//			int breakCount = 0;
//			for(Word word : allList) {
//				if (breakCount ==10) {
//					break;
//				}
//				randValue = rand.nextInt(allList.size());
//				while(sameCheck == randValue) {
//					randValue = rand.nextInt(allList.size());
//				}
//				gameList.add(new Word(allList.get(randValue).getWordId(),
//						 allList.get(randValue).getEnglishWord(),
//						 allList.get(randValue).getKoreanWord()));
//				
//				
//				breakCount++;
//				sameCheck = randValue;
//			}
			
//			Random rand = new Random();
//			int randValue = -1;
			ArrayList<Integer> quizNumber = null;
			quizNumber = new ArrayList<Integer>(10);
			while(true) {
				randValue = rand.nextInt(10);
				boolean ans = quizNumber.contains(randValue);
				if(ans == false) {
					quizNumber.add(randValue);
				}
				if(quizNumber.size() == 10) {
					break;
				}
			}

				randValue = rand.nextInt(allList.size());
				while(sameCheck == randValue) {
					randValue = rand.nextInt(allList.size());
				}
				gameList.add(new Word(allList.get(randValue).getWordId(),
						 allList.get(randValue).getEnglishWord(),
						 allList.get(randValue).getKoreanWord()));
				
				
				sameCheck = randValue;
		} finally {
			DBUtil.close(conn, stmt);
		}
		
		return gameList;
	}	// end wordgameList()
	
	
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
	
	
}
