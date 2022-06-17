package voca.controller;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import voca.vo.WordFormVO;
import voca.exception.ValidationException;

import java.sql.SQLException;

import voca.dto.WordForm;
import voca.service.WordService;
import voca.validation.Validation;
import voca.view.RunningEndView;

public class WordController {
	private static WordController instance = new WordController();
	private WordService service = WordService.getInstance();

	private Validation validation = Validation.getInstance();
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

	// 모든 단어 출력

	public void allVoca() {

		try {
			RunningEndView.getAllVoca(service.getAllVoca());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 힌 단어 출력

	public boolean searchVoca(String koreanWord) throws SQLException, ValidationException  {

		
		try {
			if(validation.validationCheck(koreanWord).find() == true) {
				ValidationException exception = new ValidationException("숫자는 입력 하실 수 없습니다.");
			}
//			
			RunningEndView.searchVoca(service.searchVoca(koreanWord));
			return true;
		} catch (NullPointerException n) {
			System.out.println("검색 결과가 존재 하지 않습니다.");
		}
		return false;

	}

	// 영어단어 추가

	public void addVoca(WordFormVO wordFormVO) {
		try {
			if(validation.validationCheck(wordFormVO.getKoreanWord()).find() == true) {
				ValidationException exception = new ValidationException("숫자는 입력 하실 수 없습니다.");
			}
			
			boolean searchVoca = searchVoca(wordFormVO.getKoreanWord());
			if(searchVoca == true) {
				System.out.println("단어가 중복 됩니다.");
			}else {
				boolean addVoca = service.addVoca(wordFormVO);
				if (addVoca == true) {
					System.out.println("단어가 추가 되었습니다.");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 영어단어 수정

	public void updateVoca(WordFormVO wordFormVo) {

		try {
			if(validation.validationCheck(wordFormVo.getKoreanWord()).find() == true) {
				ValidationException exception = new ValidationException("숫자는 입력 하실 수 없습니다.");
			}
			
			boolean updateVoca = service.updateVoca(wordFormVo);
			if (updateVoca == true) {
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
			if (deleteVoca == true) {
				System.out.println("단어가 삭제 되었습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
