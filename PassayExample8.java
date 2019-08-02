package PassayExamples;

import org.passay.AllowedCharacterRule;
/*
LengthComplexityRule helps in defining the applicable rule on a password based on its length. Consider the following policy.

If length of password is in between 1 to 5 characters, only lower case alphabets are allowed.

If length of password is in between 6 to 8 characters, then only a, b and c are allowed.
 */
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthComplexityRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;

public class PassayExample8 {
	public static void main(String args[]) {
		LengthComplexityRule lengthComplexityRule = new LengthComplexityRule();
		lengthComplexityRule.addRules("[1,5]", new CharacterRule(EnglishCharacterData.LowerCase, 5));
		lengthComplexityRule.addRules("[6,8]", new AllowedCharacterRule(new char[] {'a','b','c'}));
		
		PasswordValidator validator = new PasswordValidator(lengthComplexityRule);
		PasswordData password = new PasswordData("abcAa");
		RuleResult result = validator.validate(password);
		
		if(result.isValid()) {
			System.out.println("Password validated");
		} else {
			System.out.println("Invalidated: " + validator.getMessages(result));
		}
	}
}
