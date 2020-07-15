package designpattern.creational.factory.interest;

public class InterestCalculator {
	private final InterestCalculationStrategyFactory interestCalculationStrategyFactory = new InterestCalculationStrategyFactory();
    public double calculateInterest(AccountTypes accountType, double accountBalance) {
        InterestCalculationStrategy interestCalculationStrategy = interestCalculationStrategyFactory.getInterestCalculationStrategy(accountType);
        return interestCalculationStrategy.calculateInterest(accountBalance);
    }
}
