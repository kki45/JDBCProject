package voca.dto;

public class mywordIndexDTO {
	private String englishWord;
	private String formName;
	private String koreanWord;
	
	public mywordIndexDTO() {}

	public mywordIndexDTO(String englishWord, String formName, String koreanWord) {
		super();
		this.englishWord = englishWord;
		this.formName = formName;
		this.koreanWord = koreanWord;
	}

	public String getEnglishWord() {
		return englishWord;
	}

	public void setEnglishWord(String englishWord) {
		this.englishWord = englishWord;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public String getKoreanWord() {
		return koreanWord;
	}

	public void setKoreanWord(String koreanWord) {
		this.koreanWord = koreanWord;
	}

	@Override
	public String toString() {
		return "[" +  englishWord + "(" + formName +")"
				+ " " + koreanWord + "]";
	};
	
	
}
