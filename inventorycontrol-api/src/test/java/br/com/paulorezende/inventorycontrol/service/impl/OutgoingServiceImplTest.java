package br.com.paulorezende.inventorycontrol.service.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.paulorezende.inventorycontrol.Fixture;
import br.com.paulorezende.inventorycontrol.model.Incoming;
import br.com.paulorezende.inventorycontrol.model.Outgoing;
import br.com.paulorezende.inventorycontrol.service.IncomingService;
import br.com.paulorezende.inventorycontrol.service.OutgoingService;

@RunWith(MockitoJUnitRunner.class)
public class OutgoingServiceImplTest { 

	private static final Integer ZERO_QUANTITY = 0;
	private static final Integer FIVE_QUANTITY = 5;
	private static final Integer TEN_QUANTITY = 10;
	private static final Integer MIN_QUANTITY = 6;
	private static final Integer THREE_QUANTITY = 3;

	@Mock
	private IncomingService incomingService;
	
	@InjectMocks
	private OutgoingService outgoingService = new OutgoingServiceImpl();
	
    @Test
    public void shouldNotUpdateIncomingWhenQuantityIsZero() {
    	Incoming incoming = Fixture.getOneIncoming(ZERO_QUANTITY);
    	
    	Mockito.when(incomingService.findById((String) Mockito.any())).thenReturn(incoming);
    	
    	Outgoing out = Fixture.getOneOutgoing(TEN_QUANTITY);
		outgoingService.update(out);

		Assert.assertEquals(ZERO_QUANTITY, incoming.getQuantity());
    }
    
    @Test
    public void shouldNotUpdateIncomingWhenQuantityIsLessThanTheCurrentQuantity() {
    	Incoming incoming = Fixture.getOneIncoming(FIVE_QUANTITY);
    	
    	Mockito.when(incomingService.findById((String) Mockito.any())).thenReturn(incoming);
    	
    	Outgoing out = Fixture.getOneOutgoing(TEN_QUANTITY);
		outgoingService.update(out);

		Assert.assertEquals(FIVE_QUANTITY, incoming.getQuantity());
    }
    
    @Test
    public void shouldUpdateIncomingWhenQuantityIsBiggerThanTheCurrentQuantity() {
    	Incoming incoming = Fixture.getOneIncoming(TEN_QUANTITY);
    	
    	Mockito.when(incomingService.findById((String) Mockito.any())).thenReturn(incoming);
    	
    	Outgoing out = Fixture.getOneOutgoing(FIVE_QUANTITY);
		outgoingService.update(out);

		Assert.assertEquals(FIVE_QUANTITY, incoming.getQuantity());
    }
    
    @Test
    public void shouldUpdateIncomingWhenTheQuantityIsCloseToMinQuantity() {
    	Incoming incoming = Fixture.getOneIncoming(TEN_QUANTITY, MIN_QUANTITY);	    	
    	Mockito.when(incomingService.findById((String) Mockito.any())).thenReturn(incoming);
    	
    	Outgoing out = Fixture.getOneOutgoing(THREE_QUANTITY);
		outgoingService.update(out);

		Assert.assertTrue(incoming.isLowerQuantity());
    }

    @Test
    public void shouldUpdateIncomingWhenTheQuantityIsLessThanMinQuantity() {
    	Incoming incoming = Fixture.getOneIncoming(TEN_QUANTITY, MIN_QUANTITY);	    	
    	Mockito.when(incomingService.findById((String) Mockito.any())).thenReturn(incoming);
    	
    	Outgoing out = Fixture.getOneOutgoing(FIVE_QUANTITY);
		outgoingService.update(out);

		Assert.assertTrue(incoming.isLowerQuantity());
    }
}