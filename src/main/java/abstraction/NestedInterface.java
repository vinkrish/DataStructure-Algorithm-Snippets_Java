package abstraction;

public class NestedInterface implements ShowableNI.Message{

	public void msg() {
		System.out.println("Hello nested interface");
	}

}

interface ShowableNI {
	void show();

	interface Message {
		void msg();
	}
}
