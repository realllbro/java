package jmx.hello;

 

/**

 * MBean interface name = implementation class name + MBean. 

 * 표준 MBean은 XXXMBean이라는 Java 인터페이스와 해당 인터페이스를 구현하는 

 * XXX이라는 Java 클래스를 작성하여 정의됩니다. 

 */

public interface HelloMBean {

	public void setMessage(String message);

	public String sayHello();

}