package com.fekadu.onlinegebeya.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private Boolean isApproved;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private List<Product> products = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "followings")
    private List<Buyer> followers = new ArrayList<>();

    @Transient
    private transient Integer rating;

    public  Integer getRating(){
        int rate = 0;
        int cnt = 0;
        for(Product p:products){
            for(Review r:p.getReviews()){
                rate+=r.getRating();
                cnt++;
            }
        }
        if(cnt>0)
            return rate/cnt;
        return 0;
    }
}
