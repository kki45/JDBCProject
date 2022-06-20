package voca.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	private static Validation instance = new Validation();
	
	public Validation() {}

	
	public static Validation getInstance() {
		return instance;
	}
	
	
	
	public Matcher validationCheck(String word) {
		Pattern pattern = Pattern.compile("^[0-9]*$");
		Matcher matcher = pattern.matcher(word);
		return matcher;
	}
}
