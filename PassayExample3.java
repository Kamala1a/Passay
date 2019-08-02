package PassayExamples;

import java.util.ArrayList;
import java.util.List;

import org.passay.CharacterCharacteristicsRule;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

public class PassayExample3 {
	public static void main(String args[]) {
		Rule rule1 = new LengthRule(8,16);
		
		Rule rule2 = new WhitespaceRule();
		
		CharacterCharacteristicsRule rule3 = new CharacterCharacteristicsRule();
		rule3.setNumberOfCharacteristics(4);
		
		rule3.getRules().add(new CharacterRule(EnglishCharacterData.UpperCase,1));
		rule3.getRules().add(new CharacterRule(EnglishCharacterData.LowerCase,1));
		rule3.getRules().add(new CharacterRule(EnglishCharacterData.Special,1));
		rule3.getRules().add(new CharacterRule(EnglishCharacterData.Digit,1));
		
		List<Rule> rule = new ArrayList<>();
		rule.add(rule1);
		rule.add(rule2);
		rule.add(rule3);
		
		PasswordValidator validator = new PasswordValidator(rule);
		PasswordData password = new PasswordData("microsoft@123");
		RuleResult result = validator.validate(password);
		
		if(result.isValid()) {
			System.out.println("Password Validated");
		} else {
			System.out.println("Invalid Password: " + validator.getMessages(result));
		}
		
	}
}
