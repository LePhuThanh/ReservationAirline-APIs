package com.practice.reservationAirline.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String phone;
    @Column(name = "user_name")
    private String userName;
    @JsonIgnore // ignore when change ==> JSON
    private String password;

    //==> Employee
    @OneToOne(mappedBy = "userId") //attribute
    @JsonBackReference
    private Employee employeeId; //employee

    //==> Passenger
    @OneToOne(mappedBy = "userId")
    @JsonBackReference
    private Passenger passengerId; //passenger
    //==> create ticketList
    @OneToMany(mappedBy = "userId")
    @JsonManagedReference
    private List<Ticket> ticketList;
}
