package TP1q2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public static void main(String argv[]) {

		try {


		ServerSocket s = new ServerSocket(2334);


		System.out.println("Serveur en attente: ");

		Socket soc = s.accept();


		DataOutputStream out = new DataOutputStream (soc.getOutputStream ());


		

		DataInputStream in = new DataInputStream(soc.getInputStream());



		String chaine1 = in.readUTF();
		String chaine2 = in.readUTF();

		System.out.println("Les chaines recues sont : "+chaine1+" et "+chaine2);
		
		if(chaine1.contains(chaine2)) {
			out.writeUTF(chaine1+" contient "+chaine2);
			out.flush ();
		}
		else {
			out.writeUTF(chaine1+" ne contient pas "+chaine2);
			out.flush ();
		}
		
		


		System.out.println(" adresse client:"+soc.getRemoteSocketAddress() );


		}catch(Exception e) {

		System.err.println("Erreur:"+e);
	}
}

}
