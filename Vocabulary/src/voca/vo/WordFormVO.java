package voca.vo;

public class WordFormVO {

	private int wordId;
	private String englishWord;
	private String formName;
	private String koreanWord;
	private int formid;

	public WordFormVO() {
	}

	public WordFormVO(String englishWord, String koreanWord, int formid) {
		this.englishWord = englishWord;
		this.koreanWord = koreanWord;
		this.formid = formid;
	}

	public WordFormVO(int wordId, String englishWord, String koreanWord, String formName) {
		this.wordId = wordId;
		this.englishWord = englishWord;
		this.koreanWord = koreanWord;
		this.formName = formName;
	}

	public WordFormVO(int wordId, String englishWord, String koreanWord, int formid) {
		this.wordId = wordId;
		this.englishWord = englishWord;
		this.koreanWord = koreanWord;
		this.formid = formid;

	}

	public WordFormVO(int wordId) {
		this.wordId = wordId;
	}

	public int getFormid() {
		return formid;
	}

	public int getWordId() {
		return wordId;
	}

	public String getEnglishWord() {
		return englishWord;
	}

	public String getKoreanWord() {
		return koreanWord;
	}

	public String getFormName() {
		return formName;
	}

}
