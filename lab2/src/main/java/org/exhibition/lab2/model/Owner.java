package org.exhibition.lab2.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "owners")
public class Owner implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id", nullable = false)
    private int id;

    @Column(name = "owner_name")
    private String name;

    @Column(name = "owner_address")
    private String address;


    @Column(name = "owner_phone_number")
    private String phoneNumber;


    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    @JsonBackReference
    private List<Hall> halls;

}
