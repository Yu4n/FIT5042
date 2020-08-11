package fit5042.tutex.calculator.mbeans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import fit5042.tutex.calculator.MonthlyPaymentCalculator;
import fit5042.tutex.calculator.navigation.Navigation;
import fit5042.tutex.repository.entities.Loan;

@ManagedBean
@SessionScoped
public class LoanManagedBean implements Serializable {
	@EJB
	private MonthlyPaymentCalculator calculator;
	private Loan loan;

	public LoanManagedBean() {
		this.loan = new Loan();
	}

	public MonthlyPaymentCalculator getCalculator() {
		return calculator;
	}

	public void setCalculator(MonthlyPaymentCalculator calculator) {
		this.calculator = calculator;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public String calculate() {
		this.loan.setMonthlyPayment(
				this.calculator.calculate(loan.getPrinciple(), loan.getNumberOfYears(), loan.getInterestRate()));
		return Navigation.index.toString();
	}
}