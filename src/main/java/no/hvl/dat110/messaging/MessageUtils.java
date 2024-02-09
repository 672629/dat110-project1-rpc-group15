package no.hvl.dat110.messaging;

import java.util.Arrays;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static int MESSAGINGPORT = 8080;
	public static String MESSAGINGHOST = "localhost";

	public static byte[] encapsulate(Message message) {

		byte[] segment = null;
		byte[] data;

		// TODO - START
		data = message.getData();
		int size = data.length;
		segment = new byte[128];
		segment[0] = (byte) size;
		for (int i = 0; i < data.length; i++) {
			segment[i + 1] = data[i];
		}
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messaging layer

		/*
		 * if (true) throw new UnsupportedOperationException(TODO.method());
		 * 
		 * // TODO - END
		 */
		return segment;

	}

	public static Message decapsulate(byte[] segment) {

		Message message = null;

		// TODO - START
		// decapsulate segment and put received payload data into a message

		if (segment.length > 0) {
			byte[] kopiArray = new byte[segment[0]];

			for (int i = 0; i < kopiArray.length; i++) {
				kopiArray[i] = segment[i + 1];
			}
			message = new Message(kopiArray);
		} else {
			throw new IllegalStateException("Ingen data mottatt i segment-arrayet");
		}
		/*
		 * if (true) throw new UnsupportedOperationException(TODO.method());
		 * 
		 * // TODO - END
		 */

		return message;

	}

}
