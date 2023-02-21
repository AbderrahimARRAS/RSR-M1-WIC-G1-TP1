package TP1q2;
import java.io.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class client {
	public static void main(String argv[]) {
		
		try {
			Socket socket = new Socket("localhost",2334);
			
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
		    
		    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			out.writeUTF(chaine1);
			out.writeUTF(chaine2);
			out.flush();
		    
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String line = in.readUTF();
			System.out.println("message recu du serveur est: "+line);
			
			
			
			
		}
		catch (Exception e) {
			System.err.println("Erreur :"+e);
		}
	}
}
