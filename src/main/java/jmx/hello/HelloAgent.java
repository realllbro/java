package jmx.hello;

import java.rmi.registry.LocateRegistry;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

/**
 * 자원이 MBeans에 의해 관리되도록 구현되면
 * 해당 자원의 관리는 JMX Agent에 의해 수행됩니다.
 * JMX Agent의 핵심 구성 요소는 MBeanServer 이며,
 * MBeanServer 는 MBean이 등록 된 관리 오브젝트 서버입니다. 
 * 
 * JMX 에이전트에는 MBean을 관리하는 서비스들도 포함되어 있습니다. 
 */
public class HelloAgent {
	private MBeanServer mbs = null;

	public HelloAgent() {

		// 도메인명을 문자열로 받아 MBeanServer 생성
		mbs = MBeanServerFactory.createMBeanServer("HelloDomain");

		// MBean의 인스턴스 생성
		Hello helloMBean = new Hello();

		try {
			LocateRegistry.createRegistry(7777);
			JMXServiceURL serviceUrl = 
					new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:7777/hello");

			// HelloWorld MBean Name 정의
			// 도메인명 : NAME=VALUE,,,,
			ObjectName helloMBeanName = new ObjectName("HelloDomain:name=helloMBean");
			
			// helloName으로 helloBean을 등록
			mbs.registerMBean(helloMBean, helloMBeanName);
			
			// Client에서 접속하도록 커넥터 생성 및 시작
			JMXConnectorServer connector = 
					JMXConnectorServerFactory.newJMXConnectorServer(serviceUrl, null, mbs);
			connector.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 키 입력이 있을 때 까지 계속 실행되도록
	private static void waitForEnterPressed() {
		try {
			System.out.println("Press  to continue...");
			System.in.read();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * JMX 에이전트 Main은 ManagementFactory 클래스의 getPlatformMBeanServer () 
	 * 메소드를 호출하여 플랫폼에 의해 생성되고 초기화 된 MBean 서버를 가져 오는 것으로 시작합니다.
	 * @param argv
	 */
	public static void main(String argv[]) {
		new HelloAgent();
		System.out.println("HelloAgent is running...");
		HelloAgent.waitForEnterPressed();
	}
}
