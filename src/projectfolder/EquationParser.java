package projectfolder;

/***
 * Function of this class should: 1. parse the string and build equations 2.
 * step through the equations correctly.
 * 
 * @author trist
 *
 */
public class EquationParser {

	/*** Holds the beginning pointer if higher prio found */
	Equation holdingPtr = null;
	/*** Holds the current pointer */
	Equation currPtr = null;
	/*** Holds the next pointer */
	Equation nextPtr = null;

	String userInput = "";

	public EquationParser(String userInput) {
		this.userInput = userInput;
		System.out.println("User Input" + userInput);
		beginParsing();
	}

	private void beginParsing() {
		StringBuilder sb = new StringBuilder();
		double digit = Double.NaN;
		Equation eqObj;

		for (char value : userInput.toCharArray()) {
			System.out.println("Parsing Character: " + value);

			// Temporary, until I have exponents
			if (Character.isAlphabetic(value)) {
				System.out.println("Alphabetic value found, this is a calculator. Exiting");
				System.exit(1);
			} else if (Character.isDigit(value)) {
				sb.append(value);
			} else if (value == '*' || value == '/' || value == '+' || value == '-') {
				digit = Double.valueOf(sb.toString());
				eqObj = new Equation(digit, value, null);
				sb.setLength(0);

				// Case 1: first time making an EQ
				if (holdingPtr == null) {
					holdingPtr = eqObj;
					currPtr = eqObj;
				}

				// compare currPtr (previous Equation) to current values
				else {
					System.out.println("Prev Priority: " + currPtr.priority + " New Priority: " + eqObj.priority);
					currPtr.next = eqObj;
					currPtr = currPtr.next;
				}

				// Case 2: first time making EQ,

			}
		}
		
		//For loop goes to length of char, so we've finished string, begin running calculations
		digit = Double.valueOf(sb.toString());
		eqObj = new Equation(digit, Character.MAX_VALUE, null);
		currPtr.next = eqObj;
		eqObj.startCalculation(holdingPtr);
		System.out.println();
	}
	
	

}
