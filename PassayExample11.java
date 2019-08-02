package PassayExamples;

import org.passay.HistoryRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.RuleResult;
import org.passay.SourceRule;

public class PassayExample11 {
	public static void main(String args[]) {
		SourceRule sourceRule = new SourceRule();
		HistoryRule historyRule = new HistoryRule();
		
		PasswordValidator validator = new PasswordValidator(sourceRule, historyRule);
		PasswordData password = new PasswordData("welcrome@123");
		
		password.setPasswordReferences(
				new PasswordData.SourceReference("source","password"),
				new PasswordData.HistoricalReference("password@123"),
				new PasswordData.HistoricalReference("welcome@123")
		);
		
		RuleResult result = validator.validate(password);
		
		if(result.isValid()) {
			System.out.println("Password Validated.");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
	}
}
