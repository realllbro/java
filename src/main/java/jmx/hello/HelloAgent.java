package jmx.hello;

import java.rmi.registry.LocateRegistry;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

/**
 * �ڿ��� MBeans�� ���� �����ǵ��� �����Ǹ�
 * �ش� �ڿ��� ������ JMX Agent�� ���� ����˴ϴ�.
 * JMX Agent�� �ٽ� ���� ��Ҵ� MBeanServer �̸�,
 * MBeanServer �� MBean�� ��� �� ���� ������Ʈ �����Դϴ�. 
 * 
 * JMX ������Ʈ���� MBean�� �����ϴ� ���񽺵鵵 ���ԵǾ� �ֽ��ϴ�. 
 */
public class HelloAgent {
	private MBeanServer mbs = null;

	public HelloAgent() {

		// �����θ��� ���ڿ��� �޾� MBeanServer ����
		mbs = MBeanServerFactory.createMBeanServer("HelloDomain");

		// MBean�� �ν��Ͻ� ����
		Hello helloMBean = new Hello();

		try {
			LocateRegistry.createRegistry(7777);
			JMXServiceURL serviceUrl = 
					new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:7777/hello");

			// HelloWorld MBean Name ����
			// �����θ� : NAME=VALUE,,,,
			ObjectName helloMBeanName = new ObjectName("HelloDomain:name=helloMBean");
			
			// helloName���� helloBean�� ���
			mbs.registerMBean(helloMBean, helloMBeanName);
			
			// Client���� �����ϵ��� Ŀ���� ���� �� ����
			JMXConnectorServer connector = 
					JMXConnectorServerFactory.newJMXConnectorServer(serviceUrl, null, mbs);
			connector.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Ű �Է��� ���� �� ���� ��� ����ǵ���
	private static void waitForEnterPressed() {
		try {
			System.out.println("Press  to continue...");
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * JMX ������Ʈ Main�� ManagementFactory Ŭ������ getPlatformMBeanServer () 
	 * �޼ҵ带 ȣ���Ͽ� �÷����� ���� �����ǰ� �ʱ�ȭ �� MBean ������ ���� ���� ������ �����մϴ�.
	 * @param argv
	 */
	public static void main(String argv[]) {
		new HelloAgent();
		System.out.println("HelloAgent is running...");
		HelloAgent.waitForEnterPressed();
	}
}
