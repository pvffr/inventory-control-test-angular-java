package br.com.paulorezende.inventorycontrol.service;

import java.util.List;

import br.com.paulorezende.inventorycontrol.model.Incoming;

public interface IncomingService {

	void save(Incoming incoming);

	List<Incoming> findAll();
	
	Incoming findById(String id);

}
