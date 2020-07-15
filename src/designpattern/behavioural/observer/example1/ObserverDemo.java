package designpattern.behavioural.observer.example1;

public class ObserverDemo {

	public static void main(String args[]) {
		Subject subject = new MessageStream();
		
		PhoneClient phoneClient = new PhoneClient(subject);
		TabletClient tabletClient = new TabletClient(subject);
		
		subject.setState("Here is a new message!");
		subject.detach(tabletClient);
		subject.setState("Another new message!");
		phoneClient.addMessage("This is not right!");
	}
	
}
