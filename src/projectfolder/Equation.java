package projectfolder;

/***
 * PEMDAS parser class. This is to reflect Math hierarchy, where each set can be
 * divided into 1. a digit (value) 2. an operator (operator) 3. the next set
 * (next)
 * 
 * and the priority for PEMDAS, with a subpriority allocated for left to right.
 * Where: P - PRIO 1 E - PRIO 2 M - PRIO 3 D - PRIO 3 A - PRIO 4 S - PRIO 4
 * 
 * @author trist
 *
 */
public class Equation {
	public double value;
	public char operator;
	public Equation next;
	public int priority;

	public Equation(double value, char operator, Equation next) {
		this.value = value;
		this.operator = operator;
		this.next = next;
		this.priority = determinePriority(operator);
	}

	private int determinePriority(char operator) {
		int returnPriority = 0;
		switch (operator) {
		case '(':
		case ')':
			returnPriority = 1;
			break;
		case 'e':
			returnPriority = 2;
			break;
		case '*':
		case '/':
			returnPriority = 3;
			break;
		case '+':
		case '-':
			returnPriority = 4;
			break;
		default:
			System.out.println("operator is null");
			break;
		}
		return returnPriority;
	}
	
	public double startCalculation(Equation startingEQ) {
 		double returnVal = 0.0;
		StringBuilder sb = new StringBuilder();

		while(startingEQ != null) {
			String firstNum = String.valueOf(startingEQ.value);
			char opString = Character.valueOf( startingEQ.operator);
			String secondNum = String.valueOf(startingEQ.next.value);
			sb.append(firstNum);
			sb.append(opString);
			sb.append(secondNum);
			
			String completeEquation = sb.toString();
			sb.setLength(0);
			System.out.println("Complete Equation:" + completeEquation);
			System.out.println();
			
			startingEQ = startingEQ.next;
			double value = decideOperator(completeEquation);
			startingEQ.value = value;
			System.out.println("New Value: " + startingEQ.value);
			System.out.println("New Operator: " + startingEQ.operator);
		}
		
		
		return returnVal;
	}
	
	private double decideOperator(String _strFormula) {
		double returnValue = Double.NaN;

		if (_strFormula.contains("*")) {
			int pos = _strFormula.indexOf('*');

			double valA = Double.valueOf(_strFormula.substring(0, pos));
			double valB = Double.valueOf(_strFormula.substring(pos + 1, _strFormula.length()));
			returnValue = multiplyOp(valA, valB);
		}
		if (_strFormula.contains("+")) {
			int pos = _strFormula.indexOf('+');

			double valA = Double.valueOf(_strFormula.substring(0, pos));
			double valB = Double.valueOf(_strFormula.substring(pos + 1, _strFormula.length()));
			returnValue = addOp(valA, valB);
		}
		if (_strFormula.contains("-")) {
			int pos = _strFormula.indexOf('-');

			double valA = Double.valueOf(_strFormula.substring(0, pos));
			double valB = Double.valueOf(_strFormula.substring(pos + 1, _strFormula.length()));
			returnValue = subtractOp(valA, valB);
		}
		if (_strFormula.contains("/")) {
			int pos = _strFormula.indexOf('/');

			double valA = Double.valueOf(_strFormula.substring(0, pos));
			double valB = Double.valueOf(_strFormula.substring(pos + 1, _strFormula.length()));
			returnValue = divideOp(valA, valB);
		}

		return returnValue;
	}

	private double addOp(double _inputValue1, double _inputValue2) {
		double returnValue = 0.0;
		returnValue = _inputValue1 + _inputValue2;
		return returnValue;
	}

	private double multiplyOp(double _inputValue1, double _inputValue2) {
		double returnValue = 0.0;
		returnValue = _inputValue1 * _inputValue2;
		return returnValue;
	}

	private double subtractOp(double _inputValue1, double _inputValue2) {
		double returnValue = 0.0;
		returnValue = _inputValue1 - _inputValue2;
		return returnValue;
	}

	private double divideOp(double _inputValue1, double _inputValue2) {
		double returnValue = 0.0;
		returnValue = _inputValue1 / _inputValue2;
		return returnValue;
	}
	
}
