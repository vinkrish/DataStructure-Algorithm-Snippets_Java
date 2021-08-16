package reflection;

import java.util.ArrayList;
import java.util.List;

public class ReflectClass {
	private String msg;
	public String publicMsg;
	public List<String> stringList = new ArrayList<>();
	
	public ReflectClass() {
		
	}
	
	public ReflectClass(String msg) {
		this.msg = msg;
	}
		
	private void message() {
		System.out.println("hello java");
	}
	
	private String getPrivateMethodValue() {
		return "Hello Reflection!";
	}
	
	public String getPublicMsg() {
		return publicMsg;
	}
	
	public void setPublicMsg(String publicMsg) {
		this.publicMsg = publicMsg;
	}
	
	public void printPrivateMsg() {
		System.out.println("Private msg: " + this.msg);
	}
	
	public List<String> getStringList(){
	    return this.stringList;
	}
	
	public void setStringList(List<String> list){
	    this.stringList = list;
	}
}
