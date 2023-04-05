
package com.trafficStatus.controller;

import com.trafficStatus.model.Ticket;
import com.trafficStatus.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/getAll")
    public List<Ticket> list(){
        return ticketService.listAll();
    }

    @PostMapping("/add")
    public String add(@RequestBody Ticket ticket){
        ticketService.save(ticket);
        return "New Ticket Added";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> get(@PathVariable Integer id) {
        try {
            Ticket ticket = ticketService.get(id);
            return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> update(@RequestBody Ticket ticket, @PathVariable Integer id){
        try{
            //Ticket existingTicket= ticketService.get(id);
            ticketService.save(ticket);
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (NoSuchElementException e){
            return new ResponseEntity<Ticket>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        ticketService.delete(id);
        return "Deleted TICKET with id "+id;
    }


}
