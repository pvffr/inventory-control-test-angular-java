package br.com.paulorezende.inventorycontrol.repository;

import java.util.List;

import br.com.paulorezende.inventorycontrol.model.Incoming;

public interface IncomingRepository {

	public void save(Incoming incoming);

	public List<Incoming> findAll();

	Incoming findById(String id);
	
}