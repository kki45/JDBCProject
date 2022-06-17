package voca.view;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import voca.controller.WordController;
import voca.controller.WordGameController;

public class RunningStartView {
	public static void main(String[] args) {
		WordController wordController = WordController.getInstance();
		WordGameController wgController = WordGameController.getInstance();

		//	System.out.println("모든 단어 검색");
		//	wordController.allVoca();


		System.out.println("\n========단어 맞추기 게임========");
		System.out.print("사용자명을 입력하세요 : ");
		Scanner scan = new Scanner(System.in);

		String name = scan.next();
		System.out.println(name);
		System.out.println();

		String[] qna = new String[2];
		int score = 0;
		ArrayList<String> korean = null;

		korean = WordGameController.wordGameList();

		int i=0;
		while(i < korean.size()) {
			String quiz = korean.get(i);
			System.out.println((i+1) + "번째 답을 입력하세요 : " + quiz);		
			System.out.print("입력 : ");
			String answer = scan.next();
			System.out.println("답: " + answer + "\n");
			qna = new String[]{quiz, answer};
			score += wgController.calcScore(qna);
			i++;
		}
		scan.close();
		int result = score*5;
		wgController.insertWordGame(name, result);
		wgController.showScore(name, result);


	}
}


