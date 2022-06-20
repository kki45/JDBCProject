package voca.view;

import voca.controller.WordController;
import java.util.ArrayList;
import java.util.Scanner;

import voca.controller.WordGameController;


public class RunningStartView {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("unused")
		WordController wordController = WordController.getInstance();
		WordGameController wgController = WordGameController.getInstance();
		MywordController mycontroller = MywordController.getInstance();
		
		// m.y. //
		System.out.println("모든 단어 검색 시작");
		wordController.allVoca();
		System.out.println("=============================");
		System.out.println();

// 		System.out.println("한글 단어 검색 후 영어 출력 시작");
//		wordController.searchVoca("양보하다");
// 		System.out.println("=============================");
//		System.out.println();
//
//		System.out.println("영어 단어 추가 시작");
//		//		wordController.addVoca(new WordFormVO("jejunum", "빈창자", 1));
//		//		wordController.searchVoca("빈창자");
//		System.out.println("=============================");
//		System.out.println();
//
//
//		//		wordController.updateVoca(new WordFormVO(62 , "jejunum", "빈창자" , 1));
//		//		wordController.updateVoca(new WordFormVO(64, "cancer", "암", 1));
////		wordController.searchVoca("암");
//		System.out.println("=============================");
//		System.out.println();
//
//		//		wordController.deleteVoca(new WordFormVO(64));
//		//		wordController.searchVoca("암");
//		System.out.println();
//		System.out.println("=============================");
		// m.y. //
		
		// y.h. //
//		System.out.println("\n========단어 맞추기 게임========");
//		System.out.print("사용자명을 입력하세요 : ");
//		Scanner scan = new Scanner(System.in);
//
//		String name = scan.nextLine();
//		System.out.println(name);
//		System.out.println();
//
//		String[] qna = new String[2];
//		int score = 0;
//		ArrayList<String> korean = null;
//
//		korean = WordGameController.wordGameList();
//
//		int i=0;
//		while(i < korean.size()) {
//			String quiz = korean.get(i);
//			System.out.println((i+1) + "번째 답을 입력하세요 : " + quiz);		
//			System.out.print("입력 : ");
//			String userAnswer = scan.nextLine();
//			String answer = wgController.getEnglishAnswer(quiz);
//			System.out.println("정답: " + answer + "\n");
//			qna = new String[]{quiz, userAnswer};
//			score += wgController.calcScore(qna);
//			i++;
//		}
//		scan.close();
//		int result = score*5;
//		wgController.insertWordGame(name, result);
//		wgController.showScore(name, result);
//		System.out.println("=============================");
		// y.h. //


		// y.j. //
		// myword 즐겨찾기 모두 출력
		System.out.println("조인된 테이블2 출력");
//		mycontroller.join2Voca();
		
		// 즐겨찾기에 단어추가하기
		// myword에 단어 추가하는데 먼저  myword에 추가된 단어이면 북마크 불가능
		// bookmark(new Word());
		System.out.println("====영어단어 즐겨찾기하기====");
//		mycontroller.bookmark(11);
//		mycontroller.join2Voca();
		
		// 즐겨찾기에서 단어삭제하기
		System.out.println("====영어단어 삭제하기====");
//		mycontroller.deleteBmark(12);
//		mycontroller.join2Voca();
		
//		System.out.println("===== 영어단어mynumber로 1개만 출력하기=====");
//		mycontroller.oneWord(1);
		
		// 몇개씩 출력하기
		System.out.println("==== 출력하고싶은 갯수만큼 출력하기 ====");
		mycontroller.join3Voca(5);
		// y. h. //
	}
		
}


