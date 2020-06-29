package challange;

public class RedeemPoint {

	public static void main(String[] args) throws Exception {
	}
	
	public boolean redeemPoint(String customerId, String amount) throws Exception {
		try {
			Double toRedeem = Double.valueOf(amount);
			double currentPoints = myService.getPoints(customerId);
			double newPoints = currentPoints - toRedeem;
			if(newPoints >= 0) {
				myService.save(customerId, newPoints);
				log.info(&quot;Points redeemed for customer {}&quot;,customerId);
				return true
			}
			return false;
		} catch(NumberFormatException e) {
			throw new NumberFormatException();
		} catch(Exception e) {
			throw new Exception();
		}
		
	}

}
