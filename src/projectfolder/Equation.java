package projectfolder;

/***
 * PEMDAS parser class. This is to reflect Math hierarchy, where each set can be divided into
 * 1. a digit (value)
 * 2. an operator (operator)
 * 3. the next set (next)
 * 
 * and the priority for PEMDAS, with a subpriority allocated for left to right. Where:
 * P - PRIO 1
 * E - PRIO 2
 * M - PRIO 3
 * D - PRIO 3
 * A - PRIO 4
 * S - PRIO 4
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
}
