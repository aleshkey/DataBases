package org.exhibition.lab2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "halls")
public class Hall{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hall_id", nullable = false)
    private int id;

    @Column(name = "hall_name")
    private String name;

    @Column(name = "hall_square")
    private double square;

    @Column(name = "hall_address")
    private String address;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "owner_id", referencedColumnName = "owner_id")
    private Owner owner;
}
