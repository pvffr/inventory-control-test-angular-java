package br.com.paulorezende.inventorycontrol;

import java.util.ArrayList;
import java.util.List;

import br.com.paulorezende.inventorycontrol.model.Incoming;
import br.com.paulorezende.inventorycontrol.model.Outgoing;

public class Fixture {
	
	private static final int ONE_INCOMING = 1;
	
	public static List<Incoming> getAllIncomings(int size, int quantity, int minQuantity) {
		List<Incoming> incomings = new ArrayList<Incoming>();
		for (int i = 1; i <= size; i++) {
			Incoming incoming = new Incoming();
			incoming.setId(String.valueOf(i));
			incoming.setQuantity(quantity);
			incoming.setMinQuantity(minQuantity);
			
			incomings.add(incoming);
		}
		return incomings;
	}
	
	public static Incoming getOneIncoming(int quantity) {
		return getAllIncomings(ONE_INCOMING, quantity, 10).get(0);
	}
	
	public static Incoming getOneIncoming(int quantity, int minQuantity) {
		return getAllIncomings(ONE_INCOMING, quantity, minQuantity).get(0);
	}

	public static Outgoing getOneOutgoing(int quantity) {
		Outgoing outgoing = new Outgoing();
		outgoing.setId("12345");
		outgoing.setQuantity(quantity);
		return outgoing;
	}

}
