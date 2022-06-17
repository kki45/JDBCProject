package voca.view;

import java.util.ArrayList;

import voca.dto.Word;
import voca.dto.WordFormVO;

public class RunningEndView {

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

	public static void searchVoca(WordFormVO searchVoca) {
		System.out.println("[" + searchVoca.getWordId() + " " + searchVoca.getEnglishWord() + " " + "("
				+ searchVoca.getFormName() + ") " + searchVoca.getKoreanWord() + "]");
	}
	
	
	
}
