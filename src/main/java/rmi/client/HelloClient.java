package client;

import java.rmi.Naming;

import server.Hello;
  
public class HelloClient   {
	public static void main(String[] args) {
		try {
			Object obj = Naming.lookup("rmi://localhost:1099/HelloRemote");
			Hello remoteObj = (Hello)obj;
			String msg = remoteObj.sayHello(args[0]);
			System.out.println(msg);
		}

		catch(java.rmi.RemoteException e) {
			System.out.println("Something has gone wrong during remote method call...");
		}
		catch(java.rmi.NotBoundException e) {
			System.out.println("Could't bound...");
		}
		catch(java.net.MalformedURLException e) {
			System.out.println("Check url stirng...");
		}
	}
}
