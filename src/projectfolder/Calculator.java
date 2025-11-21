package projectfolder;

//should probably be a singleton. only one will exist at a time
public class Calculator {

	double existingValue = 0.0;

	
	public Calculator() {
		System.out.println("Sup, I'm Calc");
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
