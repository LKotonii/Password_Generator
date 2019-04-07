package java_classes;

import java.util.ArrayList;
import java.util.HashMap;

public class PasswordGenerator {

	private final static int DIGITALS = 1;
	private final static int UPPERCASE_LETTERS = 2;
	private final static int LOWERCASE_LETTERS = 3;
	private final static int SPECIAL_SYMBOLS = 4;

	private static HashMap<Integer, ArrayList<Integer>> types = new HashMap<>(4);

	// method intialize HashMap object, where the key is
	private static void initializeCharsLists() {

		ArrayList<Integer> digitals = new ArrayList<Integer>(2);
		digitals.add(48);
		digitals.add(57);

		ArrayList<Integer> upperCaseLetters = new ArrayList<Integer>(2);
		upperCaseLetters.add(65);
		upperCaseLetters.add(90);

		ArrayList<Integer> lowerCaseLetters = new ArrayList<Integer>(2);
		lowerCaseLetters.add(97);
		lowerCaseLetters.add(122);

		ArrayList<Integer> specialSymbols = new ArrayList<Integer>(2);
		specialSymbols.add(33);
		specialSymbols.add(43);

		types.put(DIGITALS, digitals);
		types.put(SPECIAL_SYMBOLS, specialSymbols);
		types.put(LOWERCASE_LETTERS, lowerCaseLetters);
		types.put(UPPERCASE_LETTERS, upperCaseLetters);
	}

	/*
	 * method returns char array with generated passsword
	 * 
	 * @param int lowerCase -- how many lowerCase letters should appear in the
	 * pasword
	 * 
	 * @param int upperCase
	 * 
	 * @param int numbers -- how many digits should be in the password
	 * 
	 * @param int specialSymbols
	 * 
	 * 
	 */
	public static char[] generatePasswordCharByChar(int lowerCase, int upperCase, int digitals, int specialSymbols) throws TooWeakPasswordException {

		int length = lowerCase + upperCase + digitals + specialSymbols;
		
		if (length < 6 ) {
			throw new TooWeakPasswordException();
		}
		
		initializeCharsLists();

		char[] generatedPassword = new char[lowerCase + upperCase + digitals + specialSymbols];
		// initialize int for parsing throught generated password
		int index = 0;
		char currentChar = 0;
		int typeOfChars = 0;
		ArrayList<Integer> max_min = null;

		while (index < generatedPassword.length) {
			typeOfChars = Random.getRandomInt(1, 4);
			switch (typeOfChars) {
			case DIGITALS:
				if (digitals >= 1) {
					max_min = types.get(DIGITALS);
					currentChar = (char) Random.getRandomInt(max_min.get(0), max_min.get(1));
					generatedPassword[index] = currentChar;
					digitals--;
					index++;
				}
				max_min = null;
				break;
			case SPECIAL_SYMBOLS:
				if (specialSymbols >= 1) {
					max_min = types.get(SPECIAL_SYMBOLS);
					currentChar = (char) Random.getRandomInt(max_min.get(0), max_min.get(1));
					generatedPassword[index] = currentChar;
					specialSymbols--;
					index++;
				}
				max_min = null;
				break;
			case LOWERCASE_LETTERS:

				if (lowerCase >= 1) {
					max_min = types.get(LOWERCASE_LETTERS);
					currentChar = (char) Random.getRandomInt(max_min.get(0), max_min.get(1));
					generatedPassword[index] = currentChar;
					lowerCase--;
					index++;
				}
				max_min = null;
				break;
			case UPPERCASE_LETTERS:

				if (upperCase >= 1) {
					max_min = types.get(UPPERCASE_LETTERS);
					currentChar = (char) Random.getRandomInt(max_min.get(0), max_min.get(1));
					generatedPassword[index] = currentChar;
					upperCase--;
					index++;
				}
				max_min = null;
				break;
			}
		}

		// get random number from random.org in range from 1 to 4 (random will be
		// corresponding to type of the chars which should be inserted)

		// switch numbers, check if that type of char could be inserted

		return generatedPassword;
	}
	
	
	
	
	// method generates password by composing it of random sequences from random.org (which should be faster algorithm because the program will be handling just 4 http request, instead of sending request for each char
	public static char[] generatePasswordBySequences(int lowerCase, int upperCase, int digitals, int specialSymbols) throws TooWeakPasswordException {

		int length = lowerCase + upperCase + digitals + specialSymbols;
		
		if (length <= 6 ) {
			throw new TooWeakPasswordException();
		}
		
		char[] generatedPass = new char[length];
		
		
		
		return generatedPass;
}
	
}
