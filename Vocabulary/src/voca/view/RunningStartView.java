package voca.view;

import voca.controller.WordController;

public class RunningStartView {
	public static void main(String[] args) {
		
		
		WordController controller = WordController.getInstance();
		
		System.out.println("모든 단어 검색");
		controller.allVoca();
		
		
		
	}
}
