package org.exhibition.lab2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "halls")
public class Hall implements Model{
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
    @JsonManagedReference
    private Owner owner;

    @OneToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "exhibition_id", referencedColumnName = "exhibition_id")
    @JsonManagedReference
    @Nullable
    private Exhibition exhibition;
}
