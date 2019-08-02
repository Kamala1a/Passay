package PassayExamples;

import org.passay.AllowedRegexRule;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;

public class PassayExample6 {
	public static void main(String args[]) {
		Rule rule1 = new AllowedRegexRule("^[A-Za-z]+$");
		
		Rule rule2 = new LengthRule(8,16);
		
		PasswordValidator validator = new PasswordValidator(rule1, rule2);
		PasswordData passwordData = new PasswordData("Microsoft@123");
		RuleResult result = validator.validate(passwordData);
		
		if(result.isValid()) {
			System.out.println("Password Validated");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
	}
}
