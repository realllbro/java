package server;

public class HelloServer {
	public static void main(String[] args) {
	   try {
	      HelloImpl remoteObj = new HelloImpl();
	java.rmi.Naming.rebind("rmi://localhost:1099/HelloRemote", remoteObj);
	      System.out.println("Hello Remote Object bound to the registry and ready to service incoming client calls...");
	   }   catch(java.rmi.RemoteException e) {
		System.err.println("Exception occurred during processing incoming method call");
	   }	catch(java.net.MalformedURLException e) {
		System.err.println("Check the url String...");
	   }
	}
}
