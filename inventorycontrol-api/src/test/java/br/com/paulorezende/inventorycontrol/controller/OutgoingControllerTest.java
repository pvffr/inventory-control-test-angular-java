package br.com.paulorezende.inventorycontrol.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.paulorezende.inventorycontrol.Fixture;
import br.com.paulorezende.inventorycontrol.model.Outgoing;
import br.com.paulorezende.inventorycontrol.service.OutgoingService;

@RunWith(MockitoJUnitRunner.class)
public class OutgoingControllerTest {

	@Mock
    private OutgoingService outgoingService;

    @InjectMocks
    private OutgoingController outgoingController = new OutgoingController();

    @Test
    public void shouldUpdateIncomings() throws Exception {
    	
        Outgoing outgoing = Fixture.getOneOutgoing(10);
        
		outgoingController.update(outgoing);
        
        Mockito.verify(outgoingService, Mockito.times(1)).update(outgoing);
    }
    
}