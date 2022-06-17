package voca.view;

import voca.controller.WordController;
import voca.dto.WordFormVO;

public class RunningStartView {
	public static void main(String[] args) {
		WordController controller = WordController.getInstance();

		System.out.println("모든 단어 검색");
		controller.allVoca();
		System.out.println("=============================");
		System.out.println();

		System.out.println("한글 단어 검색 후 영어 출력 ");
		controller.searchVoca("양보하다");
		System.out.println("=============================");
		System.out.println();

		System.out.println("영어 단어 추가");
		controller.addVoca(new WordFormVO("jejunum", "빈창자", 1));
		controller.searchVoca("빈창자");
		System.out.println("=============================");
		System.out.println();

//		controller.updateVoca(new WordFormVO(62 , "jejunum", "빈창자" , 1));
		controller.updateVoca(new WordFormVO(64, "cancer", "암", 1));
		controller.searchVoca("암");
		System.out.println("=============================");
		System.out.println();

		controller.deleteVoca(new WordFormVO(64));
		controller.searchVoca("암");
		System.out.println();
		System.out.println("=============================");

	}
}
