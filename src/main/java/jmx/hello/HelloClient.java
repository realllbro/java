package jmx.hello;

import java.util.Arrays;

import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.RuntimeErrorException;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class HelloClient {
	public static void main(String[] args) {
		foo();
	}

	public static void foo() {

		try {
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:7777/hello");
			JMXConnector jmxc = JMXConnectorFactory.connect(url, null);

			// MBeanServerConnection ���
			MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

			// Get domains from MBeanServer
			String domains[] = mbsc.getDomains();
			Arrays.sort(domains);
			for (String domain : domains) {
				System.out.println(domain);
			}

			// JMX Agent���� ����� ObjectName ����
			ObjectName helloMBeanName = new ObjectName("HelloDomain:name=helloMBean");

			// MBeanServerConnection�� ���� MBean�� ���� �����ϴ� ���
			// MBean�� ���� ���� Proxy ���� 
			HelloMBean hello = JMX.newMBeanProxy(mbsc, helloMBeanName, HelloMBean.class, true);

			// MBean�� �޼��带 ���� ȣ��
			hello.setMessage("�氡�氡~~");
			System.out.println(hello.sayHello());   

		} catch (RuntimeErrorException e) {
			System.out.println("Error --->" + e);
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}
}