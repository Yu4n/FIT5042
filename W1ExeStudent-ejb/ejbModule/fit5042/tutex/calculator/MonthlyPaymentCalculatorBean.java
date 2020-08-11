package fit5042.tutex.calculator;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class MonthlyPaymentCalculatorBean
 */
@Stateless
public class MonthlyPaymentCalculatorBean implements MonthlyPaymentCalculator {
	/**
	 * Default constructor.
	 */
	public MonthlyPaymentCalculatorBean() {
	} // TODO Auto-generated constructor stub

	@Override
	public double calculate(double principle, int year, double interestRate) {
		double monthlyPayment = 0.0;
		int numberOfPayments = year * 12;
		monthlyPayment = principle * (interestRate * (Math.pow((1 + interestRate), numberOfPayments)))
				/ ((Math.pow((1 + interestRate), numberOfPayments)) - 1);
		return monthlyPayment;
	}
}