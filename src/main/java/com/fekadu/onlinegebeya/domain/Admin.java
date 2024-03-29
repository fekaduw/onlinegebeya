package com.fekadu.onlinegebeya.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
