package voca.view;

import voca.controller.MywordController;
import voca.controller.WordController;
import voca.dto.MywordDTO;

public class RunningStartView {
	public static void main(String[] args) {
		WordController controller = WordController.getInstance();
		MywordController mycontroller = MywordController.getInstance();

		System.out.println("모든 단어 검색");
//		controller.allVoca();
		
		System.out.println("조인된 테이블1 출력");
//		controller.joinVoca();
		
		// myword 즐겨찾기 모두 출력
		System.out.println("조인된 테이블2 출력");
//		mycontroller.join2Voca();
		
		// 즐겨찾기에 단어추가하기
		// myword에 단어 추가하는데 먼저  myword에 추가된 단어이면 북마크 불가능
		// bookmark(new Word());
		System.out.println("====영어단어 즐겨찾기하기====");
		// myword - word
//		mycontroller.bookmark(3);
//		mycontroller.join2Voca();
		
		// 즐겨찾기에서 단어삭제하기
		System.out.println("====영어단어 삭제하기====");
//		mycontroller.deleteBmark(6);
//		mycontroller.join2Voca();

		

	}
}
