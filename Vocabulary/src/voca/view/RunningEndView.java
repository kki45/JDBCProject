package voca.view;

import java.util.ArrayList;

import voca.dto.Word;
import voca.dto.WordGameDTO;
import voca.vo.WordFormVO;

public class RunningEndView {

  // 모든 word 가져오기
	public static void getAllVoca(ArrayList<WordFormVO> arrayList) {
		int length = arrayList.size();
		if (length != 0) {
			for (int i = 0; i < length; i++) {
				WordFormVO getData = arrayList.get(i);
				System.out.println("[" + getData.getWordId() + " " + getData.getEnglishWord() + " " + "("
						+ getData.getFormName() + ") " + getData.getKoreanWord() + "]");
			}
		}
	}

  // word 검색하기
	public static void searchVoca(WordFormVO searchVoca) {
		System.out.println("[" + searchVoca.getWordId() + " " + searchVoca.getEnglishWord() + " " + "("
				+ searchVoca.getFormName() + ") " + searchVoca.getKoreanWord() + "]");
	}

  // WordGame 시작하기
	public static ArrayList<String> getWordGameList(ArrayList<Word> gameList) {
		ArrayList<String> korean = new ArrayList<String>();
		for (Word word : gameList) {
			korean.add(word.getKoreanWord());
		}
		return korean;
	}

  // WordGame 점수 불러오기
	public static void searchWordGame(WordGameDTO searchWordGame) {
		WordGameDTO getData = searchWordGame;

		System.out.println("총점 50점");
		System.out.println( getData.getUserName() + "님의 점수는 " + getData.getScore() + "점입니다.");
	}

}
