package voca.view;

import java.util.ArrayList;

import voca.dto.MywordDTO;
import voca.dto.Word;
import voca.dto.WordForm;
import voca.dto.WordMyword;

public class RunningEndView {
	
	public static void getAllVoca(ArrayList<Word> allVoca) {

		System.out.println(allVoca);

	}
	
	public static void joinVoca(ArrayList<WordForm> wordform) {
		
		System.out.println(wordform);
	}
	
	// 즐겨찾기 전체출력
	public static void join2Voca(ArrayList<WordMyword> join2Voca) {
		int length = join2Voca.size();
		if( length != 0) {
			for(int index = 0; index < length; index ++) {
				System.out.println(join2Voca.get(index));
			}
		}
		
	}
	
	//예외 상황 출력
		public static void showError(String message){
			System.out.println(message);		
		}
	
}
