package voca.dto;

public class WordForm {

	private int wordId;
	private String englishWord;
	private String formName;
	private String koreanWord;
	
	public WordForm() {};
	
	public WordForm(int wordId, String englishWord, String formName, String koreanWord) {
		super();
		this.wordId = wordId;
		this.englishWord = englishWord;
		this.formName = formName;
		this.koreanWord = koreanWord;
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
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
		return "WordForm [wordId=" + wordId + ", englishWord=" + englishWord + ", formName=" + formName
				+ ", koreanWord=" + koreanWord + "]";
	}
	
	
	
	
}
