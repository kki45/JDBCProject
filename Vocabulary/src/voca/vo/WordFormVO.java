package voca.vo;

public class WordFormVO {

	   private int wordId;
	   private String englishWord;
	   private String formName;
	   private String koreanWord;

	   public WordFormVO() {

	   }

	   public WordFormVO(int wordId, String englishWord, String koreanWord, String formName) {
	      super();
	      this.wordId = wordId;
	      this.englishWord = englishWord;
	      this.koreanWord = koreanWord;
	      this.formName = formName;
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