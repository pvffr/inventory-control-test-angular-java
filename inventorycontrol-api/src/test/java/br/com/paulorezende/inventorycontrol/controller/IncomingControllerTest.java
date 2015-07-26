package br.com.paulorezende.inventorycontrol.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.paulorezende.inventorycontrol.Fixture;
import br.com.paulorezende.inventorycontrol.model.Incoming;
import br.com.paulorezende.inventorycontrol.service.IncomingService;

@RunWith(MockitoJUnitRunner.class)
public class IncomingControllerTest {

    private static final int LIST_QUANTITY = 3;

	@Mock
    private IncomingService incomingService;

    @InjectMocks
    private IncomingController incomingController = new IncomingController();

    @Test
    public void shouldCreateIncoming() throws Exception {
        final Incoming incoming = new Incoming();
        incomingController.post(incoming);
        Mockito.verify(incomingService, Mockito.times(1)).save(incoming);
    }
    
    @Test
    public void shouldListAllIncomings() throws Exception {
    	Mockito.when(incomingService.findAll()).thenReturn(Fixture.getAllIncomings(3, 10, 10));
    	
    	List<Incoming> list = incomingController.list();
    	
    	Assert.assertNotNull(list);
    	Assert.assertEquals(LIST_QUANTITY, list.size());
    }

}