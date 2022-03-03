package com.turkcell.rentacar.entities.concretes;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name =  "car_maintenances")
public class CarMaintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "maintenance_id")
    private int id;
    @Column(name = "maintenance_description")
    private String description;
    @Column(name = "maintenance_returnDate")
    private Date returnDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}

