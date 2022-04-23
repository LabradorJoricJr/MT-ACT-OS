import java.io.*;
import java.net.*;

class Server {
    public static void main(String args[]) {
    	
    	//initialize sockets and I/O
    	ServerSocket svrsock;
    	Socket sock;
    	BufferedReader br;
    	PrintWriter pw;
    	
        try {
        	//starts server and waits for a connection
        	svrsock = new ServerSocket(4444);
            System.out.println("Server Created\nWaiting for a client...");
            sock = svrsock.accept();
            System.out.println("Client joins the server: " + new java.util.Date().toString());
            
            //takes I/O from the socket
            br = new BufferedReader (new InputStreamReader(sock.getInputStream()));
            pw = new PrintWriter(sock.getOutputStream(), true);
            
            String line;
            while( (line = br.readLine()) != null) {
            	if(line.equals("end")) { //close the connection
                    System.out.println("Client disconnected: " + new java.util.Date().toString());
                    break;
                }
                else
                    pw.println(line); //writes the object string line to the socket
            }
            } catch(IOException e) {e.printStackTrace();
        }
    }    
}