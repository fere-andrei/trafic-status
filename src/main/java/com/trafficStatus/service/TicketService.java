
package com.trafficStatus.service;

import com.trafficStatus.model.Ticket;
import com.trafficStatus.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

   public List<Ticket> listAll(){
       return ticketRepository.findAll();
   }

   public void save(Ticket ticket){
       ticketRepository.save(ticket);
   }

   public Ticket get(Integer id){
       return ticketRepository.findById(id).get();
   }

   public void delete(Integer id){
       ticketRepository.deleteById(id);
   }
}
