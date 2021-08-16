package designpattern.creational.factory.interest;

class NoInterestCalculation implements InterestCalculationStrategy {
    @Override
    public double calculateInterest(double accountBalance) {
        return 0;
    }
}