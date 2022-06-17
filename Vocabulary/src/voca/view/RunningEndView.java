package voca.view;

import java.util.ArrayList;

import voca.dto.Word;
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
		//	      [ 1 apple (명) 사과 ]
		System.out.println("[" + getData.getWordId() + " " + getData.getEnglishWord() + " " + "("
				+ getData.getFormName() + ") " + getData.getKoreanWord() + "]");
	}


	public static String getWordGameList(ArrayList<Word> gameList) {
		String korean = "";
		for (Word word : gameList) {
			return korean = word.getKoreanWord() ;
		}
		return korean;
	}

}
