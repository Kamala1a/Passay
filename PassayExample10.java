package PassayExamples;

import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.UsernameRule;

public class PassayExample10 {
	public static void main(String args[]) {
		Rule rule = new UsernameRule();
		
		PasswordValidator validator = new PasswordValidator(rule);
		PasswordData password = new PasswordData("microsoft");
		password.setUsername("Kamal");
		RuleResult result = validator.validate(password);
		if(result.isValid()) {
			System.out.println("Password Validated");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
	}
}
