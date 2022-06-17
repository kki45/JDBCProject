package voca.dto;

public class MywordDTO {
	
	private int myNumber;
	private int wordId;
	
	public MywordDTO() {};
	
	public MywordDTO(int myNumber, int wordId) {
		super();
		this.myNumber = myNumber;
		this.wordId = wordId;
	}

	public int getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(int myNumber) {
		this.myNumber = myNumber;
	}

	public int getWordId() {
		return wordId;
	}

	public void setWordId(int wordId) {
		this.wordId = wordId;
	}

	@Override
	public String toString() {
		return "Myword [myNumber=" + myNumber + ", wordId=" + wordId + "]";
	}
	

}



















