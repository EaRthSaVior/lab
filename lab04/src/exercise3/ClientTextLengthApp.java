package exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class send text to the server and receive processed data from server.
 *
 */

public class ClientTextLengthApp {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		//create text
		String text= "hello world";
		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);

		// Create stream to write data on the network
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

		
		// Send the text to the server
		out.write(text +"\n");
		out.flush();

		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		// Display the length of text
		System.out.println(bufferedReader.readLine());
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}
