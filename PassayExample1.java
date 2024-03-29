package PassayExamples;

import java.util.ArrayList;
import java.util.List;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

public class PassayExample1 {
	public static void main(String args[]) {
		List<Rule> rules = new ArrayList<>();
		//Rule 1: Password length should be in between 8 to 16 characters
		rules.add(new LengthRule(8,16));
		//Rule 2: No Whitespace allowed
		rules.add(new WhitespaceRule());
		//Rule 3.a: At least one Upper-case character
		rules.add(new CharacterRule(EnglishCharacterData.UpperCase,2));
		//Rule 3.a: At least one Lower-case character
		rules.add(new CharacterRule(EnglishCharacterData.LowerCase,1));
		//Rule 3.a: At least one Special-character character
		rules.add(new CharacterRule(EnglishCharacterData.Special,2));
		
		PasswordValidator validator = new PasswordValidator(rules);
		PasswordData password = new PasswordData("Microsoft@123");
		RuleResult result = validator.validate(password);
		
		if(result.isValid()) {
			System.out.println("Password validated");
		} else {
			System.out.println("Invalid Password"+validator.getMessages(result));
		}
	}
}
