package br.com.paulorezende.inventorycontrol.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import br.com.paulorezende.inventorycontrol.model.Incoming;
import br.com.paulorezende.inventorycontrol.repository.IncomingRepository;

@Component
public class IncomingRepositoryImpl implements IncomingRepository {

	@Autowired
	private MongoOperations mongoOperations;
	
	@Override
	public void save(Incoming incoming) {
		mongoOperations.save(incoming);
	}

	@Override
	public List<Incoming> findAll() {
		return mongoOperations.findAll(Incoming.class);
	}
	
	@Override
	public Incoming findById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoOperations.findOne(query, Incoming.class);
	}
	
}
