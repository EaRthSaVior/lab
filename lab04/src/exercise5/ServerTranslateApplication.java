package exercise5;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * This class launch the server side application using TCP.
 * The server receive English text and language.
 * The server will find out the translated text in database and 
 * send to client.
 *
 */

public class ServerTranslateApplication {

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

				
				//receive the text and language from client
				String input = in.readLine();
				String language = in.readLine();
				
				// find out what language
				String malay="Malay";
				String arabic = "Arabic";
				String korean = "Korean";
				int num= 0;
				if(language.equals(malay))
					num = 1;
				else if(language.equals(arabic))
					num = 2;
				else if (language.equals(korean))
					num = 3;
				
				try (
						//find the translation in database
						BufferedReader inDatabase = new BufferedReader(
								new FileReader("database.txt"))) 
				{
					String translate="";
					while((translate =inDatabase.readLine())!= null) {
						System.out.println(translate);
						if(input.equals(translate)) {
							for(int i = 0; i<num;i++)
								translate = inDatabase.readLine();
							
							break;
						}
					}
					
					// Create stream to write data on the network
					PrintWriter out = new PrintWriter(
							clientSocket.getOutputStream(),true);
					
					// Send translated text back to the client
					out.write(translate +"\n");
					out.flush();
				}
				// Close the socket
				clientSocket.close();
			
				
			}
		}
		
		

	}

}
