package org.exhibition.lab2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Data
@Entity
@Table (name = "images")
public class Image implements Model{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "image_id", nullable = false)
    private int id;

    @Column(name = "image_name")
    private String name;

    @Column(name = "image_execution")
    private String execution;

    @Column(name = "image_creation_date")
    private String creationDate;

    @ManyToOne(fetch = FetchType.EAGER)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name = "author_id", referencedColumnName = "author_id")
    @JsonManagedReference
    private Author author;

    @ManyToMany(mappedBy = "images")
    @JsonBackReference
    private List<Exhibition> exhibitions;

}
