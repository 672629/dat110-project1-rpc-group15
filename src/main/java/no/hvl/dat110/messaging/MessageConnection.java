package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;


public class MessageConnection {

	private DataOutputStream outStream; // for writing bytes to the underlying TCP connection
	private DataInputStream inStream; // for reading bytes from the underlying TCP connection
	private Socket socket; // socket for the underlying TCP connection
	
	public MessageConnection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream (socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {

		byte[] data;
		
		// TODO - START
		// encapsulate the data contained in the Message and write to the output stream
		
		//Burde potensielt lagt messageUtil i kontruktøren? men det er her TODO er.
		
		data = MessageUtils.encapsulate(message);
		
		//skriv størrelsen på det vi skal sende
		try {
			outStream.writeInt(data.length);
		
		//skriv dataen på det vi skal sende
		outStream.write(data);
		
		//flush for å la inputStream lese dataen
		outStream.flush();
		
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*if (true)
			throw new UnsupportedOperationException(TODO.method());*/
			
		// TODO - END

	}

	public Message receive() {

		Message message = null;
		byte[] data;
		
		// TODO - START
		// read a segment from the input stream and decapsulate data into a Message
		
		int size;
		try {
			size = inStream.readInt();
			data = new byte[size];
			
			inStream.read(data);
			
			message = MessageUtils.decapsulate(data);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*if (true)
			throw new UnsupportedOperationException(TODO.method());*/
		
		// TODO - END
		
		return message;
		
	}

	// close the connection by closing streams and the underlying socket	
	public void close() {

		try {
			
			outStream.close();
			inStream.close();

			socket.close();
			
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}