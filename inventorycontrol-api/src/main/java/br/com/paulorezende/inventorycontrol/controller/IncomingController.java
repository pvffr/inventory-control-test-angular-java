package br.com.paulorezende.inventorycontrol.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulorezende.inventorycontrol.model.Incoming;
import br.com.paulorezende.inventorycontrol.service.IncomingService;

@RestController
@RequestMapping(value = "incoming")
public class IncomingController {

	@Autowired
    private IncomingService incomingService;

    @RequestMapping(method = RequestMethod.POST)
    public void post(@RequestBody @Valid final Incoming incoming) {
        incomingService.save(incoming);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Incoming> list() {
        return incomingService.findAll();
    }

}
