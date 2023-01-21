import java.util.Random;

public class DaShit {
	
	public static boolean useAlphabet;
	public static boolean useNumbers;
	public static boolean useGoofyCharacters;
	
	public static String alphabet = "abcdefghijklmnopqrstuvwxyz";
	public static String numbers = "123456789";
	public static String goofyCharacters = "!\"#¤%&/()=?";
	
	private static Random r = new Random();
	
	public static String GeneratePassword(int length) {
		
		String password = "";
		
		for(int i = 0; i < length; i++) {
			password = password + GenerateRandomCharacter();
		}
		
		return password;
	}
	
	public static char GenerateRandomCharacter(){ 
		
		String charactersToUse = "";
		
		if (useAlphabet)
			charactersToUse += alphabet;
		if (useNumbers)
			charactersToUse += numbers;
		if (useGoofyCharacters)
			charactersToUse += goofyCharacters;
		
		if (!useAlphabet && !useNumbers && !useGoofyCharacters)
			return ' '; 
		
		return charactersToUse.charAt(r.nextInt(0, charactersToUse.length()));
	}
}
