package jmx.hello;

 

/**

 * MBean interface name = implementation class name + MBean. 

 * ǥ�� MBean�� XXXMBean�̶�� Java �������̽��� �ش� �������̽��� �����ϴ� 

 * XXX�̶�� Java Ŭ������ �ۼ��Ͽ� ���ǵ˴ϴ�. 

 */

public interface HelloMBean {

	public void setMessage(String message);

	public String sayHello();

}