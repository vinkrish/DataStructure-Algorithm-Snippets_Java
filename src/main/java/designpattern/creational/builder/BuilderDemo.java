package designpattern.creational.builder;

public class BuilderDemo {
	public static void main(String args[]) {
			
			LunchOrder.Builder builder = new LunchOrder.Builder();
			
			builder.bread("Wheat").dressing("Mayo").meat("Turkey");
			
			LunchOrder lunchOrder = builder.build();
			
			System.out.println(lunchOrder.getBread());
			System.out.println(lunchOrder.getCondiments());
			System.out.println(lunchOrder.getDressing());
			System.out.println(lunchOrder.getMeat());
			
			BankAccount account = new BankAccount.Builder(1234L)
		            .withOwner("Marge")
		            .atBranch("Springfield")
		            .openingBalance(100)
		            .atRate(2.5)
		            .build();
			System.out.println(account);
			
			BankAccount anotherAccount = new BankAccount.Builder(4567L)
			            .withOwner("Homer")
			            .atBranch("Springfield")
			            .openingBalance(10)
			            .atRate(2.5)
			            .build();
			System.out.println(anotherAccount);
			
		}
}
