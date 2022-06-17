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

//		System.out.println("모든 단어 검색");
//		wordController.allVoca();



//				for(int j=0; j<quizNumber.size(); j++) {
//					randValue = rand.nextInt(10);
//					ans = quizNumber.contains(randValue);
//					if(ans == false) {
//						quizNumber.add(randValue);
//					}
//				}
//		Random rand = new Random();
//		int randValue = -1;
//		ArrayList<Integer> quizNumber = null;
//		quizNumber = new ArrayList<Integer>(10);
//		while(true) {
//			randValue = rand.nextInt(10);
//			boolean ans = quizNumber.contains(randValue);
//			if(ans == false) {
//				quizNumber.add(randValue);
//			}
//			if(quizNumber.size() == 10) {
//				break;
//			}
//		}
//		for(int i=0; i<10; i++) {
//		if(ans == true) {
//			do{
//				if(ans == false) {
//					break;
//				}
//				randValue = rand.nextInt(10);
//				System.out.println(randValue);
//				ans = quizNumber.contains(randValue);
//			}while (ans == false);
//			System.out.println("---"+randValue);
//			quizNumber.add(randValue);
//		}else {
//			System.out.println("==="+randValue);
//			quizNumber.add(randValue);
//		}
//	}

		
		
		System.out.println("\n========단어 맞추기 게임========");
		System.out.print("사용자명을 입력하세요 : ");
		Scanner scan = new Scanner(System.in);

		String name = scan.next();
		System.out.println(name);
		System.out.println();

		int i=0;
		String[] qna = new String[2];
		int score = 0;
		int quizCount = 10;

		while(i < quizCount) {
			String korean = WordGameController.wordGameList();
			System.out.println((i+1) + "번째 답을 입력하세요 : " + korean);		
			System.out.print("입력 : ");
			String answer = scan.next();
			System.out.println("답: " + answer + "\n");
			qna = new String[]{korean, answer};
			score += wgController.calcScore(qna);
			if(i==quizCount) {
				break;
			}
			i++;
		}
		scan.close();
		wgController.insertWordGame(name, score*5);

		
		
		
		
		
		
		
		
		
		
	}
}


