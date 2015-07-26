package br.com.paulorezende.inventorycontrol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.paulorezende.inventorycontrol.model.Incoming;
import br.com.paulorezende.inventorycontrol.repository.IncomingRepository;
import br.com.paulorezende.inventorycontrol.service.IncomingService;

@Service
public class IncomingServiceImpl implements IncomingService {

	@Autowired
	private IncomingRepository incomingRepository;

    @Override
    @Transactional
    public void save(final Incoming incoming) {
    	incomingRepository.save(incoming);
    }

	@Override
	public List<Incoming> findAll() {
		return incomingRepository.findAll();
	}

	@Override
	public Incoming findById(String id) {
		return incomingRepository.findById(id);
	}

}