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
		System.out.println("Hi There, I'm a Calculator! ");
		System.out.println("Insert Really Cool Design here ~~");
		Calculator calc = new Calculator();
		
		int inputValue;
		StringBuilder sb = new StringBuilder();
		while ((inputValue = System.in.read()) != -1 ) {
			if(inputValue == '\n') {
				break;
			}
			sb.append((char) inputValue);
		}
		
		String readValue = sb.toString().trim().replace(" " , "");
		
		if(debug) {
			System.out.println(readValue);
		}
			
		double value = Double.NaN;
		if( readValue.contains("*")) {
			int pos = readValue.indexOf('*');
//			System.out.println(pos);
			
			double valA = Double.valueOf(readValue.substring(0, pos));
			double valB = Double.valueOf(readValue.substring(pos+1, readValue.length()));
//			System.out.println("values " + val1 + " " +  val2);
			
//			String[] vals = readValue.split("*"); //wasn't working TODO: debug
			
//			String vals = readValue.split("*")[0];
//			String vals2 = readValue.split("*")[1];
//			double valA = Double.valueOf(vals[0]);
//			double valB = Double.valueOf(vals[1]);
			value = calc.multiplyOp(valA, valB);
		}
		if( readValue.contains("+")) {
			int pos = readValue.indexOf('+');
			double valA = Double.valueOf(readValue.substring(0, pos));
			double valB = Double.valueOf(readValue.substring(pos+1, readValue.length()));
			
			value = calc.addOp(valA, valB);
		}
		if( readValue.contains("-")) {
			int pos = readValue.indexOf('-');
			double valA = Double.valueOf(readValue.substring(0, pos));
			double valB = Double.valueOf(readValue.substring(pos+1, readValue.length()));
			
			value = calc.subtractOp(valA, valB);
		}
		if( readValue.contains("/")) {
			int pos = readValue.indexOf('/');
			double valA = Double.valueOf(readValue.substring(0, pos));
			double valB = Double.valueOf(readValue.substring(pos+1, readValue.length()));
			value = calc.divideOp(valA, valB);
		}
		
		System.out.println(value);
	}

}
