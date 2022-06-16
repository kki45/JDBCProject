package voca.dto;

public class Word {

	private int wordId;
	private String englishWord;
	private String koreanWord;
	
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

}
