package br.com.paulorezende.inventorycontrol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paulorezende.inventorycontrol.model.Incoming;
import br.com.paulorezende.inventorycontrol.model.Outgoing;
import br.com.paulorezende.inventorycontrol.service.IncomingService;
import br.com.paulorezende.inventorycontrol.service.OutgoingService;

@Service
public class OutgoingServiceImpl implements OutgoingService {

	@Autowired
	private IncomingService incomingService;

    @Override
    @Transactional
    public void update(final Outgoing outgoing) {
    	Incoming incoming = incomingService.findById(outgoing.getId());
    	removeQuantity(incoming, outgoing.getQuantity());
    	incomingService.save(incoming);
    }

	private void removeQuantity(Incoming incoming, Integer quantity) {
		if (incoming.getQuantity() > 0 && incoming.getQuantity() > quantity) {
			incoming.setQuantity(incoming.getQuantity() - quantity);  
			verifyLowerQuantity(incoming);
		}
	}

	private void verifyLowerQuantity(Incoming incoming) {
		if ((incoming.getQuantity() <= incoming.getMinQuantity()) ||
				(incoming.getQuantity() >= incoming.getMinQuantity() + 1) ) {
			incoming.setLowerQuantity(true);
		}
	}

}