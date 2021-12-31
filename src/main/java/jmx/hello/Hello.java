package jmx.hello;

/**
 * MBean �������̽� ����ü
 *
 */
public class Hello implements HelloMBean {
	
	private String message = null;
	
	public Hello() {
		this.message = "Hello JMX!";
	}

	public Hello(String message) {
		this.message = message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String sayHello() {
		return "JMX Message ::: " + this.message;		
	}

}