package org.exhibition.lab2.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "exhibitions")
public class Exhibition implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exhibition_id", nullable = false)
    private int id;

    @Column(name = "exhibition_type")
    private String type;

    @Column(name = "exhibition_date")
    private String date;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "authors_exhibition",
            joinColumns = { @JoinColumn(name = "exhibition_id") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    @JsonManagedReference
    private List<Author> authors;
}
