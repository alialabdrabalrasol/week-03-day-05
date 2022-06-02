package com.example.week3day5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_id;
    @NotEmpty(message = "username can't be empty")
    private String username;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customerdetails_id")
    @JsonIgnore
    private CustomerDetails customerDetails;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Bank>banks;
}
