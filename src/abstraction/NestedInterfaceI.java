package abstraction;

public class NestedInterfaceI implements ShowableNI.Message{

	public void msg() {
		System.out.println("Hello nested interface");
	}

	public static void main(String[] args) {
		ShowableNI.Message message = new NestedInterfaceI();// upcasting here
		message.msg();
	}

}

interface ShowableNI {
	void show();

	interface Message {
		void msg();
	}
}