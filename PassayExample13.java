package PassayExamples;

import org.passay.DictionarySubstringRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.dictionary.ArrayWordList;
import org.passay.dictionary.WordListDictionary;

public class PassayExample13 {
	public static void main(String args[]) {
		WordListDictionary wordListDictionary = new WordListDictionary(
		new ArrayWordList(new String[] {"password","username"}));
		
		DictionarySubstringRule dictionaryRule = new DictionarySubstringRule(wordListDictionary);
		PasswordValidator validator =  new PasswordValidator(dictionaryRule);
		PasswordData password = new PasswordData("password@123");
		RuleResult result = validator.validate(password);
		
		if(result.isValid()) {
			System.out.println("Password Validated");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
	}
}
