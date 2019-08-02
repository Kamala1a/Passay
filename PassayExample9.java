package PassayExamples;

import org.passay.IllegalCharacterRule;
import org.passay.NumberRangeRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

public class PassayExample9 {
	public static void main(String args[]) {
		IllegalCharacterRule illegalCharacterRule = new IllegalCharacterRule(new char[] {'&','<','>'});
		NumberRangeRule numberRangeRule = new NumberRangeRule(1, 5);
		WhitespaceRule whitespaceRule = new WhitespaceRule();
		
		PasswordValidator validator = new PasswordValidator(illegalCharacterRule, numberRangeRule, whitespaceRule);
		PasswordData password = new PasswordData("abcd6ef6");
		RuleResult result = validator.validate(password);
		
		if(result.isValid()) {
			System.out.println("Password Validated");
		} else {
			System.out.println("Invalid Password: "+validator.getMessages(result));
		}
	}
}
