package misc;

public class CallByValueO {

	int data = 50;

	void change(CallByValueO op) {
		op.data = op.data + 100;// changes will be in the instance variable
	}

	public static void main(String args[]) {
		CallByValueO op = new CallByValueO();

		System.out.println("before change " + op.data);
		op.change(op);// passing object
		System.out.println("after change " + op.data);
	}

}
