package voca.dto;

public class Form {

	private int formId;
	private String formName;

	public Form() {

	}

	public Form(int formId, String formName) {
		super();
		this.formId = formId;
		this.formName = formName;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public String getFormName() {
		return formName;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

}
