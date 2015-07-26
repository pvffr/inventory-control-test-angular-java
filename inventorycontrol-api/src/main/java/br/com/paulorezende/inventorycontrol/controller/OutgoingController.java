package br.com.paulorezende.inventorycontrol.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.paulorezende.inventorycontrol.model.Outgoing;
import br.com.paulorezende.inventorycontrol.service.OutgoingService;

@RestController()
@RequestMapping(value = "outgoing")
public class OutgoingController {

	@Autowired
    private OutgoingService outgoingService;

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody @Valid final Outgoing outgoing) {
        outgoingService.update(outgoing);
    }

}
