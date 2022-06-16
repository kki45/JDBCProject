package voca.controller;


import java.sql.SQLException;

import voca.dto.WordForm;
import voca.service.WordService;
import voca.view.RunningEndView;


public class WordController {
	private static WordController instance = new WordController();
	private WordService service = WordService.getInstance();

	private WordController() {

	}

	public static WordController getInstance() {
		return instance;
	}
	
	public void joinVoca() {
		try {
			RunningEndView.joinVoca(service.joinVoca());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//
	public void allVoca() {

		try {
			RunningEndView.getAllVoca(service.getAllVoca());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
