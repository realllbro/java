package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloImpl extends UnicastRemoteObject  implements Hello {
		public HelloImpl() throws RemoteException {
			super();
		}

	//���� �޼ҵ� ����
	public String sayHello(String name) {
		return "Hello World ... " + name + "!";
	}
}