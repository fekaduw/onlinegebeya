package com.fekadu.onlinegebeya.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

//@Entity
@Embeddable
@Data
public class Account {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    private String cardType;
    private String number;
    private String csv;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate expiryDate;
}
