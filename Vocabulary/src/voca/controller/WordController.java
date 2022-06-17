package voca.controller;

import voca.dto.WordFormVO;
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
			if(e.toString().equals("java.lang.NullPointerException")) {
				System.out.println("검색 결과가 존재 하지 않습니다.");
			}
		}
	}
	
	// 영어단어 추가
	
	public void addVoca(WordFormVO wordFormVO) {
		try {
			boolean addVoca = service.addVoca(wordFormVO);
			if(addVoca == true) {
				System.out.println("단어가 추가 되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 영어단어 수정
	
	public void updateVoca(WordFormVO wordFormVo) {
		
		try {
			boolean updateVoca = service.updateVoca(wordFormVo);
			if(updateVoca == true) {
				System.out.println("단어가 수정 되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	// 영어단어 삭제 
	
	public void deleteVoca(WordFormVO wordFormVo) {
		
		try {
			boolean deleteVoca = service.deleteVoca(wordFormVo);
			if(deleteVoca == true) {
				System.out.println("단어가 삭제 되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	

}
