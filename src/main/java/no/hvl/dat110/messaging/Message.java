package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class Message {

	// the up to 127 bytes of data (payload) that a message can hold
	private byte[] data;

	// construction a Message with the data provided
	public Message(byte[] data) {
		
		this.data = data;
		
		if(data.length <= 127 && data != null) {
			throw new UnsupportedOperationException(TODO.constructor("Message"));
		}
		
			
		// TODO - END
	}

	public byte[] getData() {
		return this.data; 
	}

}
