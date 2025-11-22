package projectfolder;

import java.io.IOException;

//should probably be a singleton. only one will exist at a time
public class Calculator {

	
	boolean debug = false;

	
	public Calculator(boolean _debug) {
		this.debug = _debug;
	}
	
	private void coolCosmetic() {
		
		System.out.println("/////CCCCCCCC/////////CCCCCCCC/////////CCCCCCCC/////CCC/////////");
		System.out.println("////CCCCCCCCCC///////CCCCCCCCCC///////CCCCCCCCCC////CCC/////////");
		System.out.println("///CCC//////CCC/////CCC//////CCC/////CCC//////CCC///CCC/////////");
		System.out.println("///CCC//////////////CCC//////CCC/////CCC//////CCC///CCC/////////");
		System.out.println("///CCC//////CCC/////CCC//////CCC/////CCC//////CCC///CCC/////////");
		System.out.println("////CCCCCCCCCC///////CCCCCCCCCC///////CCCCCCCCCC////CCCCCCCCC///");
		System.out.println("/////CCCCCCCC/////////CCCCCCCC/////////CCCCCCCC/////CCCCCCCCC///");
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		System.out.println("/////CCCCCCCC////////////CCC//////////CCC//////////CCCCCCCC/////");
		System.out.println("////CCCCCCCCCC//////////CCCCC/////////CCC/////////CCCCCCCCCC////");
		System.out.println("///CCC//////CCC////////CCC/CCC////////CCC////////CCC//////CCC///");
		System.out.println("///CCC////////////////CCC///CCC///////CCC////////CCC////////////");
		System.out.println("///CCC//////CCC//////CCCCCCCCCCC//////CCC////////CCC//////CCC///");
		System.out.println("////CCCCCCCCCC//////CCC///////CCCC////CCCCCCCCC///CCCCCCCCCC////");
		System.out.println("/////CCCCCCCC//////CCC/////////CCC////CCCCCCCCC////CCCCCCCC/////");
		System.out.println("////////////////////////////////////////////////////////////////");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		
		
	}
	
	
	
	//Requires two operators, doesn't have existing value carry over
	public void runCalculatorReference() throws IOException {
		coolCosmetic();
		
		
		double existingValue = Double.NaN;
		String userInput = "";
		int charReader = 0;
		double calculationValue = 0.0;
		
		StringBuilder sb = new StringBuilder();
		while ((charReader = System.in.read()) != -1 ) {
			if(charReader == '\n') {
				userInput = sb.toString().trim().replace(" " , "");
				if(debug) {
					System.out.println(userInput);
				}
				
				calculationValue = decideOperator(userInput);
				System.out.println(calculationValue);
				sb.setLength(0);
			}
			else if(charReader == '\t') {
				break;
			}
			sb.append((char) charReader);
		}
		System.out.println("Closing calculator :)");
	}
	
	//Requires two operators, doesn't have existing value carry over
	public void runCalculator() throws IOException {
		coolCosmetic();
		
		double existingValue = Double.NaN;
		String userInput = "";
		int charReader = 0;
		double calculationValue = 0.0;
		
		StringBuilder sb = new StringBuilder();
		while ((charReader = System.in.read()) != -1 ) {
			if(charReader == '\n') {
				userInput = sb.toString().trim().replace(" " , "");
				if(debug) {
					System.out.println(userInput);
				}
				
				calculationValue = decideOperator(userInput);
				System.out.println(calculationValue);
				sb.setLength(0);
			}
			else if(charReader == '\t') {
				break;
			}
			sb.append((char) charReader);
		}
		System.out.println("Closing calculator :)");
	}
	
	private double decideOperator(String _strFormula) {
		double returnValue = Double.NaN;
		
		if( _strFormula.contains("*")) {
			int pos = _strFormula.indexOf('*');
			
			double valA = Double.valueOf(_strFormula.substring(0, pos));
			double valB = Double.valueOf(_strFormula.substring(pos+1, _strFormula.length()));
			returnValue = multiplyOp(valA, valB);
		}
		if( _strFormula.contains("+")) {
			int pos = _strFormula.indexOf('+');
			
			double valA = Double.valueOf(_strFormula.substring(0, pos));
			double valB = Double.valueOf(_strFormula.substring(pos+1, _strFormula.length()));
			returnValue = addOp(valA, valB);
		}
		if( _strFormula.contains("-")) {
			int pos = _strFormula.indexOf('-');
			
			double valA = Double.valueOf(_strFormula.substring(0, pos));
			double valB = Double.valueOf(_strFormula.substring(pos+1, _strFormula.length()));
			returnValue = subtractOp(valA, valB);
		}
		if( _strFormula.contains("/")) {
			int pos = _strFormula.indexOf('/');
			
			double valA = Double.valueOf(_strFormula.substring(0, pos));
			double valB = Double.valueOf(_strFormula.substring(pos+1, _strFormula.length()));
			returnValue = divideOp(valA, valB);
		}
		
		return returnValue;
	}
	
	public double addOp(double _inputValue1, double _inputValue2) {
		double returnValue = 0.0;
		returnValue = _inputValue1 + _inputValue2;
		return returnValue;
	}
	
	public double multiplyOp(double _inputValue1, double _inputValue2) {
		double returnValue = 0.0;
		returnValue = _inputValue1 * _inputValue2;
		return returnValue;
	}
	
	public double subtractOp(double _inputValue1, double _inputValue2) {
		double returnValue = 0.0;
		returnValue = _inputValue1 - _inputValue2;
		return returnValue;
	}
	public double divideOp(double _inputValue1, double _inputValue2) {
		double returnValue = 0.0;
		returnValue = _inputValue1 / _inputValue2;
		return returnValue;
	}
	
}
