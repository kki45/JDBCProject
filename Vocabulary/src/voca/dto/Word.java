package voca.dto;

public class Word {

	private int wordId;
	private String englishWord;
	private String koreanWord;
	private int formId;
	
	public Word(int wordId, String englishWord, String koreanWord) {

		this.wordId = wordId;
		this.englishWord = englishWord;
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

	public String getKoreanWord() {
		return koreanWord;
	}

	public void setKoreanWord(String koreanWord) {
		this.koreanWord = koreanWord;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}
	
	@Override
	public String toString() {
		return "Word [wordId=" + wordId + ", englishWord=" + englishWord + ", koreanWord=" + koreanWord + ", formId="
				+ formId + "]";
	}
	
}
