package org.exhibition.lab2.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity(name = "authors")
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_name")
    private String authorName;

    @Column(name = "author_place_of_birth")
    private String authorPlaceOfBirth;

    @Column(name = "author_biography")
    private String authorBiography;

    @Column(name = "author_education")
    private String authorEducation;

    @ManyToMany(mappedBy = "authors")
    private List<Exhibition> exhibitions;

    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Image> images;
}
