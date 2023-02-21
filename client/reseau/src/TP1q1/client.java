package TP1q1;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class client {
	public static void main(String argv[]) {
		
		try {
            Socket socket = new Socket("localhost", 3120);

			
			System.out.println("mon adress client: "+socket.getLocalAddress()+": "+socket.getLocalPort());
			System.out.println("mon serveur est: "+socket.getInetAddress()+": "+socket.getPort());
			
			Scanner scanner = new Scanner(System.in);
		    System.out.print("Entrez la 1er chaine : ");
		    String chaine1 = scanner.nextLine();
		    System.out.print("Entrez la 2eme chaine : ");
		    String chaine2 = scanner.nextLine();
		    
		    System.out.println("Les chaines envoyees :");
		    System.out.println(chaine1);
		    System.out.println(chaine2);
		    
		    PrintWriter out = new PrintWriter(socket.getOutputStream());
			out.println(chaine1);
			out.println(chaine2);
			out.flush();
		    
			InputStreamReader reader = new InputStreamReader(socket.getInputStream());
			BufferedReader in = new BufferedReader(reader);
			String line = in.readLine();
			System.out.println("message recu du serveur est: "+line);
			
			
			
		}
		catch (Exception e) {
			System.err.println("Erreur :"+e);
		}
	}
}
