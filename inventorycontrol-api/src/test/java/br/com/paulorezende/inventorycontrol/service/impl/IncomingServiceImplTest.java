package br.com.paulorezende.inventorycontrol.service.impl;

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
import br.com.paulorezende.inventorycontrol.repository.IncomingRepository;
import br.com.paulorezende.inventorycontrol.service.IncomingService;

@RunWith(MockitoJUnitRunner.class)
public class IncomingServiceImplTest {

	private static final String ID_FIND_BY_ID = "1";
	private static final int SIZE_FIND_ALL = 3;

	@Mock
    private IncomingRepository incomingRepository;

    @InjectMocks
    private IncomingService incomingService = new IncomingServiceImpl();

    @Test
    public void shouldSaveNewIncoming() {
        final Incoming incoming = new Incoming();
        incomingService.save(incoming);
        Mockito.verify(incomingRepository, Mockito.times(1)).save(incoming);
    }
    
    @Test
    public void shouldReturnAllIncomings() {
    	Mockito.when(incomingRepository.findAll()).thenReturn(
    			Fixture.getAllIncomings(SIZE_FIND_ALL, 10, 10));
    	
    	List<Incoming> incomings = incomingService.findAll();
    	
    	Assert.assertNotNull(incomings);
    	Assert.assertEquals(SIZE_FIND_ALL, incomings.size());
    }
    
    @Test
    public void shouldReturnNullWhenIncomingNotFindById() {
    	Incoming incoming = incomingService.findById(ID_FIND_BY_ID);
    	Assert.assertNull(incoming);
    }
    
    @Test
    public void shouldReturnIncomingWhenIncomingNotFindById() {
    	
    	Mockito.when(incomingRepository.findById(ID_FIND_BY_ID))
    		.thenReturn(Fixture.getOneIncoming(10));
    	
    	Incoming incoming = incomingService.findById(ID_FIND_BY_ID);
    	
    	Assert.assertNotNull(incoming);
    	Assert.assertEquals(ID_FIND_BY_ID, incoming.getId());
    }

	
}