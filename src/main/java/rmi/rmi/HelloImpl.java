package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject  implements Hello {
		public HelloImpl() throws RemoteException {
			super();
		}

	//원격 메소드 구현
	public String sayHello(String name) {
		return "Hello World ... " + name + "!";
	}
}