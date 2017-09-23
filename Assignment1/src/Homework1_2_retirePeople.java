
public class Homework1_2_retirePeople {

	// instance variable
	private double retirementGoal;
	private double currentBalance;
	private double contributionPerYear;
	private double gainPerYear;

	// constructor
	public Homework1_2_retirePeople( double goal, double balance, 
			double contribution, double gain) {
		retirementGoal = goal;
		currentBalance = balance;
		contributionPerYear = contribution;
		gainPerYear = gain;
	}

	// get retirement goal
	public double getRetirementGoal() {
		return retirementGoal;
	}

	// get current balance
	public double getCurrentBalance() {
		return currentBalance;
	}

	// get contribution per year
	public double getContributionPerYear() {
		return contributionPerYear;
	}

	// get gain per year
	public double getGainPerYear() {
		return gainPerYear;
	}

	// set retirement goal
	public void setRetirementGoal( double goal ) {
		retirementGoal = goal;
	}

	// set current balance
	public void setCurrentBalance( double balance ) {
		currentBalance = balance;
	}

	// set contribution per year
	public void setContributionPerYear ( double contribution ) {
		contributionPerYear = contribution;
	}

	// set contribution per year
	public void setGainPerYear ( double gain ) {
		gainPerYear = gain;
	}

}
