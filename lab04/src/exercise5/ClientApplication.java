package exercise5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * This class create a client side application
 * This class send a English text and language 
 * that want to translate to server.
 * This class will receive the translated text from server.
 */

public class ClientApplication {

	public static void main(String[] args) 
			throws UnknownHostException, IOException {
		

		
		// Connect to the server @ localhost, port 4228
		Socket socket = new Socket(InetAddress.getLocalHost(), 4228);
		String text = "Goodbye";
		String Language = "Malay";

		// Create stream to write data on the network
		PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
		
		// Send the text and language to the server
		out.write(text +"\n");
		out.write(Language +"\n");
		out.flush();

		
		// Read from network
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		
		
		// Display the translated text
		System.out.println(bufferedReader.readLine());
		
		// Close everything
		bufferedReader.close();
		socket.close();

	}

}
