package voca.view;

import voca.controller.WordController;

public class RunningStartView {
	public static void main(String[] args) {
		
		
		WordController controller = WordController.getInstance();
		
		System.out.println("��� �ܾ� �˻�");
		controller.allVoca();
		
		
		
	}
}
