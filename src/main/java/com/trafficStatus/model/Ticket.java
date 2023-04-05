
package com.trafficStatus.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn()
    private User user;

}
