package voca.view;

import java.util.ArrayList;

import voca.dto.Word;
import voca.dto.WordGameDTO;
import voca.vo.WordFormVO;

public class RunningEndView {

	public static void getAllVoca(ArrayList<WordFormVO> arrayList) {

		int length = arrayList.size();
		if (length != 0) {
			for (int i = 0; i < length; i++) {
				WordFormVO getData = arrayList.get(i);
				//	            [ 1 apple (명) 사과 ]
				System.out.println("[" + getData.getWordId() + " " + getData.getEnglishWord() + " " + "("
						+ getData.getFormName() + ") " + getData.getKoreanWord() + "]");
			}
		}
	}

	public static void searchVoca(WordFormVO searchVoca) {
		WordFormVO getData = searchVoca;
		// [ 1 apple (명) 사과 ]
		System.out.println("[" + getData.getWordId() + " " + getData.getEnglishWord() + " " + "("
				+ getData.getFormName() + ") " + getData.getKoreanWord() + "]");
	}


	public static ArrayList<String> getWordGameList(ArrayList<Word> gameList) {
		ArrayList<String> korean = new ArrayList<String>();
		for (Word word : gameList) {
			korean.add(word.getKoreanWord());
		}
		return korean;
	}

	public static void searchWordGame(WordGameDTO searchWordGame) {
		WordGameDTO getData = searchWordGame;

		System.out.println("총점 50점");
		System.out.println( getData.getUserName() + "님의 점수는 " + getData.getScore() + "점입니다.");
	}

}
