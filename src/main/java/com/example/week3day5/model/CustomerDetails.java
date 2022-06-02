package com.example.week3day5.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class CustomerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customer_details_id;
    @NotNull(message = "age can't be empty")
    private Integer age;
    @NotNull(message = "balance can't be empty")
    private Integer balance;

    @OneToOne(mappedBy = "customerDetails")
    private Customer customer;
}
