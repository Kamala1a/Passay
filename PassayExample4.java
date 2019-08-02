package PassayExamples;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class PassayExample4 {
	public static void main(String args[]) {
		CharacterRule alphabets = new CharacterRule(EnglishCharacterData.Alphabetical);
		CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);
		CharacterRule special = new CharacterRule(EnglishCharacterData.Special);
		CharacterRule upper = new CharacterRule(EnglishCharacterData.UpperCase);
		CharacterRule lower = new CharacterRule(EnglishCharacterData.LowerCase);
		
		PasswordGenerator passwordGenerator = new PasswordGenerator();
		String password = passwordGenerator.generatePassword(5, alphabets,digits,special,upper,lower);
		System.out.println(password);
	}
}
