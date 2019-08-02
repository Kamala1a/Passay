package PassayExamples;

import java.util.ArrayList;
import java.util.List;

import org.passay.AllowedCharacterRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;

public class PassayExample5 {
	public static void main(String args[]) {
		Rule rule1 = new AllowedCharacterRule(new char[] {'a','b','c','`'});
		Rule rule2 = new LengthRule(8,16);
		
		List<Rule> rules = new ArrayList<>();
		rules.add(rule1);
		rules.add(rule2);
		
		PasswordValidator validator = new PasswordValidator(rules);
		PasswordData password = new PasswordData("abcabcabc`");
		RuleResult result = validator.validate(password);
		
		if(result.isValid()) {
			System.out.println("Password Validated");
		} else {
			System.out.println("Invalid Password: "+validator.getMessages(result));
		}
	}
}
