package fit5042.tutex.repository.entities;

/**
 *
 * @author Eddie
 */
public class Loan {
	private double principle;
	private double interestRate;
	private int numberOfYears;
	private double monthlyPayment;

	public Loan() {
		this.principle = 0.0;
		this.interestRate = 0.0;
		this.numberOfYears = 0;
		this.monthlyPayment = 0.0;
	}

	public Loan(double principle, double interestRate, int numberOfYears) {
		this.principle = principle;
		this.interestRate = interestRate;
		this.numberOfYears = numberOfYears;
	}

	public double getPrinciple() {
		return principle;
	}

	public void setPrinciple(double principle) {
		this.principle = principle;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public int getNumberOfYears() {
		return numberOfYears;
	}

	public void setNumberOfYears(int numberOfYears) {
		this.numberOfYears = numberOfYears;
	}

	public double getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(double monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
}