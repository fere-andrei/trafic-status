
package com.trafficStatus.repository;

import com.trafficStatus.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Integer> {


}
