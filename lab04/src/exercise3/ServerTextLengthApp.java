package exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class launch the server side application using TCP.
 * The server receive the text from client and 
 * count the number of words in the text and returns it to the client
 */

public class ServerTextLengthApp {

	/**
	 * Main entry point to the server side application
	 * @param args
	 * @throws IOException 
	 */
	
	public static void main(String[] args) throws IOException {
		
		// Binding to a port or any other port no you are fancy of
		int portNo = 4228;
		
		try (ServerSocket serverSocket = new ServerSocket(portNo)) {
			
			// Server needs to be alive forever
			while (true) {
				
				// Accept client request for connection
				Socket clientSocket = serverSocket.accept();
				
				//create stream to receive text from client
				BufferedReader in = new BufferedReader(new InputStreamReader(
						clientSocket.getInputStream()));

				
				//receive the text from client and save the length of text
				int length = in.readLine().length();
				
				// Create stream to write data on the network
				PrintWriter out = new PrintWriter(clientSocket.getOutputStream()
						,true);

				
				// Send processed data back to the client
				out.write(length +"\n");
				out.flush();
				
				// Close the socket
				clientSocket.close();
			
			}
		}
		
		

	}

}
