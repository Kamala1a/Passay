package PassayExamples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.LengthRule;
import org.passay.MessageResolver;
import org.passay.PasswordData;
import org.passay.PasswordValidator;
import org.passay.PropertiesMessageResolver;
import org.passay.Rule;
import org.passay.RuleResult;
import org.passay.WhitespaceRule;

public class PassayExample2 {
	public static void main(String args[]) throws FileNotFoundException, IOException {
		List<Rule> rules = new ArrayList<>();
		rules.add(new LengthRule(8,16));
		rules.add(new WhitespaceRule());
		rules.add(new CharacterRule(EnglishCharacterData.UpperCase, 2));
		rules.add(new CharacterRule(EnglishCharacterData.LowerCase, 1));
		rules.add(new CharacterRule(EnglishCharacterData.Special, 1));
		rules.add(new CharacterRule(EnglishCharacterData.Digit, 1));
		
		Properties props = new Properties();
		props.load(new FileInputStream("D:/messages.properties"));
		MessageResolver messageResolver = new PropertiesMessageResolver(props);
		
		PasswordValidator validator = new PasswordValidator(messageResolver,rules);
		PasswordData password = new PasswordData("micorsoft@123");
		RuleResult result = validator.validate(password);
		
		if(result.isValid()) {
			System.out.println("Password validated.");
	    } else {
	        System.out.println("Invalid Password: " + validator.getMessages(result));            
	    }
	}
}
