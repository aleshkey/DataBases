package org.exhibition.lab2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity(name = "authors")
public class Author implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int id;

    @Column(name = "author_name")
    private String name;

    @Column(name = "author_place_of_birth")
    private String placeOfBirth;

    @Column(name = "author_biography")
    private String biography;

    @Column(name = "author_education")
    private String education;

    @ManyToMany(mappedBy = "authors")
    @JsonBackReference
    private List<Exhibition> exhibitions;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JsonBackReference
    private List<Image> images;
}
