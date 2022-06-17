package voca.controller;


import voca.dto.Form;
import voca.dto.Word;
import voca.service.WordService;
import voca.view.RunningEndView;


public class WordController {
	private static WordController instance = new WordController();
	private WordService service = WordService.getInstance();

	private WordController() {}

	public static WordController getInstance() {
		return instance;
	}

	//모든 단어 출력
	public void allVoca() {

		try {
			RunningEndView.getAllVoca(service.getAllVoca());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 힌 단어 출력

	public void searchVoca(String koreanWord) {
		try {
			RunningEndView.searchVoca(service.searchVoca(koreanWord));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 영어단어 추가

	public void addVoca(Word word , Form form) {
		try {
			//	         service.addVoca(word, form);
			//	         RunningEndView.searchVoca(service.searchVoca(koreanWord));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
