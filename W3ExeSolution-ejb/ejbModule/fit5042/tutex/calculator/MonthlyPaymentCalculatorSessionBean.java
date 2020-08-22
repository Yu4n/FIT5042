package fit5042.tutex.calculator;

import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 * A simple monthly payment calculator implementation
 *
 * @author Eddie Leung
 */
@Stateless
public class MonthlyPaymentCalculatorSessionBean implements MonthlyPaymentCalculator {
	
	@Override
    public double calculate(double principle, int year, double interestRate) {
        double monthlyPayment = 0.0;
        int numberOfPayments = year * 12;
        if (interestRate > 0) {
            monthlyPayment = principle * (interestRate * (Math.pow((1 + interestRate), numberOfPayments))) / ((Math.pow((1 + interestRate), numberOfPayments)) - 1);
        } else {
            monthlyPayment = 1000;
        }

        return monthlyPayment;
    }
}
