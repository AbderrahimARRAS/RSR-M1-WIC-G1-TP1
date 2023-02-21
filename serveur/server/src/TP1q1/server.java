package TP1q1;

import java.net.*;
import java.io.*;


public class server{
	
	public static void main(String argv[]) {
		

		try {

		

		ServerSocket s = new ServerSocket(3120);


		System.out.println("Serveur en attente: ");

		Socket soc = s.accept();


		PrintWriter out = new PrintWriter (soc.getOutputStream ());


	
		InputStreamReader reader = new InputStreamReader(soc.getInputStream());

		BufferedReader in = new BufferedReader(reader);


		String chaine1 = in.readLine();
		String chaine2 = in.readLine();

		System.out.println("Les chaines recues sont : "+chaine1+" et "+chaine2);
		
		if(chaine1.contains(chaine2)) {
			out.println(chaine1+" contient "+chaine2);
			out.flush ();
		}
		else {
			out.println(chaine1+" ne contient pas "+chaine2);
			out.flush ();
		}
		
		


		System.out.println(" adresse client:"+soc.getRemoteSocketAddress() );


		}catch(Exception e) {

		System.err.println("Erreur:"+e);
	}
}
}

