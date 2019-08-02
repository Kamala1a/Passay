package PassayExamples;

import org.passay.DictionaryRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.dictionary.ArrayWordList;
import org.passay.dictionary.WordListDictionary;

public class PassayExample12 {
	public static void main(String args[]) {
		WordListDictionary wordListDictionary = new WordListDictionary(
		new ArrayWordList(new String[] {"password","username"}));
		
		DictionaryRule dictionaryRule = new DictionaryRule(wordListDictionary);
		
		PasswordValidator validator = new PasswordValidator(dictionaryRule);
		PasswordData passwordData = new PasswordData("password");
		RuleResult result = validator.validate(passwordData);
		
		if(result.isValid()) {
			System.out.println("Password Validated");
		} else {
			System.out.println("Invalid password: "+validator.getMessages(result));
		}
	}
}
