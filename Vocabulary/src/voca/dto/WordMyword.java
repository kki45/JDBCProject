package voca.dto;

public class WordMyword {
	
	private int myNumber;
	private String englishWord;
	private String formName;
	private String koreanWord;
	
	public WordMyword() {}

	public WordMyword(int myNumber, String englishWord, String formName, String koreanWord) {
		super();
		this.myNumber = myNumber;
		this.englishWord = englishWord;
		this.formName = formName;
		this.koreanWord = koreanWord;
	}

	public int getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
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
		return "[" + myNumber + " " + englishWord + "(" + formName +")"
				+ " " + koreanWord + "]";
	};
	
	
	
}
