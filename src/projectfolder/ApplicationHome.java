package projectfolder;

import java.io.IOException;

// TODO: consolidate repeating code in operators
// TODO: use split instead of substring for string splitting the values
// TODO: catch statements for character inputs other than numbers
// TODO: use new line character to enter calculator process, but don't leave user input
//		 until you hit a certain character sequence

public class ApplicationHome {

	private static boolean debug = true;
	
	public static void main(String[] args) throws IOException {
		Calculator calc = new Calculator(debug);
		calc.runCalculator();
	}
}
