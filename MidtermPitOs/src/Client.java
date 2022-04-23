import java.io.*;
import java.net.*;
import java.util.Scanner;

class Client {
	public static void main(String args[]) {
		
		//initialize sockets and I/O
		Socket sock;
		Scanner scan;
		BufferedReader br;
		PrintWriter pw;
		
	    try {
	    	// establish a connection to the server
	        sock = new Socket("127.0.0.1", 4444);
	        System.out.println("You have been accepted: " + new java.util.Date().toString() + "\ntype 'end' to leave the server");
	        
	        //user input
	        scan = new Scanner(System.in);
	        
	        //takes I/O from the socket
	        br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
	        pw = new PrintWriter(sock.getOutputStream(), true);
	        
	        String line;
	        while( (line = scan.nextLine()) != null) { //user input
	            pw.println(line); //writes the object string line of user input to the socket
	            if(line.equals("end")) { //close the connection
	            	System.out.println("You left the server: " + new java.util.Date().toString());
	            	break;
	            } else System.out.println("echoed from server: " + br.readLine());} //br.readLine() reads a line of text of the last user input from the socket
	    } catch(IOException e){ e.printStackTrace();}
	}
}